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

package com.bloggios.elasticsearch.configuration.validator.implementation.businessvalidator;

import com.bloggios.elasticsearch.configuration.validator.BusinessValidator;
import com.bloggios.elasticsearch.configuration.constants.ElasticErrorCodes;
import com.bloggios.elasticsearch.configuration.exception.payloads.ElasticsearchException;
import com.bloggios.elasticsearch.configuration.payload.ListRequest;
import com.bloggios.elasticsearch.configuration.utils.ValueCheckerUtil;
import com.bloggios.elasticsearch.configuration.validator.BusinessValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - elasticsearch-configuration-jar
 * Package - com.bloggios.elasticsearch.configuration.validator.implementation.businessvalidator
 * Created_on - May 27 - 2024
 * Created_at - 11:25
 */

@Component
public class ListSortBusinessValidator implements BusinessValidator<ListRequest> {

    @Override
    public void validate(ListRequest listRequest) {

        if (Objects.nonNull(listRequest.getSort()) && !listRequest.getSort().isEmpty()) {
            listRequest
                    .getSort()
                    .forEach(sort -> {
                        if (!ValueCheckerUtil.isValuePresent(sort.getSortKey()))
                            throw new ElasticsearchException(ElasticErrorCodes.SORT_KEY_NOT_PRESENT);
                        else if (sort.getOrder() == null) {
                            throw new ElasticsearchException(ElasticErrorCodes.SORT_ORDER_NOT_PRESENT);
                        }
                    });
        }
    }
}
