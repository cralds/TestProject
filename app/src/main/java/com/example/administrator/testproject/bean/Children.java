package com.example.administrator.testproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class Children<T> extends Parent {
    List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Children{" +
                "data=" + data +
                '}';
    }
}
