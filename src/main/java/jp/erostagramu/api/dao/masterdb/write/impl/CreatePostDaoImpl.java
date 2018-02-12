package jp.erostagramu.api.dao.masterdb.write.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.write.CreatePostDao;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.mapper.v1.CreateMapper;

@Service
public class CreatePostDaoImpl implements CreatePostDao {

	@Autowired
	private CreateMapper mapper;

	public void create(CreatePostFacadeRequest createPostFacadeRequest) throws Exception {
		mapper.insert(createPostFacadeRequest.getRequestBody());
	}
}
