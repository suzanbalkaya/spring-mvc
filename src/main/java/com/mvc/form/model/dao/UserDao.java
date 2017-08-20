package com.mvc.form.model.dao;


import com.mvc.form.model.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository interface of Spring library used for Db operations
public interface UserDao extends MongoRepository<User,String >{
    //The query,pull user information with ID 
    User findById(String id);
}
