package com.mcc.g3n.demo.domin.exception;


/**
 * 异常错误类
 *
 * @author wanqi.wq
 */
@Data
public class Fault {

    private static final String APP_ERROR_PREFIX = "ORI_FALCON_BIZ";
    private static final char SEPARATOR = '-';

    @Getter
    private String module;
    @Getter
    private String function;
    @Getter
    private Integer error;
    @Getter
    private String code;
    @Getter
    private String message;

    public Fault(String module, String function, Integer error, String message) {
        if (null == module) {
            throw new NullPointerException("The module can't be null");
        }
        if (null == function) {
            throw new NullPointerException("The function can't be null");
        }
        if (null == error) {
            throw new NullPointerException("The error can't be null");
        }
        if (1 > error || 999 < error) {
            throw new IllegalArgumentException("The error value must be is 1-999");
        }
        this.module = module;
        this.error = error;
        this.function = function;
        this.message = message;
        StringBuilder sb = new StringBuilder(String.valueOf(error));
        while (sb.length() < 3) {
            sb.insert(0, "0");
        }
        this.code = APP_ERROR_PREFIX + SEPARATOR + module + SEPARATOR + function + SEPARATOR + sb.toString();
    }

    @Override
    public String toString() {
        return "Fault{" +
                "module='" + module + '\'' +
                ", function='" + function + '\'' +
                ", error=" + error +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
