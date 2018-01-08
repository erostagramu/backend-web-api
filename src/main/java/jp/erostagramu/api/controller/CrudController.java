package jp.erostagramu.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dto.ExceptionDto;
import jp.erostagramu.api.facade.CreateFacade;
import jp.erostagramu.api.facade.ExceptionFacade;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/movie")
public class CrudController extends ResponseEntityExceptionHandler {

	@Autowired
	private CreateFacade createFacade;

	@Autowired
	private ExceptionFacade exceptionFacade;

	// 動画登録API
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResultDto create(@RequestBody MovieDto movieDto) {
		return createFacade.create(movieDto);
	}

	// 主キー重複または外部キー違反が発生した時のレスポンス
	@ExceptionHandler
	public ResponseEntity<Object> handleRuntimeException(SQLIntegrityConstraintViolationException ex, WebRequest req) {
		ExceptionDto exDto = exceptionFacade.writeErrorCode(ex, req);
		return handleExceptionInternal(ex, exDto.getBody(), new HttpHeaders(), exDto.getStatus(), req);
		// (例外,レスポンスボディ,レスポンスヘッダー,レスポンスステータス,リクエスト)
	}

	// <!動きません！>JSONに誤ったデータ型が記載されていた時のレスポンス
	@ExceptionHandler
	public ResponseEntity<Object> handleRuntimeException(InvalidFormatException ex, WebRequest req) {
		ExceptionDto exDto = exceptionFacade.writeErrorCode(ex, req);
		return handleExceptionInternal(ex, exDto.getBody(), new HttpHeaders(), exDto.getStatus(), req);
		// (例外,レスポンスボディ,レスポンスヘッダー,レスポンスステータス,リクエスト)
	}
}
