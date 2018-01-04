package jp.erostagramu.api.dao.masterdb.write;

import jp.erostagramu.api.dto.MovieDto;
import jp.erostagramu.api.dto.ResultDto;

public interface CreateDao {
	
	public ResultDto create(MovieDto movieDto);
		
}
