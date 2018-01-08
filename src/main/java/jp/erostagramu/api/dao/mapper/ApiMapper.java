// 作成中
package jp.erostagramu.api.dao.mapper;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;

public interface ApiMapper {

	public Integer create(MovieDto movieDto);

	public MovieDto readTitleByID(Integer id);

}
