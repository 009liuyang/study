package com.ly.study.design.过滤器模式;

/**
 * @author yang.liu
 * @date 2020-04-22
 * @describe
 */
public class Student {

    private String name;

    private int grade;

    private int sex;

    public Student(String name, int grade, int sex) {
        this.name = name;
        this.grade = grade;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
