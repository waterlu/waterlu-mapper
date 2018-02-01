package cn.lu.mybatis.mapper2;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
public interface UserInsertListMapper<T> {

    /**
     * 批量写入
     *
     * keyProperty = "userId"，指定自增主键属性名称，其他的都不用修改
     *
     * @param recordList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);
}