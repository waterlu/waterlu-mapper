package cn.lu.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
@Getter
@Setter
@ToString
public class CreateUserBatchDTO {

    /**
     * 用户起始手机号码
     */
    private Long userMobile;

    /**
     * 用户个数
     *
     */
    private Integer count;

}
