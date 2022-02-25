package com.mcc.g3n.demo.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import org.junit.Test;


/**
 * @author wb-yk935086
 * @date 2021/10/18
 */
public class TestSerialize {

    @SneakyThrows
    @Test
    public void test() {
        Person person = new Person().setName("xiao ming").setAge(12).setSex(1);
        String personJson = JSON.toJSONString(person);
        System.out.println(JSONObject.parseObject(personJson, Person.class));
    }

    @Data
    @Accessors(chain = true)
    static class Person{
        private String name;
        private transient Integer age;
        private Integer sex;
    }

}
