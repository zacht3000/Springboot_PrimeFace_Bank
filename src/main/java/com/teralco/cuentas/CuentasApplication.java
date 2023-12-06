package com.teralco.cuentas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CuentasApplication {

	private final static Logger logger = LoggerFactory
			.getLogger(CuentasApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(CuentasApplication.class, args);
		logger.info("<-------------------------------------------------Application a sido ejecutada---------------------------------------------------------------------->");
	}

}
