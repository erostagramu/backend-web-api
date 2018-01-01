package jp.erostagramu.api.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.erostagramu.api.dto.MovieDto;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/movie")
public class CreateController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void createMovie() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File("/Users/takuma/develop/test.json"));
		String sample = root.get("title").asText();
		
		// MovieDto dto = mapper.readValue(json, MovieDto.class);

		// System.out.println(dto);
	}
}
