/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vladmihalcea.concurrent.service.impl;

import com.vladmihalcea.concurrent.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl - ProductService Impl
 *
 * @author Vlad Mihalcea
 */
@Service
public class BaseServiceImpl implements BaseService {

    private volatile int calls = 0;

    protected void incrementCalls() {
        calls++;
    }

    @Override
    public int getRegisteredCalls() {
        return calls;
    }
}
