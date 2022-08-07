package com.xu;

import java.util.Stack;

class MinStack {
    //最小的怎么动态更新
    //添加元素时，元素跟min之间怎么更新
    //删除元素时，元素跟min之间有什么关系
    private int[] stack;
    private int[] min;
    private int num = -1;//栈顶下标
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[20001];
        min = new int[20001];
        // Arrays.fill(min,Integer.MAX_VALUE);
    }

    public void push(int x) {
        num++;
        stack[num] = x;
        if(num == 0){//表示这是第一个数
            min[num] = x;
        }else{
            if(min[num-1] < x){
                min[num] = min[num-1];
            }else{
                min[num] = x;
            }
        }
    }

    public void pop() {
        if(num > 0) num--;
    }

    public int top() {
        return stack[num];
    }

    public int min() {
        return min[num];
    }

}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */