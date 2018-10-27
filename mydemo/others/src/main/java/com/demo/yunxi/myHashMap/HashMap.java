package com.demo.yunxi.myHashMap;

public class HashMap<K,V> implements Map<K,V>{

    //数组+链表结构
    Node<K,V>[] array = null;

    //数组/hash桶的长度
    private static int defaultLength = 16;

    private int size;

    @Override
    public V put(K k, V v) {
        if(array == null){
            array = new Node[defaultLength];
        }
        //通过hash算法计算具体要插入的位置
        int index = position(k);

        Node node = array[index];
        if(node == null){
            array[index] = new Node<K,V>(k,v,null);
            size++;
        }else {
            if (k.equals(node.getKey()) || k == node.getKey()) {
                return (V)node.setValue(v);
            } else {
                array[index] = new Node<K, V>(k, v, node);
                size++;
            }
        }
        return null;
    }

    private int position(K k){
        int code = k.hashCode();
        //取模算法
        return code % (defaultLength - 1);
        //求与算法
        //return code & (defaultLength - 1);
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    static class Node<K,V> implements Entry<K,V>{
        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        K key;
        V value;
        Node<K,V> next;
        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V v) {
            V oldValue = this.value;
            this.value = v;
            return oldValue;
        }
    }
}
