package cn.lu.mybatis.vo;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
@Getter
@Setter
@ToString
public class ListResultVO<T> {

    /**
     * 数据总条数
     */
    private Long count;

    /**
     * 一共多少页
     */
    private Integer pageCount;

    /**
     * 当前第几页
     */
    private Integer pageNum;

    /**
     * 当前页数据列表
     */
    private List<T> list;

    public ListResultVO(List<T> data) {
        PageInfo pageInfo = new PageInfo(data);
        setList(data);
        setCount(pageInfo.getTotal());
        setPageNum(pageInfo.getPageNum());
        setPageCount(pageInfo.getPages());
    }
}
