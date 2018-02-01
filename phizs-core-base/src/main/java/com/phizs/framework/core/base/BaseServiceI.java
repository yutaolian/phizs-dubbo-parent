package com.phizs.framework.core.base;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * BaseServiceI
 *
 * @author lianyutao
 * @date 2018/1/31
 * @github https://github.com/yutaolian
 */
public interface BaseServiceI<Record,Example> {

    int countByExample(Example example);

    List<Record> selectByExample(Example example);

    PageInfo<Record> selectPageInfoByExample(Example example,int pageNum ,int pageSize);

}
