package com.mvc.form.functional;


import com.mvc.form.FunctionalTestBase;
import com.mvc.form.model.Entity.User;
import com.mvc.form.service.UserService;
import com.mvc.form.validator.UserFormValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.context.WebApplicationContext;


import javax.annotation.Resource;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;
import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends FunctionalTestBase {

    @Resource
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserService userService;

    @Autowired
    private UserFormValidator userFormValidator;

    private MockMvc mockMvc;

    @Before
    public void setUp(){

        Mockito.reset(userService);
        Mockito.reset(userFormValidator);
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void getUsers() throws Exception {

        ResultActions actions = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        MvcResult mvcResult = actions.andReturn();

        assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
        assertEquals(mvcResult.getModelAndView().getViewName(),"users/list");
    }

    @Test
    public void save() throws Exception {

        User user = new User();
        user.setName("testDeneme");
        user.setSurname("test");
        user.setCaptcha("asdfda");
        user.setNumbers("123");
        BindingAwareModelMap modelMap = new BindingAwareModelMap();
        LinkedHashMap userForm = new LinkedHashMap();
        userForm.put("userForm",user);
        BeanPropertyBindingResult beanPropertyBindingResult = new BeanPropertyBindingResult(user,"userForm");
        modelMap.put("org.springframework.validation.BindingResult.userForm",beanPropertyBindingResult);

        ResultActions actions = mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).param("name", user.getName())
                .sessionAttr("userForm", user))
                .andDo(MockMvcResultHandlers.print());

        MvcResult mvcResult = actions.andReturn();
        assertEquals(HttpStatus.CREATED.value(),mvcResult.getResponse().getStatus());
    }
}
