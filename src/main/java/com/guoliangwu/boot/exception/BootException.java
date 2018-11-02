package com.guoliangwu.boot.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author liangwu
 * @Date 18-11-2 上午11:57
 */
@Getter
@Setter
public class BootException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BootException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BootException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BootException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BootException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
