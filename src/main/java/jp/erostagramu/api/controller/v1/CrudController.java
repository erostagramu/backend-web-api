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
import jp.erostagramu.api.facade.v1.write.CreatePostFacade;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeResponse;
import jp.erostagramu.api.facade.v1.write.model.CreatePostResponse;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/movie")
public class CrudController extends ResponseEntityExceptionHandler {

	@Autowired
	private CreatePostFacade createPostFacade;

	// 動画登録API
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<CreatePostResponse> create(@RequestBody MovieDto movieDto) {
		CreatePostFacadeRequest createPostFacadeRequest = CreatePostFacadeRequest.builder().requestBody(movieDto).build();
		CreatePostFacadeResponse createPostFacadeResponse = createPostFacade.createPost(createPostFacadeRequest);

		return new ResponseEntity<CreatePostResponse>(
				createPostFacadeResponse.getChallengeFreeOutlineResponse(), //body
				createPostFacadeResponse.getStatus()); //status
	}

}
