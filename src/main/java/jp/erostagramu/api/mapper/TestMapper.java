package jp.erostagramu.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dto.MovieDto;

@Service
@Mapper
public interface TestMapper {
	
	MovieDto selectTest(Integer id);
	Integer create(MovieDto dto);
	
}
