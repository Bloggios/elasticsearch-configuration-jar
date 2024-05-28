/*
 * Copyright © 2023-2024 Rohit Parihar and Bloggios
 * All rights reserved.
 * This software is the property of Rohit Parihar and is protected by copyright law.
 * The software, including its source code, documentation, and associated files, may not be used, copied, modified, distributed, or sublicensed without the express written consent of Rohit Parihar.
 * For licensing and usage inquiries, please contact Rohit Parihar at rohitparih@gmail.com, or you can also contact support@bloggios.com.
 * This software is provided as-is, and no warranties or guarantees are made regarding its fitness for any particular purpose or compatibility with any specific technology.
 * For license information and terms of use, please refer to the accompanying LICENSE file or visit http://www.apache.org/licenses/LICENSE-2.0.
 * Unauthorized use of this software may result in legal action and liability for damages.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bloggios.elasticsearch.configuration.validator.implementation.independent;

import com.bloggios.elasticsearch.configuration.payload.ListRequest;
import com.bloggios.elasticsearch.configuration.validator.BusinessValidator;
import com.bloggios.elasticsearch.configuration.validator.ValidatorList;
import com.bloggios.elasticsearch.configuration.validator.implementation.businessvalidator.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - auth-provider-application
 * Package - com.bloggios.auth.provider.validator.exhibitorimplementation
 * Created_on - 13 January-2024
 * Created_at - 14 : 01
 */

@Component
public class ListRequestValidatorListInitiator implements ValidatorList<ListRequest> {

    private final FilterBusinessValidator filterBusinessValidator;
    private final SearchFilterBusinessValidator searchFilterBusinessValidator;
    private final SearchTextBusinessValidator searchTextBusinessValidator;
    private final ListSortBusinessValidator listSortBusinessValidator;
    private final PageSizeBusinessValidator pageSizeBusinessValidator;
    private final PageBusinessValidator pageBusinessValidator;
    private final TotalElementsSizeBusinessValidator totalElementsSizeBusinessValidator;
    private final SearchTextNgramBusinessValidator searchTextNgramBusinessValidator;
    private final SearchNGramFilterBusinessValidator searchNGramFilterBusinessValidator;

    public ListRequestValidatorListInitiator(
            FilterBusinessValidator filterBusinessValidator,
            SearchFilterBusinessValidator searchFilterBusinessValidator,
            SearchTextBusinessValidator searchTextBusinessValidator,
            ListSortBusinessValidator listSortBusinessValidator,
            PageSizeBusinessValidator pageSizeBusinessValidator,
            PageBusinessValidator pageBusinessValidator,
            TotalElementsSizeBusinessValidator totalElementsSizeBusinessValidator,
            SearchTextNgramBusinessValidator searchTextNgramBusinessValidator,
            SearchNGramFilterBusinessValidator searchNGramFilterBusinessValidator
    ) {
        this.filterBusinessValidator = filterBusinessValidator;
        this.searchFilterBusinessValidator = searchFilterBusinessValidator;
        this.searchTextBusinessValidator = searchTextBusinessValidator;
        this.listSortBusinessValidator = listSortBusinessValidator;
        this.pageSizeBusinessValidator = pageSizeBusinessValidator;
        this.pageBusinessValidator = pageBusinessValidator;
        this.totalElementsSizeBusinessValidator = totalElementsSizeBusinessValidator;
        this.searchTextNgramBusinessValidator = searchTextNgramBusinessValidator;
        this.searchNGramFilterBusinessValidator = searchNGramFilterBusinessValidator;
    }

    @Override
    public List<BusinessValidator<ListRequest>> provideValidation() {
        return List.of(
                filterBusinessValidator,
                searchFilterBusinessValidator,
                searchTextBusinessValidator,
                listSortBusinessValidator,
                pageSizeBusinessValidator,
                pageBusinessValidator,
                totalElementsSizeBusinessValidator,
                searchTextNgramBusinessValidator,
                searchNGramFilterBusinessValidator
        );
    }
}
