package jp.erostagramu.api.logic.v1.create;

import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.crud.model.FacadeResponse;

public interface CreateLogic {

	public FacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest);

}
