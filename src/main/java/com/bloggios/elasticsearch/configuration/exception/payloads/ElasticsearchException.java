package com.bloggios.elasticsearch.configuration.exception.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - elasticsearch-configuration-jar
 * Package - com.bloggios.elasticsearch.configuration.exception
 * Created_on - May 27 - 2024
 * Created_at - 11:21
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElasticsearchException extends RuntimeException {

    private String code;
}
