package com.test.api.rest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/api")
@Controller
public class LoginWS {
	
	@Autowired private APIService apiService;

	@RequestMapping(value = {"/v1/login/{accountId:[\\d]+}", "/latest/login/{accountId:[\\d]+}"}, method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE);
	
	public @ResponseBody ResponseEntity<ProfileDTO> getUserProfile(
			@PathVariable Integer accountId,
			@Validated @RequestBody LoginForm form,
			BindingResult result) throws InvalidRestException{
		
		if(result.hasErrors()) {
			LOG.warn(" == Errors:" + result.getAllErrors());
			throw new InvalidRestException("Error Params", result);
		}
		
		return new ResponseEntity<ProfileDTO>(apiService.authentication(form, accountId), HttpStatus.OK);
	}
	
	private static final Logger LOG = LoggerFactory.make();
}
