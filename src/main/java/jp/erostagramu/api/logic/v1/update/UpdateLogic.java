package jp.erostagramu.api.logic.v1.update;

import jp.erostagramu.api.facade.v1.crud.model.FacadeResponse;
import jp.erostagramu.api.facade.v1.crud.model.UpdatePutFacadeRequest;

public interface UpdateLogic {
	
	public FacadeResponse update(UpdatePutFacadeRequest updatePutFacadeRequest);

}
