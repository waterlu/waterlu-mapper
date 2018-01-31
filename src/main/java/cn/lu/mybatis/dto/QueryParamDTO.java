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
public class QueryParamDTO {

    /**
     * 第几页
     */
    private Integer startRow;

    /**
     * 每页最多都少条
     */
    private Integer pageSize;

}
