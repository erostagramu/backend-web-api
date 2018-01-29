package jp.erostagramu.api.dao.masterdb.write.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.DBSessionBuilder;
import jp.erostagramu.api.dao.masterdb.write.CreatePostDao;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;

@Service
public class CreatePostDaoImpl implements CreatePostDao {

	@Autowired
	private DBSessionBuilder sessionBulider;

	@Override
	public void create(CreatePostFacadeRequest createPostFacadeRequest) throws Exception {
		SqlSession session = sessionBulider.getSession();
		session.insert("ApiMapper.create", createPostFacadeRequest.getRequestBody());
		session.commit();
	}
}
