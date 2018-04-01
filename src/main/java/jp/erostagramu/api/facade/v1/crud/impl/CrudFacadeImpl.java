package jp.erostagramu.api.facade.v1.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.erostagramu.api.facade.v1.crud.CrudFacade;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.crud.model.FacadeResponse;
import jp.erostagramu.api.facade.v1.crud.model.UpdatePutFacadeRequest;
import jp.erostagramu.api.logic.v1.create.CreateLogic;
import jp.erostagramu.api.logic.v1.update.UpdateLogic;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Throwable.class, timeout = 15)
public class CrudFacadeImpl implements CrudFacade {

	@Autowired
	private CreateLogic createLogic;
	@Autowired
	private UpdateLogic updateLogic;

	@Override
	public FacadeResponse createPost(CreatePostFacadeRequest createPostFacadeRequest) {
		return createLogic.create(createPostFacadeRequest);
	}
	
	@Override
	public FacadeResponse updatePut(UpdatePutFacadeRequest updatePutFacadeRequest) {
		return updateLogic.update(updatePutFacadeRequest);
	}
}
