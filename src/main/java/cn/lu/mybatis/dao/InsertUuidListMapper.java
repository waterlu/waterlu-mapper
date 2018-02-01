package cn.lu.mybatis.dao;


import org.apache.ibatis.annotations.InsertProvider;

import java.util.List;

/**
 * @author lutiehua
 * @date 2018/2/1
 */
public interface InsertUuidListMapper<T> {

    @InsertProvider(type = WaterluProvider.class, method = "dynamicSQL")
    int insertUuidList(List<T> recordList);
}