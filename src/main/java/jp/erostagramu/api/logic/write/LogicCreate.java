package jp.erostagramu.api.logic.write;

import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeResponse;

public interface LogicCreate {
	
	public CreatePostFacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest) ;
	
}
