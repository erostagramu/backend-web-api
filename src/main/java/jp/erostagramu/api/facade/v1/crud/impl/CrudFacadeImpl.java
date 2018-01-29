package jp.erostagramu.api.facade.v1.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.erostagramu.api.facade.v1.crud.CrudFacade;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeResponse;
import jp.erostagramu.api.logic.v1.create.CreateLogic;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Throwable.class, timeout = 15)
public class CrudFacadeImpl implements CrudFacade {

	@Autowired
	private CreateLogic createLogic;

	@Override
	public CreatePostFacadeResponse createPost(CreatePostFacadeRequest createPostFacadeRequest) {
		return createLogic.create(createPostFacadeRequest);
	}

}
