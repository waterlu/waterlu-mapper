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
public class CreateUserDTO {

    /**
     * 用户名
     *
     */
    private String userName;

    /**
     * 用户手机
     */
    private String userMobile;
}
