package com.bloggios.elasticsearch.configuration.boolquery;

import com.bloggios.elasticsearch.configuration.payload.ListRequest;
import com.bloggios.elasticsearch.configuration.payload.lspayload.Filter;
import com.bloggios.elasticsearch.configuration.utils.ValueCheckerUtil;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - elasticsearch-configuration-jar
 * Package - com.bloggios.elasticsearch.configuration.boolquery
 * Created_on - May 27 - 2024
 * Created_at - 11:37
 */

@Component
public class FilterQuery {

    public QueryBuilder initFilters(ListRequest listRequest) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (!CollectionUtils.isEmpty(listRequest.getFilters())) {
            listRequest
                    .getFilters()
                    .forEach(filter -> {
                        BoolQueryBuilder nestedApplyFilter = QueryBuilders.boolQuery();
                        BoolQueryBuilder applyFilter = QueryBuilders.boolQuery();
                        filterPartialSearch(filter, applyFilter);
                        if (Objects.nonNull(filter.getNestedPath())) {
                            filterNestedPaths(filter, queryBuilder, nestedApplyFilter);
                        } else {
                            queryBuilder.must(applyFilter);
                        }
                    });
        }
        return queryBuilder;
    }

    private static void filterPartialSearch(Filter filter, BoolQueryBuilder filterOrCheck) {
        if (filter.isPartialSearch()) {
            filter.getSelections().forEach(selection -> {
                QueryBuilder selectionQuery = QueryBuilders.regexpQuery(filter.getFilterKey(), ValueCheckerUtil.getFilterText(selection)).caseInsensitive(true);
                filterOrCheck.should(selectionQuery);
            });
        } else {
            QueryBuilder selectionQuery = QueryBuilders.termsQuery(filter.getFilterKey(), filter.getSelections());
            filterOrCheck.should(selectionQuery);
        }
    }

    private void filterNestedPaths(Filter filter, BoolQueryBuilder queryBuilder, BoolQueryBuilder extendedFilterAndCheck) {
        queryBuilder.must(QueryBuilders.nestedQuery(filter.getNestedPath(), extendedFilterAndCheck, ScoreMode.None));
    }
}
