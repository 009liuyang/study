package com.ly.study.design.过滤器模式.criteria.condition;

import com.ly.study.design.过滤器模式.Student;
import com.ly.study.design.过滤器模式.criteria.Criteria;

import java.util.List;

/**
 * @author yang.liu
 * @date 2020-04-22
 * @describe and条件过滤器
 */
public class AndCriteria implements Criteria {

    Criteria first;
    Criteria second;

    public AndCriteria(Criteria first, Criteria second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public List<Student> doCriteria(List<Student> students) {
        List<Student> firstResult = first.doCriteria(students);
        List<Student> secondResult = second.doCriteria(firstResult);
        return secondResult;
    }
}
