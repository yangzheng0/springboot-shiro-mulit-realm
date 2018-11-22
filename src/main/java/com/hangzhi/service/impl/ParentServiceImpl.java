package com.hangzhi.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangzhi.bean.Parent;
import com.hangzhi.bean.ParentExample;
import com.hangzhi.dao.ParentMapper;
import com.hangzhi.service.ParentService;
@Service
public class ParentServiceImpl implements ParentService {
	
	@Autowired
	ParentMapper parentMapper;

	@Override
	public Parent getParentByAccount(String account) {
		ParentExample parentExample = new ParentExample();
		parentExample.createCriteria().andAccountEqualTo(account);
		List<Parent> parentList = parentMapper.selectByExample(parentExample);
		if(CollectionUtils.isEmpty(parentList)){
			return null;
		}
		return parentList.get(0);
	}

}
