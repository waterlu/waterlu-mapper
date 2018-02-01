package cn.lu.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
@Getter
@Setter
@ToString
public class CreateAccountBatchDTO {

    /**
     * 用户起始手机号码
     */
    @NotNull
    private Long userId;

    /**
     * 用户个数
     *
     */
    @NotNull
    private Integer count;

}
