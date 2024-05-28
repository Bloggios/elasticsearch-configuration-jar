package com.bloggios.elasticsearch.configuration.elasticdao;

import com.bloggios.elasticsearch.configuration.boolquery.FilterQuery;
import com.bloggios.elasticsearch.configuration.boolquery.SearchNGramsQuery;
import com.bloggios.elasticsearch.configuration.boolquery.SearchQuery;
import com.bloggios.elasticsearch.configuration.boolquery.SortQuery;
import com.bloggios.elasticsearch.configuration.enums.ListRequestType;
import com.bloggios.elasticsearch.configuration.payload.ListRequest;
import com.bloggios.elasticsearch.configuration.utils.ElasticAsyncUtils;
import com.bloggios.elasticsearch.configuration.utils.ValueCheckerUtil;
import com.bloggios.elasticsearch.configuration.validator.implementation.independent.ListRequestValidateServiceImplementation;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - elasticsearch-configuration-jar
 * Package - com.bloggios.elasticsearch.configuration.elasticdao
 * Created_on - May 27 - 2024
 * Created_at - 11:54
 */

@Component
public class ElasticQuery {

    private final FilterQuery filterQuery;
    private final SearchNGramsQuery searchNGramsQuery;
    private final SearchQuery searchQuery;
    private final SortQuery sortQuery;
    private final ListRequestValidateServiceImplementation listRequestValidateServiceImplementation;

    public ElasticQuery(
            FilterQuery filterQuery,
            SearchNGramsQuery searchNGramsQuery,
            SearchQuery searchQuery,
            SortQuery sortQuery,
            ListRequestValidateServiceImplementation listRequestValidateServiceImplementation
    ) {
        this.filterQuery = filterQuery;
        this.searchNGramsQuery = searchNGramsQuery;
        this.searchQuery = searchQuery;
        this.sortQuery = sortQuery;
        this.listRequestValidateServiceImplementation = listRequestValidateServiceImplementation;
    }

    public NativeSearchQuery build(ListRequest listRequest) {
        return getQueryBuilder(listRequest).build();
    }

    public NativeSearchQueryBuilder getQueryBuilder(ListRequest listRequest) {
        listRequestValidateServiceImplementation.validate(listRequest, ListRequestType.ELASTICSEARCH);
        BoolQueryBuilder initBoolQuery = null;
        NativeSearchQueryBuilder query = new NativeSearchQueryBuilder();
        initBoolQuery = getMust(listRequest);
        query.withQuery(initBoolQuery).withTrackTotalHits(Boolean.TRUE);
        if (ValueCheckerUtil.isValuesPresent(listRequest.getPage(), listRequest.getSize())) {
            query.withPageable(initPageable(listRequest));
        }
        if (Objects.nonNull(listRequest.getSort()) && !listRequest.getSort().isEmpty()) {
            sortQuery.initSort(listRequest, query);
        }
        return query;
    }

    private BoolQueryBuilder getMust(ListRequest listRequest) {
        CompletableFuture<QueryBuilder> filtersFuture = CompletableFuture.supplyAsync(() -> filterQuery.initFilters(listRequest));
        CompletableFuture<QueryBuilder> searchFuture = CompletableFuture.supplyAsync(() -> searchQuery.initSearch(listRequest));
        CompletableFuture<QueryBuilder> ngramFuture = CompletableFuture.supplyAsync(() -> searchNGramsQuery.initSearchNGrams(listRequest));
        ElasticAsyncUtils.getAsyncResult(CompletableFuture.allOf(filtersFuture, searchFuture, ngramFuture));
        return QueryBuilders
                .boolQuery()
                .must(filtersFuture.join())
                .must(searchFuture.join())
                .must(ngramFuture.join());
    }

    public org.springframework.data.domain.Pageable initPageable(ListRequest listRequest) {
        return PageRequest.of(listRequest.getPage(), listRequest.getSize());
    }
}
