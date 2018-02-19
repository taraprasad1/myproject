package com.rest.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rest.dao.Dao;

@Service("business")
public class BusinessImpl implements Business{

	@Autowired
	@Qualifier("dao")
	private Dao dao;

	public void setDao(Dao dao) {
	this.dao = dao;
}

	@Override
	public String save(List list) {
		// TODO Auto-generated method stub
		String s=dao.save(list);
		return s;
	}

}
