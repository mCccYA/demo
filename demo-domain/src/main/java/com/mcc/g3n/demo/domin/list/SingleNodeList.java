package com.mcc.g3n.demo.domin.list;

import java.io.Serializable;
import java.util.*;

/**
 * 单向链表
 * @author wb-yk935086
 * @date 2021/10/18
 */
public class SingleNodeList<E> implements Serializable {

    private transient int size = 0;
    private transient Node<E> last;
    protected transient int modCount = 0;

    public SingleNodeList(){}

    public int add(E e){
        last = new Node(last, e);
        return size++;
    }

    public int size() {
        return size;
    }

    public E get(int index){
        checkIndex(index);
        Node<E> n = last;
        for (int i = size; i > index + 1; i--){
            n = n.pre;
        }
        return n.data;
    }

    public int remove(int index) {
        checkIndex(index);
        // 将删除的节点的上一个节点
        Node<E> n = last;
        for (int i = size; i > index + 2; i--){
            n = n.pre;
        }
        if(null == n.pre){
            last = null;
            size--;
        }
        else {
            n.pre = n.pre.pre;
            size--;
        }
        return size;
    }

    public Iterator<E> iterator(){return new Itr();}

    private boolean checkIndex(int index) {
        boolean checked = (size >= 0 && index < size);
        if(!checked){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        return checked;
    }

    private static class Node<E> {
        private Node pre;
        private E data;

        public Node(Node pre, E data) {
            this.pre = pre;
            this.data = data;
        }
    }

    @Override
    public String toString() {
        LinkedList<E> ll = new LinkedList<>();
        for(Node<E> n = last; null != n; n = n.pre){
            ll.add(n.data);
        }
        Collections.reverse(ll);
        return ll.toString();
    }

    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        Itr() {}

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Node<E> n = last;
            for (int j = SingleNodeList.this.size; j > i + 1; j--){
                n = n.pre;
            }
            lastRet = cursor++;
            return n.data;
        }
    }
}
