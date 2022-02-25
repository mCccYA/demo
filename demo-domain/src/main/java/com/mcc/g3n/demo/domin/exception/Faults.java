package com.mcc.g3n.demo.domin.exception;

/**
 * @author qingxi.ljy
 * @date 2021/12/1 8:37 下午
 */
public final class Faults {

    public interface System {

        String MODULE = "000";

        String REQUEST_FUNC = "400";
        Fault BAD_REQUEST = new Fault(MODULE, REQUEST_FUNC, 1, "请求参数异常");
        Fault IDEMPOTENT_ERROR = new Fault(MODULE, REQUEST_FUNC, 2, "重复请求,请稍后再试");
        Fault NO_ACCESS = new Fault(MODULE, REQUEST_FUNC, 3, "暂无访问权限");

        String INNER_FUNC = "500";
        Fault INNER_ERROR = new Fault(MODULE, INNER_FUNC, 1, "系统内部异常");

        String OUTSIDE_FUNC = "501";
        Fault OUTSIDE_ERROR = new Fault(MODULE, OUTSIDE_FUNC, 2, "调用外部接口异常");
    }

}
