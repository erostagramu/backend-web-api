package jp.erostagramu.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.facade.v1.crud.CrudFacade;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeResponse;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/movie")
public class CrudController extends ResponseEntityExceptionHandler {

	@Autowired
	private CrudFacade crudFacade;

	// 動画登録API
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<ResultDto> create(@RequestBody MovieDto requestBody) {

		CreatePostFacadeRequest request = CreatePostFacadeRequest.builder().requestBody(requestBody).build();
		CreatePostFacadeResponse response = crudFacade.createPost(request);

		return new ResponseEntity<ResultDto>(
				response.getResponseBody(), // body
				response.getStatus()); // status
	}

}
