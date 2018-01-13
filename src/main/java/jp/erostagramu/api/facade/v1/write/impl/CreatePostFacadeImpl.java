package jp.erostagramu.api.facade.v1.write.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.write.CreatePostDao;
import jp.erostagramu.api.facade.v1.write.CreatePostFacade;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeResponse;

@Service
public class CreatePostFacadeImpl implements CreatePostFacade{
	
	@Autowired
	private CreatePostDao createDao;
	
	@Override
	public CreatePostFacadeResponse createPost(CreatePostFacadeRequest createPostFacadeRequest) {
		return createDao.create(createPostFacadeRequest);
	}

}
