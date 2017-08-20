package com.mvc.form;

import com.mvc.form.config.test.SpringTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringTestConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class FunctionalTestBase {

    @Test
    public void testLoad() {

    }
}
