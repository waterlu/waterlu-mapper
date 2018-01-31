package cn.lu.mybatis.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;

/**
 * 实体类基类
 *
 * @author lutiehua
 * @date 2018/1/31
 */
@Getter
@Setter
@ToString
public class Entity {
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

    /**
     * 默认构造函数
     */
    public Entity() {
        Date now = new Date();
        deleteFlag = 0;
        createTime = now;
        updateTime = now;
    }

}
