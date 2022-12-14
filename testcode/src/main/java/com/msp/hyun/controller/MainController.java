package com.msp.hyun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msp.hyun.DTO.UserDTO;

@RestController
public class MainController {
	
	@GetMapping("/hello")
	public String hello() {
		
		return "hello";
	}
	
	@GetMapping("/bye")
	public String bye() {
		
		return "bye";
	}

	@GetMapping("/user")
	public String bye(@RequestBody UserDTO ud) {
		String info = "안녕하세요 "+ud.getAge()+"살 "+ ud.getName() + "입니다";
		System.out.println(info);
		return info;
	}

}


