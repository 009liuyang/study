package com.ly.study.design.过滤器模式.criteria.age;

import com.ly.study.design.过滤器模式.Student;
import com.ly.study.design.过滤器模式.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.liu
 * @date 2020-04-22
 * @describe 6年级以上过滤器
 */
public class SixMoreAgeCriteria implements Criteria {

    @Override
    public List<Student> doCriteria(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for(Student s : students){
            if(s.getGrade() > 6){
                result.add(s);
            }
        }
        return result;
    }
}
