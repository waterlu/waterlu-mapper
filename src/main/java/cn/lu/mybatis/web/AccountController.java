package cn.lu.mybatis.web;

import cn.lu.mybatis.entity.Account;
import cn.lu.mybatis.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lutiehua
 * @date 2018/1/31
 */
@RestController
@RequestMapping("mapper/account")
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/{accountUuid}")
    public Account getAccount(@PathVariable String accountUuid) {
        Account account = accountMapper.selectByPrimaryKey(accountUuid);
        return account;
    }
}