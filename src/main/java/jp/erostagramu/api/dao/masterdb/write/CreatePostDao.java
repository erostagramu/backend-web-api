package jp.erostagramu.api.dao.masterdb.write;

import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeResponse;

public interface CreatePostDao {
	
	public CreatePostFacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest);
		
}
