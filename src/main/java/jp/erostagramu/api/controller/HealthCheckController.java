package jp.erostagramu.api.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/healthCheck")
public class HealthCheckController {

	private static final String SUCCESS_STATUS = "success";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HealthCheckInfoDto validateGetMethod() {
		return HealthCheckInfoDto.builder().status(SUCCESS_STATUS).build();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public HealthCheckInfoDto validatePostMethod() {
		return HealthCheckInfoDto.builder().status(SUCCESS_STATUS).build();
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public HealthCheckInfoDto validatePutMethod() {
		return HealthCheckInfoDto.builder().status(SUCCESS_STATUS).build();
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public HealthCheckInfoDto validateDeleteMethod() {
		return HealthCheckInfoDto.builder().status(SUCCESS_STATUS).build();
	}
}
