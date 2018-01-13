package jp.erostagramu.api.facade.v1.write;

import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeResponse;

public interface CreatePostFacade {
	
	public CreatePostFacadeResponse createPost(CreatePostFacadeRequest createPostFacadeRequest);
	
}
