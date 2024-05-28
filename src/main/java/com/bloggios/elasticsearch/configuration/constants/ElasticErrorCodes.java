package com.bloggios.elasticsearch.configuration.constants;

import lombok.experimental.UtilityClass;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - elasticsearch-configuration-jar
 * Package - com.bloggios.elasticsearch.configuration.constants
 * Created_on - May 27 - 2024
 * Created_at - 11:08
 */

@UtilityClass
public class ElasticErrorCodes {

    public static final String FILTER_KEY_NOT_PRESENT = "ES__ESLS-5001";
    public static final String FILTER_KEY_TYPE_MANDATORY = "ES__ESLS-5002";
    public static final String INVALID_SELECTION_DATATYPE_BOOLEAN = "ES__ESLS-5003";
    public static final String INVALID_SELECTION_DATATYPE_DATETIME = "ES__ESLS-5004";
    public static final String INVALID_SELECTION_DATATYPE_DOUBLE = "ES__ESLS-5005";
    public static final String INVALID_SELECTION_DATATYPE_INTEGER = "ES__ESLS-5006";
    public static final String INVALID_SELECTION_DATATYPE_LONG = "ES__ESLS-5007";
    public static final String BOTH_PAGE_SIZE_MANDATORY = "ES__ESLS-5008";
    public static final String PAGE_SIZE_LIMIT_EXCEED = "ES__ESLS-5009";
    public static final String PAGE_LESS_THAN_ZERO = "ES__ESLS-5010";
    public static final String MIN_RANGE_DATE_TIME_NOT_VALID = "ES__ESLS-5011";
    public static final String MAX_RANGE_DATE_TIME_NOT_VALID = "ES__ESLS-5012";
    public static final String MIN_RANGE_INVALID_DOUBLE_TYPE = "ES__ESLS-5014";
    public static final String MAX_RANGE_INVALID_DOUBLE_TYPE = "ES__ESLS-5015";
    public static final String MIN_RANGE_INVALID_INTEGER_TYPE = "ES__ESLS-5016";
    public static final String MAX_RANGE_INVALID_INTEGER_TYPE = "ES__ESLS-5017";
    public static final String RANGE_FILTER_KEY_NOT_PRESENT = "ES__ESLS-5018";
    public static final String RANGE_FILTER_KEY_TYPE_NOT_PRESENT = "ES__ESLS-5019";
    public static final String MIN_MAX_MANDATORY_RANGE_FILTER = "ES__ESLS-5020";
    public static final String INVALID_SELECTION_FOR_OPERATOR = "ES__ESLS-5021";
    public static final String MAX_SHOULD_EMPTY_FOR_NE_OPERATOR = "ES__ESLS-5022";
    public static final String SEARCH_FILTER_WITH_EMPTY_FIELD = "ES__ESLS-5023";
    public static final String FIELD_NOT_PRESENT_FOR_SEARCHING_NGRAM = "ES__ESLS-5024";
    public static final String NGRAM_SEARCH_TEXT_EMPTY = "ES__ESLS-5025";
    public static final String SEARCH_TEXT_EMPTY = "ES__ESLS-5026";
    public static final String SIZE_NOT_GREATER_THAN_ZERO = "ES__ESLS-5027";
    public static final String SORT_KEY_NOT_PRESENT = "ES__ESLS-5028";
    public static final String SORT_ORDER_NOT_PRESENT = "ES__ESLS-5029";
    public static final String ELASTIC_INTERNAL_ERROR = "ES__ESLS-5030";
}
