package com.mcc.g3n.demo.test;

import com.mcc.g3n.demo.domin.utiltest.UserDao;
import com.mcc.g3n.demo.domin.utiltest.UserDaoImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {

    @Test
    public void test() {
        UserDao userDao = getProxyObject(UserDaoImpl.class);
        userDao.test();
    }

    public <T> T getProxyObject(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibProxy());
        T proxied = (T) enhancer.create();
        return proxied;
    }

    class CglibProxy implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("cglib before ```");
            Object re = methodProxy.invokeSuper(o, objects);
            System.out.println("cglib after ```");
            return re;
        }
    }
}
