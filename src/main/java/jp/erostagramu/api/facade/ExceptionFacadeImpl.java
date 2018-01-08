package jp.erostagramu.api.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import jp.erostagramu.api.dto.ExceptionDto;
import jp.erostagramu.api.exception.ErrorCodeWriter;

@Service
public class ExceptionFacadeImpl implements ExceptionFacade {

	@Autowired
	ErrorCodeWriter errorCodeWriter;

	@Override
	public ExceptionDto writeErrorCode(Exception ex, WebRequest req) {
		return errorCodeWriter.writeErrorCode(ex, req);
	}

}
