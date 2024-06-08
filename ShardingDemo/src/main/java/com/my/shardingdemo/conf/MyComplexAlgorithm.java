package com.my.shardingdemo.conf;

import com.google.common.collect.Range;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.sharding.exception.UnsupportedShardingOperationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

/**
 * 自定义复合分片算法
 */

public class MyComplexAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    private static final String SHARING_COLUMNS_KEY = "sharing-columns";
    private Properties pros;
    private Collection<String> sharingColumns;
    @Override public void init(Properties properties) {
        this.pros = properties;
        sharingColumns = (Collection<String>) properties.get(SHARING_COLUMNS_KEY);
    }

    /**
     * @param collection 在actual-nodes中配置了所有的数据分片（真实分表）
     * @param complexKeysShardingValue 组合分片键
     * @return 目标分片
     */
    @Override public Collection<String> doSharding(Collection<String> collection,
            ComplexKeysShardingValue<Long> complexKeysShardingValue) {
        Collection<Long> cidCol = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("cid");
        Range<Long> userIdRange = complexKeysShardingValue.getColumnNameAndRangeValuesMap().get("user_cid");
        // 拿到user_id的查询范围
        Long lowerEndpoint = userIdRange.lowerEndpoint();
        Long upperEndpoint = userIdRange.upperEndpoint();
        // 如果下限 >= 上限
        if (lowerEndpoint >= upperEndpoint) {
            throw new UnsupportedShardingOperationException("user_id的查询范围不合法", "course");
        } else {
            ArrayList<String> result = new ArrayList<>();
            String logicTableName = complexKeysShardingValue.getLogicTableName(); // 逻辑表名 course
            for (Long cid : cidCol) {
                // 遍历要查询的分片参数，来选择不同的分片
                String targetTable = logicTableName + "_" + (cid%2 + 1);
                if (collection.contains(targetTable)) {
                    result.add(targetTable);
                }
            }
            return result;
        }
    }

    @Override public Properties getProps() {
        return null;
    }

    @Override public String getType() {
        return ComplexKeysShardingAlgorithm.super.getType();
    }

    @Override public Collection<String> getTypeAliases() {
        return ComplexKeysShardingAlgorithm.super.getTypeAliases();
    }
}
