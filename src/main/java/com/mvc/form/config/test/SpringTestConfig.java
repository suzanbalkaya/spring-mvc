package com.mvc.form.config.test;

import com.mvc.form.model.dao.UserDao;
import com.mvc.form.service.UserService;
import com.mvc.form.validator.UserFormValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.mockito.Mockito;
@Configuration
public class SpringTestConfig {


    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames("messages/messages", "messages/validation");
        return rb;
    }

    @Bean
    public UserFormValidator userFormValidator() {
        return Mockito.mock(UserFormValidator.class);
    }

    @Bean
    public UserService userService(){

        return Mockito.mock(UserService.class);
    }
    @Bean
    public UserDao daoRes(){
        return Mockito.mock(UserDao.class);
    }
}
