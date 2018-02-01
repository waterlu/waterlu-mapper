package cn.lu.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author lutiehua
 * @date 2018/2/1
 */
@Getter
@Setter
@ToString
public class UpdateAccountDTO {

    /**
     * 总余额
     */
    private BigDecimal accountAmount;

    /**
     * 可用余额
     */
    private BigDecimal accountCashAmount;

}
