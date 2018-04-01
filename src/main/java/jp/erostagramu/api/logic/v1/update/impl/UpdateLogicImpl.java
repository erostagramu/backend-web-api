package jp.erostagramu.api.logic.v1.update.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.constants.MessageConstants;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dao.masterdb.write.UpdatePutDao;
import jp.erostagramu.api.facade.v1.crud.model.FacadeResponse;
import jp.erostagramu.api.facade.v1.crud.model.UpdatePutFacadeRequest;
import jp.erostagramu.api.logic.v1.update.UpdateLogic;

@Service
public class UpdateLogicImpl implements UpdateLogic {
	
	@Autowired
	private UpdatePutDao updateDao;
	private ResultDto result;
	private String message;
	private HttpStatus status;
	
	@Override
	public FacadeResponse update(UpdatePutFacadeRequest updatePutFacadeRequest) {
		
		try {
			updateDao.update(updatePutFacadeRequest);
			
			// リクエスト成功時
			message = MessageConstants.SUCCESS;
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result = ResultDto.builder().message(message).build();
		return FacadeResponse.builder().responseBody(result).status(status).build();
	}
	
	
	
}
