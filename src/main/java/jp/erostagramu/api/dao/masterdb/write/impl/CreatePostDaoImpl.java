package jp.erostagramu.api.dao.masterdb.write.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.write.CreatePostDao;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;

@Service
public class CreatePostDaoImpl implements CreatePostDao {

	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	private Integer insertCount;

	public CreatePostDaoImpl() throws IOException {
		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	@Override
	public Integer create(CreatePostFacadeRequest createPostFacadeRequest) {
		try {
			insertCount = session.insert("ApiMapper.create", createPostFacadeRequest.getRequestBody());
			System.out.println(insertCount);
			
			session.commit();
		} catch (Exception e) {
			insertCount = null;
		}
		
		return insertCount;

	}

}
