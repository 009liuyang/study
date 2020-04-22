package com.ly.study.design.过滤器模式.criteria;

import com.ly.study.design.过滤器模式.Student;
import com.ly.study.design.过滤器模式.criteria.age.SixMoreAgeCriteria;
import com.ly.study.design.过滤器模式.criteria.condition.AndCriteria;
import com.ly.study.design.过滤器模式.criteria.sex.MaleSexCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.liu
 * @date 2020-04-22
 * @describe
 *
 * 过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，
 * 这种模式允许开发人员使用不同的标准来过滤一组对象，
 * 通过逻辑运算以解耦的方式把它们连接起来。
 * 这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。
 */
public class Main {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("A", 1, 1));
        studentList.add(new Student("B", 2, 2));
        studentList.add(new Student("C", 3, 1));
        studentList.add(new Student("D", 4, 2));
        studentList.add(new Student("E", 5, 1));
        studentList.add(new Student("F", 6, 2));
        studentList.add(new Student("E", 7, 1));

        MaleSexCriteria sexCriteria = new MaleSexCriteria();
        SixMoreAgeCriteria ageCriteria = new SixMoreAgeCriteria();
        AndCriteria andCriteria = new AndCriteria(sexCriteria, ageCriteria);

        List<Student> result = andCriteria.doCriteria(studentList);

        for(Student s : result){
            System.out.println(s.getName());
        }

    }
}
