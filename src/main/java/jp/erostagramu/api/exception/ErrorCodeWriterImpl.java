package jp.erostagramu.api.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dto.ExceptionDto;

@Service
public class ErrorCodeWriterImpl implements ErrorCodeWriter {

	@Autowired
	private ExceptionDto exceptionDto;

	private String errorMessage;
	private HttpStatus status;

	@Override
	public ExceptionDto writeErrorCode(Exception ex, WebRequest req) {
		switch (ex.getClass().toString()) {
		case "class java.sql.SQLIntegrityConstraintViolationException":
			errorMessage = "[重複する動画ID]または[存在しないカテゴリID・連携元動画種別ID]が指定されました";
			status = HttpStatus.CONFLICT;
			break;
		case "class com.fasterxml.jackson.databind.exc.InvalidFormatException":
			errorMessage = "JSONのデータ型が間違っています";
			status = HttpStatus.BAD_REQUEST;
			break;
		}
		exceptionDto.setBody(ResultDto.builder().message(errorMessage).build());
		exceptionDto.setStatus(status);
		return exceptionDto;
	}

}
