package com.ly.study.springIoc;

import lombok.Data;

@Data
public class BeanDefinition {
    private String className;
    private String alias;
    private String superNames;
}
