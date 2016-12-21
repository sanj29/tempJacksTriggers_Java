package com.test.rest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
public class AuthenticationController {

	@ResponseBody
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<AuthenticationResource> authenticate(@RequestBody AuthenticationRequest request){
		LOG.debug("Request: {}", request);
		User user = userService.retrieveByUsernameOnlyNormal(request.getIdentifier());
		
		if(user == null)
			return new ResponseEntity<AuthenticationResource>(new AuthenticationResource(HttpStatus.UNAUTHORIZED.getReasonPhrase(), 
					HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED);
			
		return new ResponseEntity<AuthenticationResource>(authenticationResourceAssembler.toResource(user), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/authenticate/superadmin", method = RequestMethod.POST, produces = "application/json;CHARSET=UTF-8")
	public ResponseEntity<AuthenticationResource> authenticateSuperadmin(@RequestBody AuthenticationRequest request){
		LOG.debug("Request: {}", request);
		User user = userService.retrieveByUsernameOnlySuperadmin(request.getIdentifier());
		
		if(user == null)
			return new ResponseEntity<AuthenticationResource>(new AuthenticationResource(HttpStatus.UNAUTHORIZED.getReasonPhrase(), 
					HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED);
		
		return new ResponseEntity<AuthenticationResource>(authenticationResourceAssembler.toResource(user), HttpStatus.OK);
	}
	
	@Autowired private AuthenticationResourceAssembler authenticationResourceAssembler;  
	@Autowired private UserService userService;
	
	private static final Logger LOG = LoggerFactory.make();
}
