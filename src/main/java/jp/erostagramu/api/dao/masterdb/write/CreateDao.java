package jp.erostagramu.api.dao.masterdb.write;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;

public interface CreateDao {
	
	public ResultDto create(MovieDto movieDto);
		
}
