package com.example.administrator.testproject.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/6/28.
 */
@Table(name = "student")
public class Student {
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "studentName")
    private String studentName;
    @Column(name = "age")
    private int age;

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String studentName, int age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public Student() {
    }
}
