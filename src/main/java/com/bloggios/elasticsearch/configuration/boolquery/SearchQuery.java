package com.bloggios.elasticsearch.configuration.boolquery;

import com.bloggios.elasticsearch.configuration.payload.ListRequest;
import com.bloggios.elasticsearch.configuration.payload.lspayload.SearchFilter;
import com.bloggios.elasticsearch.configuration.utils.ValueCheckerUtil;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.InnerHitBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - elasticsearch-configuration-jar
 * Package - com.bloggios.elasticsearch.configuration.boolquery
 * Created_on - May 27 - 2024
 * Created_at - 11:46
 */

@Component
public class SearchQuery {

    public QueryBuilder initSearch(ListRequest listRequest) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (!CollectionUtils.isEmpty(listRequest.getTexts())) {
            listRequest
                    .getTexts()
                    .forEach(searchText -> {
                        BoolQueryBuilder applyFilterAndCheck = QueryBuilders.boolQuery();
                        listRequest
                                .getField()
                                .forEach(searchFiled -> {
                                    QueryBuilder query = null;
                                    query = getQueryBuilderFromPartialSearch(searchText, searchFiled);
                                    query = nestedPathSearchField(searchFiled, query);
                                    applyFilterAndCheck.should(query);
                                });
                        queryBuilder.must(applyFilterAndCheck);
                    });
        }
        return queryBuilder;
    }

    private QueryBuilder getQueryBuilderFromPartialSearch(String searchText, SearchFilter searchFiled) {
        QueryBuilder selectionQuery;
        if (searchFiled.isPartialSearch())
            selectionQuery = QueryBuilders.regexpQuery(searchFiled.getField(), ValueCheckerUtil.getFilterText(searchText)).caseInsensitive(true);
        else selectionQuery = QueryBuilders.matchPhraseQuery(searchFiled.getField(), searchText);
        return selectionQuery;
    }

    private QueryBuilder nestedPathSearchField(SearchFilter searchFiled, QueryBuilder selectionQuery) {
        if (Objects.nonNull(searchFiled.getNestedPath())) {
            selectionQuery = QueryBuilders.nestedQuery(searchFiled.getNestedPath(), selectionQuery, ScoreMode.None);
        }
        return selectionQuery;
    }
}
