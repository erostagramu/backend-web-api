package jp.erostagramu.api.dao.masterdb.read.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.read.CountByIdGetDao;
import jp.erostagramu.api.mapper.v1.CrudMapper;

@Service
public class CountByIdGetDaoImpl implements CountByIdGetDao{

	@Autowired
	private CrudMapper mapper;
	
	@Override
	public Integer countById(Integer id) {
		return mapper.getCountById(id);
	}
	
	
	
}
