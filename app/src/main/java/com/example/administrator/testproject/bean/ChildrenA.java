package com.example.administrator.testproject.bean;

/**
 * Created by Administrator on 2016/6/30.
 */
public class ChildrenA<T> extends Parent{
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
