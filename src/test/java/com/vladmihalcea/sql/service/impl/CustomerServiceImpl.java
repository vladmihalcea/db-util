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

package com.vladmihalcea.sql.service.impl;

import com.vladmihalcea.sql.service.CustomerService;
import net.ttddyy.dsproxy.QueryCount;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl - CustomerService Impl
 *
 * @author Vlad Mihalcea
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public void saveCustomerSuccess() {
        QueryCount queryCount = new QueryCount();
        queryCount.setSelect(5);
        queryCount.setInsert(4);
        queryCount.setUpdate(3);
        queryCount.setDelete(2);
        QueryCountHolder.put("dataSource", queryCount);
        LOGGER.info("Save Customer Success!");
    }

    @Override
    public void saveCustomerSelectFailure() {
        QueryCount queryCount = new QueryCount();
        queryCount.setSelect(3);
        QueryCountHolder.put("dataSource", queryCount);
        LOGGER.info("Save Customer Select Failure!");
    }

    @Override
    public void saveCustomerInsertFailure() {
        QueryCount queryCount = new QueryCount();
        queryCount.setInsert(3);
        QueryCountHolder.put("dataSource", queryCount);
        LOGGER.info("Save Customer Insert Failure!");
    }

    @Override
    public void saveCustomerUpdateFailure() {
        QueryCount queryCount = new QueryCount();
        queryCount.setUpdate(3);
        QueryCountHolder.put("dataSource", queryCount);
        LOGGER.info("Save Customer Update Failure!");
    }

    @Override
    public void saveCustomerDeleteFailure() {
        QueryCount queryCount = new QueryCount();
        queryCount.setDelete(3);
        QueryCountHolder.put("dataSource", queryCount);
        LOGGER.info("Save Customer Delete Failure!");
    }
}
