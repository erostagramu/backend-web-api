package jp.erostagramu.api.dao.masterdb.write;

import jp.erostagramu.api.facade.v1.crud.model.UpdatePutFacadeRequest;

public interface UpdatePutDao {

	public void update(UpdatePutFacadeRequest updatePutFacadeRequest) throws Exception;

}
