package com.bloggios.elasticsearch.configuration.boolquery;

import com.bloggios.elasticsearch.configuration.constants.ElasticServiceConstants;
import com.bloggios.elasticsearch.configuration.payload.ListRequest;
import com.bloggios.elasticsearch.configuration.payload.lspayload.SearchFilterNgram;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - elasticsearch-configuration-jar
 * Package - com.bloggios.elasticsearch.configuration.boolquery
 * Created_on - May 27 - 2024
 * Created_at - 11:49
 */

@Component
public class SearchNGramsQuery {

    public QueryBuilder initSearchNGrams(ListRequest listRequest) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (!CollectionUtils.isEmpty(listRequest.getSearchTextsNgram())) {
            listRequest
                    .getSearchTextsNgram()
                    .forEach(searchText -> {
                        BoolQueryBuilder applyFilterAndCheck = QueryBuilders.boolQuery();
                        listRequest
                                .getSearchFieldsNgram()
                                .forEach(field -> {
                                    QueryBuilder query = null;
                                    query = nGramPartialSearch(searchText, field);
                                    if (null != field.getNestedPath()) {
                                        query = QueryBuilders.nestedQuery(field.getNestedPath(), query, ScoreMode.None);
                                    }
                                    applyFilterAndCheck.should(query);
                                });
                        queryBuilder.must(applyFilterAndCheck);
                    });
        }
        return queryBuilder;
    }

    private static QueryBuilder nGramPartialSearch(String searchText, SearchFilterNgram searchFieldNgram) {
        QueryBuilder selectionQuery;
        if (searchFieldNgram.isPartialSearch()) {
            String searchTextLimit = searchText;
            if (searchText.length() > ElasticServiceConstants.TEN) {
                searchTextLimit = searchText.substring(ElasticServiceConstants.ZERO, ElasticServiceConstants.TEN);
            }
            selectionQuery = QueryBuilders.matchQuery(searchFieldNgram.getField(), searchTextLimit).fuzziness(Fuzziness.TWO).operator(Operator.AND);
        } else {
            selectionQuery = QueryBuilders.matchPhraseQuery(searchFieldNgram.getField(), searchText);
        }
        return selectionQuery;
    }
}
