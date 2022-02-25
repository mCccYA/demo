package com.mcc.g3n.demo.domin.exception;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 调用外部接口异常
 *
 * @author qingxi.ljy
 * @date 2021/12/6 12:01 下午
 */
public class OutsideException extends RuntimeException {

    @Getter
    private Fault fault = null;

    public OutsideException(Fault fault) {
        super(null == fault ? null : (fault.getCode() + ":" + fault.getMessage()));
        this.fault = fault;
    }

    public OutsideException(Fault fault, String message) {
        super(StringUtils.isNotBlank(message) ? message : (fault.getCode() + ":" + fault.getMessage()));
        this.fault = fault;
    }

    public OutsideException(Fault fault, String type, String message) {
        super(StringUtils.isNotBlank(message) ? message : (fault.getMessage()));
        this.fault = fault;
    }

    public OutsideException(Fault fault, String message, Throwable cause) {
        super(null == fault ? message : (fault.getCode() + ":" + fault.getMessage()), cause);
        this.fault = fault;
    }

    public OutsideException(Fault fault, Throwable cause) {
        super(null == fault ? null : (fault.getCode() + ":" + fault.getMessage()), cause);
        this.fault = fault;
    }

    public OutsideException(Fault fault, String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(null == fault ? message : (fault.getCode() + ":" + fault.getMessage()), cause, enableSuppression,
                writableStackTrace);
        this.fault = fault;
    }

    public OutsideException(Fault fault, Integer error, String message) {
        super(StringUtils.isNotBlank(message) ? message : (fault.getMessage()));
        this.fault = new Fault(fault.getModule(), fault.getFunction(), error, message);
    }

}
