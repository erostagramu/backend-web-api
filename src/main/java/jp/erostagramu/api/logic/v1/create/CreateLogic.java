package jp.erostagramu.api.logic.v1.create;

import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeResponse;

public interface CreateLogic {

	public CreatePostFacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest) ;
	
}
