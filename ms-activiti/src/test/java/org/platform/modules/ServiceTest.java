package org.platform.modules;

import org.junit.runner.RunWith;
import org.platform.modules.bootstrap.BootstrapApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootstrapApplication.class)
@WebAppConfiguration
public class ServiceTest {
	
	
}
