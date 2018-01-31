package cn.lu.mybatis.mapper;

import cn.lu.mybatis.dao.SingleTableMapper;
import cn.lu.mybatis.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * 单表
 *
 * @author lutiehua
 * @date 2018/01/31
 */
@Repository
public interface AccountMapper extends SingleTableMapper<Account> {

}