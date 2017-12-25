package jp.erostagramu.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/healthCheck")
public class HealthCheckController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HealthCheckInfoDto validateGetMethod() {
		return HealthCheckInfoDto.builder().status("success").build();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public HealthCheckInfoDto validatePostMethod() {
		return HealthCheckInfoDto.builder().status("success").build();
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public HealthCheckInfoDto validatePutMethod() {
		return HealthCheckInfoDto.builder().status("success").build();
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public HealthCheckInfoDto validateDeleteMethod() {
		return HealthCheckInfoDto.builder().status("success").build();
	}
}
