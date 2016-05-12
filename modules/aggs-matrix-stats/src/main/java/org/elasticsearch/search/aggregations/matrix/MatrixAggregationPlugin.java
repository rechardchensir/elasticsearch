/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.aggregations.matrix;

import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.search.SearchModule;
import org.elasticsearch.search.aggregations.matrix.stats.InternalMatrixStats;
import org.elasticsearch.search.aggregations.matrix.stats.MatrixStatsAggregatorBuilder;
import org.elasticsearch.search.aggregations.matrix.stats.MatrixStatsParser;

import java.io.IOException;

public class MatrixAggregationPlugin extends Plugin {
    static {
        InternalMatrixStats.registerStreams();
    }

    public MatrixAggregationPlugin() throws IOException {
    }

    @Override
    public String name() {
        return "aggs-matrix-stats";
    }

    @Override
    public String description() {
        return "Adds aggregations whose input are a list of numeric fields and output includes a matrix.";
    }

    public void onModule(SearchModule searchModule) {
        searchModule.registerAggregation(MatrixStatsAggregatorBuilder::new, new MatrixStatsParser(),
            MatrixStatsAggregatorBuilder.AGGREGATION_NAME_FIELD);
    }
}
