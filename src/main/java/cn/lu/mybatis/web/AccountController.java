package cn.lu.mybatis.web;

import cn.lu.mybatis.dto.CreateAccountBatchDTO;
import cn.lu.mybatis.dto.CreateAccountDTO;
import cn.lu.mybatis.dto.QueryParamDTO;
import cn.lu.mybatis.entity.Account;
import cn.lu.mybatis.exception.SQLException;
import cn.lu.mybatis.mapper.AccountMapper;
import cn.lu.mybatis.util.UuidUtil;
import cn.lu.mybatis.vo.ListResultVO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 根据主键查询 SelectByPrimaryKeyMapper
     *
     * @param accountUuid
     * @return
     */
    @GetMapping("/{accountUuid}")
    public Account getAccount(@PathVariable String accountUuid) {
        Account account = accountMapper.selectByPrimaryKey(accountUuid);
        return account;
    }

    /**
     * 写入
     *
     * @return
     */
    @PostMapping("")
    public Account create(@RequestBody @Valid CreateAccountDTO accountDTO) throws Exception {
        Account account = new Account();
        account.setAccountStatus(1);
        account.setAccountType("21");
        account.setAccountUuid(UuidUtil.getUuid());
        account.setUserId(accountDTO.getUserId());
        int row = accountMapper.insertSelective(account);
        if (row == 1) {
            return account;
        } else {
            throw new SQLException();
        }
    }

    /**
     * 批量写入
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    public List<Account> createBatch(@RequestBody @Valid CreateAccountBatchDTO accountBatchDTO) throws Exception {
        List<Account> accountList = new ArrayList<>();
        for (int i=0; i<accountBatchDTO.getCount().intValue(); i++) {
            Account account = new Account();
            account.setAccountStatus(1);
            account.setAccountType("21");
            account.setAccountUuid(UuidUtil.getUuid());
            long userId = accountBatchDTO.getUserId() + i;
            account.setUserId(userId);
            accountList.add(account);
        }

        // insertList() 批量写入，主键是自增ID，数据库自动生成
        // insertUuidList() 批量写入，主键不是自增ID，需要自己设置值
        int row = accountMapper.insertUuidList(accountList);
        if (row > 0) {
            return accountList;
        } else {
            throw new SQLException();
        }
    }

    /**
     * 常用查询，支持排序和分页
     *
     */
    @GetMapping("/query")
    public ListResultVO<Account> retrieve(QueryParamDTO param) {
        // 这里需要指定实体类
        Example condition = new Example(Account.class);

        // 创建查询条件
        Example.Criteria criteria = condition.createCriteria();

        // 拼接查询条件
        // 支持链式调用
        // 使用实体类的属性名称
        criteria.andEqualTo("accountType", "21").andEqualTo("accountStatus", 1);

        // 分页
        // 注意：必须在pom中引入pagehelper-spring-boot-starter，这样才会插入LIMIT语句
        // 默认的实现方式是先读取所有数据，然后再截取，太垃圾
        // pagehelper.offset-as-page-num=false，默认false，表示offset,limit，true表示pageNum,pageSize
        // pagehelper.row-bounds-with-count=true，表示先select count()，默认false，不查询count
        RowBounds rowBounds = new RowBounds(param.getStartRow(), param.getPageSize());

        // 排序
        // 使用表的字段名称
        condition.setOrderByClause("account_amount desc, account_uuid asc");

        // 封装ListResultVO
        List<Account> list = accountMapper.selectByExampleAndRowBounds(condition, rowBounds);
        ListResultVO<Account> resultVO = new ListResultVO(list);

        return resultVO;
    }


}