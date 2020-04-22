package com.ly.study.design.过滤器模式.criteria;

import com.ly.study.design.过滤器模式.Student;

import java.util.List;

/**
 * @author yang.liu
 * @date 2020-04-22
 * @describe
 */
public interface Criteria {

    List<Student> doCriteria(List<Student> students);
}
