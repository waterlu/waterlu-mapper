package cn.lu.mybatis.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
public interface UserBatchInsertMapper<T> {

    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int batchInsert(List<T> recordList);

}