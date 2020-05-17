package com.yang.dubbo.common.service;

import com.yang.dubbo.common.entity.Person;
import com.yang.dubbo.common.vo.R;

/**
 * @program: Dubbo_NZ1906
 * @description:
 * @author: Feri
 * @create: 2020-02-11 16:10
 */
public interface PersonService {
    R save(Person person);
    R queryAll();

}
