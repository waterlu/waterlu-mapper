package cn.lu.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 实体类
 *
 * @author lutiehua
 * @date 2018/1/31
 */
@Getter
@Setter
@ToString
@Table(name = "test_user")
public class User {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机
     */
    @Column(name = "user_mobile")
    private String userMobile;

    /**
     * 删除标记
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}
