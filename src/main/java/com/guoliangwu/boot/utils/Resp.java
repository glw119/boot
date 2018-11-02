package com.guoliangwu.boot.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liangwu
 * @Date 18-11-2 上午11:54
 */
public class Resp extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Resp() {
        put("code", 0);
        put("msg", "success");
    }

    public static Resp error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static Resp error(String msg) {
        return error(500, msg);
    }

    public static Resp error(int code, String msg) {
        Resp r = new Resp();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Resp ok(String msg) {
        Resp r = new Resp();
        r.put("msg", msg);
        return r;
    }

    public static Resp ok(Map<String, Object> map) {
        Resp r = new Resp();
        r.putAll(map);
        return r;
    }

    public static Resp ok() {
        return new Resp();
    }

    @Override
    public Resp put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
