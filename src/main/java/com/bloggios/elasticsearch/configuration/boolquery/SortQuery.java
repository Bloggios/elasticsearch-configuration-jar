package com.bloggios.elasticsearch.configuration.boolquery;

import com.bloggios.elasticsearch.configuration.payload.ListRequest;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - elasticsearch-configuration-jar
 * Package - com.bloggios.elasticsearch.configuration.boolquery
 * Created_on - May 27 - 2024
 * Created_at - 11:56
 */

@Component
public class SortQuery {

    public void initSort(ListRequest listRequest, NativeSearchQueryBuilder nativeSearchQueryBuilder) {
        List<SortBuilder<?>> sortBuilders = new ArrayList<>();
        listRequest.getSort().forEach(esSort -> {
            FieldSortBuilder sortBuilder = SortBuilders.fieldSort(esSort.getSortKey()).order(esSort.getOrder());
            sortBuilders.add(sortBuilder);
        });
        sortBuilders.forEach(nativeSearchQueryBuilder::withSort);
    }
}
