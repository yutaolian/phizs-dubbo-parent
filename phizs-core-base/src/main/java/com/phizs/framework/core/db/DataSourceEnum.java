package com.phizs.framework.core.db;

/**
 *
 */
public enum DataSourceEnum {

    MASTER("masterDataBase",true),

    SLAVER("slaveDataSource",false);

    private String name;

    private boolean master;

    DataSourceEnum(String name,boolean master){
        this.name = name;
        this.master = master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public String getDefault(){
        String defaultDataSource = "";
        for (DataSourceEnum dataSourceEnum : DataSourceEnum.values()){
            if (dataSourceEnum.master){
                defaultDataSource = dataSourceEnum.getName();
            }
        }
        return defaultDataSource;
    }
}
