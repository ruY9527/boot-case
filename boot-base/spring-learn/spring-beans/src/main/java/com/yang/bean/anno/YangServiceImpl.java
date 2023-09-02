package com.yang.bean.anno;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Mu_Yi
 * @Date: 2020/5/25 23:02
 * @Version 1.0
 * @qq: 1411091515
 */

@Service
public class YangServiceImpl implements InitializingBean {

    public YangServiceImpl(){
        System.out.println("YangServiceImpl 无参构造函数");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
