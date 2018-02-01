package com.phizs.framework.core.base.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phizs.framework.core.base.BaseServiceI;
import com.phizs.framework.core.db.DataSourceEnum;
import com.phizs.framework.core.db.DynamicDataSource;

import java.lang.reflect.Method;
import java.util.List;

/**
 * phizs-dubbo-parent
 *
 * @author lyt
 * @date 2018/1/31
 * @github https://github.com/yutaolian
 * @description
 */
public class BaseServiceImpl<Mapper,Record,Example> implements BaseServiceI<Record,Example> {

    private Mapper mapper;

    public int countByExample(Example example) {
        try{
            DynamicDataSource.setDateSource(DataSourceEnum.SLAVER.getName());
            Method countByExample = mapper.getClass().getDeclaredMethod("countByExample");
            Object result = countByExample.invoke(mapper,example);
            return Integer.parseInt(String.valueOf(result));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DynamicDataSource.clearDataSource();
        }
        return 0;
    }

    public List<Record> selectByExample(Example example) {
        try{
            DynamicDataSource.setDateSource(DataSourceEnum.SLAVER.getName());
            Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample");
            Object result = selectByExample.invoke(mapper, example);
            return (List<Record>) result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DynamicDataSource.clearDataSource();
        }
        return null;
    }

    public PageInfo<Record> selectPageInfoByExample(Example example, int pageNum, int pageSize) {
        try{
            PageHelper.startPage(pageNum,pageSize);
            DynamicDataSource.setDateSource(DataSourceEnum.SLAVER.getName());
            Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample");
            Object result = selectByExample.invoke(mapper, example);
            return new PageInfo<Record>((List<Record>) result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DynamicDataSource.clearDataSource();
        }
        return null;
    }
}
