package jp.erostagramu.api.facade.v1.crud;

import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.crud.model.FacadeResponse;
import jp.erostagramu.api.facade.v1.crud.model.UpdatePutFacadeRequest;

public interface CrudFacade {

	public FacadeResponse createPost(CreatePostFacadeRequest createPostFacadeRequest);
	public FacadeResponse updatePut(UpdatePutFacadeRequest updatePutFacadeRequest);

}
