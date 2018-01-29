package jp.erostagramu.api.dao.masterdb.write;

import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;

public interface CreatePostDao {

	public void create(CreatePostFacadeRequest createPostFacadeRequest) throws Exception;

}
