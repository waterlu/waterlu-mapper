package cn.lu.mybatis.entity;

import cn.lu.mybatis.dao.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
@Getter
@Setter
@ToString
@Table(name = "test_user")
public class User extends Entity {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机
     */
    private String userMobile;

}
