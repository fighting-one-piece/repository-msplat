package org.cisiondata.modules;

import org.cisiondata.modules.bootstrap.BaseBootstrapApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseBootstrapApplication.class)
@WebAppConfiguration 
public class DAOTest {

}