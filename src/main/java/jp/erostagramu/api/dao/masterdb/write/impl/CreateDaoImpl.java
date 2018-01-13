package jp.erostagramu.api.dao.masterdb.write.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.write.CreateDao;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeResponse;
import jp.erostagramu.api.facade.v1.write.model.CreatePostResponse;

@Service
public class CreateDaoImpl implements CreateDao {

	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	private String message;
	private HttpStatus status;
	private CreatePostResponse createPostResponse;

	public CreateDaoImpl() throws IOException {
		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	@Override
	public CreatePostFacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest) {
		try {
			session.insert("ApiMapper.create", createPostFacadeRequest.getRequestBody());
			session.commit();
			createPostResponse = null;
			status = HttpStatus.OK;
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			message = "[重複する動画ID]または[存在しないカテゴリID・連携元動画種別ID]が指定されました";
			createPostResponse = CreatePostResponse.builder().message(message).build();
			status = HttpStatus.CONFLICT;
		}

		return CreatePostFacadeResponse.builder().
				challengeFreeOutlineResponse(createPostResponse). // body
				status(status). // status
				build();
	}

}
