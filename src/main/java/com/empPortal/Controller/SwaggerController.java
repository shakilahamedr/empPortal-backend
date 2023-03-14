package com.empPortal.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class SwaggerController {

	@RequestMapping(value = "/swagger")
	public RedirectView redirect() {
		return new RedirectView("/swagger-ui/");
	}
}
