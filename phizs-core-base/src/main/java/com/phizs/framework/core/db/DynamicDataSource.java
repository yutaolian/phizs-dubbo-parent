package com.phizs.framework.core.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * phizs-dubbo-parent
 *
 * @author lyt
 * @date 2018/1/31
 * @github https://github.com/yutaolian
 * @description
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final  ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    protected Object determineCurrentLookupKey() {
        String dataSource = getDataSource();
        return dataSource;
    }

    public static void setDateSource(String dateSource){
        contextHolder.set(dateSource);
    }

    public static String getDataSource(){
        String dataSource = contextHolder.get();
        if (null == dataSource){
            DynamicDataSource.setDateSource(DataSourceEnum.MASTER.getDefault());
        }
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}
