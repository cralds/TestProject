package com.example.administrator.testproject.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

public class ErrorBean {
    public int id;
    //应用代号
    public String C01;
    //会话id
    public String C02;
    //发生时间
    public long C03;
    //错误信息
    public String C04;

}
