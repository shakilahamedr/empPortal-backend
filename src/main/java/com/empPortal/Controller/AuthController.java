package com.empPortal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empPortal.Service.CustomUserDetailsService;
import com.empPortal.Service.EmployeeService;
import com.empPortal.helper.JwtUtil;
import com.empPortal.model.Employee;
import com.empPortal.model.User;
import com.empPortal.repository.UserRepository;
import com.empPortal.vo.JwtRequest;
import com.empPortal.vo.JwtResponse;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/register")
	public Employee register(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PostMapping("/login")
	public Employee login(@RequestBody JwtRequest credentials) {
		User user = userRep.findByUsername(credentials.getUsername());
//		employeeService.getEmployeeById(user.getEmp());
		return user.getEmp();
	}
	
	
	@RequestMapping(value = "/generateToken", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		}catch(UsernameNotFoundException e){
			e.printStackTrace();
			throw new Exception("User Not Found");
		}catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT "+token);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@GetMapping("/secureHi")
	public String getAuthTest(@RequestHeader("Authorization") String authorization) {
		return "Hi Shakil with security";
	}
	
//	@PostMapping("/postmethod")
//	public JwtRequest testPost() {
//		JwtRequest jwtReq = {
//				username = "shakil",
//				password = "test123"
//		}
//		return username:
//	}
	
}
