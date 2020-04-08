package com.ly.study.algorithm.LRU;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @describe 双向链表实现
 *
 * LRU: 最近最少使用算法 。 最近最少使用的元素，在接下来一段时间内，被访问的概率也很低。
 * 即最近被使用的元素，在接下来一段时间内，被访问概率较高。
 * <p>
 * 用链表的结构：
 * 链表尾表示最近被访问的元素，越靠近链表头表示越早之前被访问的元素
 * <p>
 * 插入一个元素，cache 不满，插到链表尾，满，移除cache链头元素再插入链表尾
 * 访问一个元素，从链表尾部开始遍历, 访问到之后，将其从原位置删除，重新加入链表尾部
 * <p>
 * 实现1：用双向链表实现。
 * put、get 时间复杂度:O(n)       效率低

 * @author yang.liu
 * @date 2020-04-08
 */
public class UseLinkedList {

    LinkedList<Node> cache;
    int capacity;

    public UseLinkedList(int capacity) {
        this.cache = new LinkedList<>();
        this.capacity = capacity;
    }


    public void put (int k, int v){
        //先遍历查找是否有key 的元素, 有则删除，重新添加到链尾
        Iterator<Node> iterator = cache.iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if(node.key == k){
                iterator.remove();
                break;
            }
        }

        if(capacity == cache.size()){
            cache.removeFirst();
        }

        cache.push(new Node(k, v));
    }


    /**
     * -1 表示没找到
     */
    public int get(int k){
        Iterator<Node> iterator = cache.descendingIterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if(node.key == k){
                int result = node.val;
                cache.remove();
                put(k, result);
                return result;
            }
        }
        return -1;
    }


    class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
