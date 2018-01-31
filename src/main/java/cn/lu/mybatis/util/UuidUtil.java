package cn.lu.mybatis.util;

import java.util.UUID;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
public class UuidUtil {

    public static String getUuid() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid;
    }
}
