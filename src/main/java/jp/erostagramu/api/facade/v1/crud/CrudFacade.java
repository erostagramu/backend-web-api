package jp.erostagramu.api.facade.v1.crud;

import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeResponse;

public interface CrudFacade {	
	
		public CreatePostFacadeResponse createPost(CreatePostFacadeRequest createPostFacadeRequest);
		
	}

