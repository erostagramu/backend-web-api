package jp.erostagramu.api.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dao.masterdb.write.CreateDao;

@Service
public class CreateFacadeImpl implements CreateFacade{
	
	@Autowired
	private CreateDao createDao;
	
	@Override
	public ResultDto create(MovieDto movieDto) {
		return createDao.create(movieDto);
	}

}
