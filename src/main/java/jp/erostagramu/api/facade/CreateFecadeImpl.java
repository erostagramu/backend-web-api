package jp.erostagramu.api.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dao.masterdb.write.CreateDao;

@Component("createFacade")
public class CreateFecadeImpl implements CreateFecade{
	
	@Autowired
	@Qualifier("createDao")
	private CreateDao createDao;
	
	@Override
	public ResultDto create(MovieDto movieDto) {
		return createDao.create(movieDto);
	}

}
