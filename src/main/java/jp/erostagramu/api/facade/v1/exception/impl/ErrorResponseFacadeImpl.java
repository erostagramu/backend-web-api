package jp.erostagramu.api.facade.v1.exception.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import jp.erostagramu.api.dto.ExceptionDto;
import jp.erostagramu.api.facade.v1.exception.ErrorResponseFacade;
import jp.erostagramu.api.logic.exception.ErrorResponseLogic;

@Service
public class ErrorResponseFacadeImpl implements ErrorResponseFacade {

	@Autowired
	ErrorResponseLogic errorResponseLogic;

	@Override
	public ExceptionDto writeErrorCode(Exception ex, WebRequest req) {
		return errorResponseLogic.writeErrorCode(ex, req);
	}

}
