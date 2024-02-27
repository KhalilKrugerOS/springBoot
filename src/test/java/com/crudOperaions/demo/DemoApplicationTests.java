package com.crudOperaions.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
class DemoApplicationTests {
	@Autowired
	ClientRepository repository;
	@Test
	void contextLoads() {
	}
	@Test
	public void testRepository() {
		Client c = new Client();
		c.setAge(20);
		c.setName("Adel");
		repository.save(c);
		assertEquals(1, repository.findAll().size());

		Client loadedClient = repository.findById(c.getId()).get();
		assertEquals("Adel", loadedClient.getName());
		assertEquals(20, loadedClient.getAge());
		c.setName("Mourad");

		repository.save(c);
		Client updatedClient = repository.findById(c.getId()).get();
		assertEquals("Mourad", updatedClient.getName());
		assertEquals(20, updatedClient.getAge());
		repository.delete(c);
		assertEquals( 0 ,repository.findAll().size());
	}
}