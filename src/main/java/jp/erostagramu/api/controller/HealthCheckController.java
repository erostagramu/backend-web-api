package jp.erostagramu.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/healthCheck")
public class HealthCheckController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HealthCheckInfoDto validateGetMethod() {
		HealthCheckInfoDto dto = new HealthCheckInfoDto();
		dto.setStatus("success");
		return dto;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public HealthCheckInfoDto validatePostMethod() {
		HealthCheckInfoDto dto = new HealthCheckInfoDto();
		dto.setStatus("success");
		return dto;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public HealthCheckInfoDto validatePutMethod() {
		HealthCheckInfoDto dto = new HealthCheckInfoDto();
		dto.setStatus("success");
		return dto;
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public HealthCheckInfoDto validateDeleteMethod() {
		HealthCheckInfoDto dto = new HealthCheckInfoDto();
		dto.setStatus("success");
		return dto;
	}
}
