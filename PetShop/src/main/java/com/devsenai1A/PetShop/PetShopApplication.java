package com.devsenai1A.PetShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PetShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetShopApplication.class, args);
	}
    @RestController
    static class HelloWorldController {
    	
    	@GetMapping ("/")
    	public String helloWord() {
    		return "Hello Word!";
    	}
    }
}

