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

import com.vladmihalcea.concurrent.Retry;
import com.vladmihalcea.concurrent.exception.OptimisticLockingException;
import com.vladmihalcea.concurrent.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ItemServiceImpl - ItemService Impl
 *
 * @author Vlad Mihalcea
 */
@Service
public class ItemServiceImpl extends BaseServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Override
    @Retry(times = 2, on = OptimisticLockingException.class)
    @Transactional
    public void saveItem() {
        incrementCalls();
        LOGGER.info("Save Item!");
        throw new OptimisticLockingException("Save Item!");
    }

    @Override
    @Retry(times = 2, on = OptimisticLockingException.class, failInTransaction = false)
    @Transactional
    public void saveItems() {
        incrementCalls();
        LOGGER.info("Save Items!");
        throw new OptimisticLockingException("Save Items!");
    }
}
