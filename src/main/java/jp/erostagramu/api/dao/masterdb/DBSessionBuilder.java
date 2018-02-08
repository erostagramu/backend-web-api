package jp.erostagramu.api.dao.masterdb;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

@Service
public class DBSessionBuilder {
	
	private static final String CONFIG = "mybatis-config.xml";
	
	public SqlSession getSession() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(CONFIG);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}
	
}
