package cn.lu.mybatis.entity;

import cn.lu.mybatis.dao.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 实体类
 *
 * @author lutiehua
 * @date 2018/1/31
 */
@Getter
@Setter
@ToString
public class Account extends Entity {
    /**
     * 账户UUID
     */
    @Id
    @Column(name = "account_uuid")
    private String accountUuid;

    /**
     * 用户UUID
     */
    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 账户类型
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 账户状态
     */
    @Column(name = "account_status")
    private Integer accountStatus;

    /**
     * 账户余额
     */
    @Column(name = "account_amount")
    private BigDecimal accountAmount;

    /**
     * 账户可用余额
     */
    @Column(name = "account_cash_amount")
    private BigDecimal accountCashAmount;

    /**
     * 账户冻结金额
     */
    @Column(name = "account_freeze_amount")
    private BigDecimal accountFreezeAmount;

}
