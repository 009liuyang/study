package com.ly.study.design.过滤器模式.criteria.sex;

import com.ly.study.design.过滤器模式.Student;
import com.ly.study.design.过滤器模式.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.liu
 * @date 2020-04-22
 * @describe 男性过滤器
 */
public class MaleSexCriteria implements Criteria {

    @Override
    public List<Student> doCriteria(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for(Student s : students){
            if(s.getSex() == 1){
                result.add(s);
            }
        }
        return result;
    }
}
