package com.spring.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//order用于bean的排序，只在list中有效，map中无效
@Component
@Order(1)
public class BeanImplTwo implements BeanInterface{

}