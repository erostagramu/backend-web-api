package jp.erostagramu.api.mapper.v1;

import org.apache.ibatis.annotations.Mapper;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;

@Mapper
public interface CreateMapper {
	void insert(MovieDto dto);
}
