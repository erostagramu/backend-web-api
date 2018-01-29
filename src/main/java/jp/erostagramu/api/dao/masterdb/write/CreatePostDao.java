package jp.erostagramu.api.dao.masterdb.write;

import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;

public interface CreatePostDao {
	
	public Integer create(CreatePostFacadeRequest createPostFacadeRequest);
		
}
