package com.lgtecnologies.springboot.app.commos;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})//desabilitando el datasource para conectar Base de datos
public class SpringbootServicioCommonsApplication {

	
}
