package jp.erostagramu.api.dao.masterdb.write.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.write.UpdatePutDao;
import jp.erostagramu.api.facade.v1.crud.model.UpdatePutFacadeRequest;
import jp.erostagramu.api.mapper.v1.CrudMapper;

@Service
public class UpdatePutDaoImpl implements UpdatePutDao{

	@Autowired
	private CrudMapper mapper;
	
	@Override
	public void update(UpdatePutFacadeRequest updatePutFacadeRequest) throws Exception {
		mapper.update(updatePutFacadeRequest.getRequestBody());
	}

}
