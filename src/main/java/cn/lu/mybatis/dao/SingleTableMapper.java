package cn.lu.mybatis.dao;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * 单表基类
 *
 * @author lutiehua
 * @date 2018/1/31
 */
public interface SingleTableMapper<T> extends BaseMapper<T>,
        RowBoundsMapper<T> {

}