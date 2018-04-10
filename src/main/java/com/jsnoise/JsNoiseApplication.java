package com.jsnoise;

import com.jsnoise.config.BasicAuthCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsNoiseApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JsNoiseApplication.class, args);
	}
}
