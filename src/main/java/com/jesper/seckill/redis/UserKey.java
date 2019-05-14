package com.jesper.seckill.redis;

/**
 * Created by jiangyunxiong on 2018/5/21.
 */
public class UserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*24 *2;//默认两天

    /**
     * [不同]防止被外面实例化
     */
    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * [不同]两个静态变量,原作者:需要缓存的字段
     */
    public static UserKey token = new UserKey(TOKEN_EXPIRE,"token");
    public static UserKey getById = new UserKey(0, "id");

}
