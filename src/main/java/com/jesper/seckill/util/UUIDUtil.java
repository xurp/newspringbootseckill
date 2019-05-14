package com.jesper.seckill.util;

import java.util.UUID;

/**
 * Created by jiangyunxiong on 2018/5/22.
 * <p>
 * [不同]唯一id生成类,这里直接用静态方法获取
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
