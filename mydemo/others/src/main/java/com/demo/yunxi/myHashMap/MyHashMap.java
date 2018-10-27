package com.demo.yunxi.myHashMap;

public class MyHashMap {
    private int length = 5;
    private Node[] nodes = new Node[length];

    public void put(Object key,Object value){
        int index = key.hashCode() % length;
        addNodes(index,key,value);
    }

    public Object get(Object key){
        int index = key.hashCode() % length;
        return getNodes(index,key);
    }

    private Object getNodes(int index,Object key){
        Node o = nodes[index];
        if(o == null){return null;}
        do{
            if(o.key.equals(key)){
                return o.value;
            }
            o = o.next;
        }while(o != null);
        return o;
    }

    private void addNodes(int index, Object key, Object value){
        //取出链表
        Node o = nodes[index];
        //将元素放在头部
        Node n = new Node(key,value,o);
        nodes[index] = n;
    }

    class Node{
        private Object key;
        private Object value;
        private Node next;
        private Node(Object key ,Object value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("a1","张三");
        hashMap.put("a2","李四");
        hashMap.put("a3","王五");
        hashMap.put("a4","赵六");
        hashMap.put("a5","马云");
        hashMap.put("a6","张龙");
        hashMap.put("a7","赵虎");
        hashMap.put("a8","马化腾");
        System.out.println((String)hashMap.get("a1"));
        System.out.println((String)hashMap.get("a2"));
        System.out.println((String)hashMap.get("a3"));
        System.out.println((String)hashMap.get("a4"));
        System.out.println((String)hashMap.get("a5"));
        System.out.println((String)hashMap.get("a6"));
        System.out.println((String)hashMap.get("a7"));
        System.out.println((String)hashMap.get("a8"));
    }
}
