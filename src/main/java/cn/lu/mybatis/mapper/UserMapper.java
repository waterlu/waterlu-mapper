package cn.lu.mybatis.mapper;

import cn.lu.mybatis.dao.SingleTableMapper;
import cn.lu.mybatis.entity.User;
import cn.lu.mybatis.mapper2.UserInsertListMapper;
import org.springframework.stereotype.Repository;

/**
 * 单表
 *
 * @author lutiehua
 * @date 2018/01/31
 */
@Repository
public interface UserMapper extends SingleTableMapper<User>, UserInsertListMapper<User> {

}