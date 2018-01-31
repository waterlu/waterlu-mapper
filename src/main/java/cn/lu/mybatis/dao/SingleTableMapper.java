package cn.lu.mybatis.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 单表基类
 *
 * @author lutiehua
 * @date 2018/1/31
 */
public interface SingleTableMapper<T> extends Mapper<T>, InsertListMapper<T> {
}