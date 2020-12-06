package com.github.prashanth.ashok.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootDemoApplicationTests {

	@Autowired
	private GenericEntityController genericController;

	@Autowired
	private SpringBootDemoApplication homeController;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() throws Exception {
		assertThat(genericController).isNotNull();
		assertThat(homeController).isNotNull();
	}

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception{
		ResponseEntity<String> response = this.homeController.get();
		assertThat(response).isNotNull();
	}

	@Test
	public void GenericEntityAddsEntity() throws Exception {
		GenericEntity entity = new GenericEntity();
		entity.id = 1L;
		entity.value = "Nina";
		//GenericEntity addedEntity = this.genericController.addEntity(entity);
		assertThat(this.genericController.addEntity(entity)).isEqualTo(entity);
		List<GenericEntity> entityList = this.genericController.findAll();
	}



}
