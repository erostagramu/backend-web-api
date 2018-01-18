package jp.erostagramu.api.dao.masterdb.write.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dao.masterdb.write.CreatePostDao;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;

@Service
public class CreatePostDaoImpl implements CreatePostDao {

	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	private String message;
	private HttpStatus status;

	public CreatePostDaoImpl() throws IOException {
		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Throwable.class, timeout = 15)
	public ResultDto create(CreatePostFacadeRequest createPostFacadeRequest) {
		try {
			session.insert("ApiMapper.create", createPostFacadeRequest.getRequestBody());
			session.commit();
			status = HttpStatus.OK;
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			message = "[重複する動画ID]または[存在しないカテゴリID・連携元動画種別ID]が指定されました";
			status = HttpStatus.CONFLICT;
		}
		
		return ResultDto.builder().
				statusCode(status).
				message(message).
				build();

	}

}
