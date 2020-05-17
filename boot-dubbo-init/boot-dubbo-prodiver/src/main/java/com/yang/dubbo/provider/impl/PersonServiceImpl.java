package com.yang.dubbo.provider.impl;

import org.apache.dubbo.config.annotation.Service;

import com.yang.dubbo.common.entity.Person;
import com.yang.dubbo.common.vo.R;

@Service(version = "1.0.0")
public class PersonServiceImpl implements com.yang.dubbo.common.service.PersonService {

	@Override
	public R save(Person person) {
		return R.ok(null);
	}

	@Override
	public R queryAll() {
		return R.ok(null);
	}

}
