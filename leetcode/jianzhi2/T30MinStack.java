package leetcode.jianzhi2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2022-11-16
 */
public class T30MinStack {

    private List<Integer> data;
    private Integer topIndex;
    private List<Integer> minList;

    /**
     * initialize your data structure here.
     */
    public T30MinStack() {
        data = new ArrayList<>();
        topIndex = 0;
        minList = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
        if (minList.size() == 0) {
            minList.add(x);
            topIndex++;
            return;
        }
        if (x <= minList.get(minList.size() - 1)) {
            minList.add(x);
        }
        topIndex++;
    }

    public void pop() {
        int num = data.get(topIndex - 1);
        if (num == minList.get(minList.size() - 1)){
            minList.remove(minList.size() - 1);
        }
        data.remove(topIndex - 1);
        topIndex--;


    }

    public int top() {
        return data.get(topIndex - 1);
    }

    public int min() {
        return minList.get(minList.size() - 1);
    }

    public static void main(String[] args) {
        T30MinStack stack = new T30MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
//        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        stack.pop();
//        System.out.println(stack.top());
        System.out.println(stack.min());
    }
}
