package com.mvc.form.config.proje;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.mvc.form.model.dao")
public class SpringDBConfig {
//mongoDB connection has been defined
	@Bean
	public Mongo mongo() throws Exception {
		return new Mongo("localhost",27017);
	}
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(),"odev");
	}
}
