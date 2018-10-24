package br.com.cervejaria.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.cervejaria.brewer.service.CervejasService;

@Configuration
@ComponentScan(basePackageClasses = CervejasService.class)
public class ServiceConfig {
	
	
}
