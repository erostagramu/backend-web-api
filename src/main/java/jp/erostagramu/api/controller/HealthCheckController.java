package jp.erostagramu.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class HealthCheckController {

	@RequestMapping(value = "/v1/movie/{page}/{categoryId}/{searchStr}", method = RequestMethod.GET)
	public Map<String, String> get(@PathVariable("page") Integer page, @PathVariable("categoryId") Integer categoryId,
			@PathVariable("searchStr") String searchStr) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("メソッド", "get");
		map.put("ページ", page.toString());
		map.put("カテゴリId", categoryId.toString());
		map.put("検索ワード", searchStr);
		return map;
	}

	@RequestMapping(value = "/v1/movie", method = RequestMethod.POST)
	public Map<String, String> post() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("メソッド", "post");
		return map;
	}

	@RequestMapping(value = "/v1/movie/{id}", method = RequestMethod.PUT)
	public Map<String, String> put(@PathVariable("id") Integer id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("メソッド", "put");
		map.put("id", id.toString());
		return map;
	}

	@RequestMapping(value = "/v1/movie/{id}", method = RequestMethod.DELETE)
	public Map<String, String> delete(@PathVariable("id") Integer id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("メソッド", "delete");
		map.put("id", id.toString());
		return map;
	}
}
