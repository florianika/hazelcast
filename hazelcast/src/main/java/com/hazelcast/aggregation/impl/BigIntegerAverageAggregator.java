/*
 * Copyright (c) 2008-2017, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.aggregation.impl;

import com.hazelcast.aggregation.Aggregator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerAverageAggregator<I> extends AbstractAggregator<I, BigDecimal> {

    private BigInteger sum = BigInteger.ZERO;
    private long count;

    public BigIntegerAverageAggregator() {
        super();
    }

    public BigIntegerAverageAggregator(String attributePath) {
        super(attributePath);
    }

    @Override
    public void accumulate(I entry) {
        count++;

        BigInteger extractedValue = (BigInteger) extract(entry);
        sum = sum.add(extractedValue);
    }

    @Override
    public void combine(Aggregator aggregator) {
        BigIntegerAverageAggregator typedAggregator = (BigIntegerAverageAggregator) aggregator;
        this.sum = this.sum.add(typedAggregator.sum);
        this.count += typedAggregator.count;
    }

    @Override
    public BigDecimal aggregate() {
        if (count == 0) {
            return null;
        }
        return new BigDecimal(sum)
                .divide(BigDecimal.valueOf(count));
    }

}
