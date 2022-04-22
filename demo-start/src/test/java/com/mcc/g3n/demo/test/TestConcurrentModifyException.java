package com.mcc.g3n.demo.test;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestConcurrentModifyException {

    @Test
    public void test(){
        ArrayList<String> al = Lists.newArrayList("1", "2", "3", "4");
        ArrayList<String> al2 = Lists.newArrayList("1", "2", "3", "4", "5");
        ListIterator<String> it = al.listIterator();
        while (it.hasNext()) {
            if("3".equals(it.next())){
                al.remove("3");
            }
        }

        ListIterator<String> it2 = al2.listIterator();
        while (it2.hasNext()) {
            if("3".equals(it2.next())){
                al2.remove("3");
            }
        }

    }
}
