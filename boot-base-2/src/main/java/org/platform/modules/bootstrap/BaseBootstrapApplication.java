package org.platform.modules.bootstrap;

import org.platform.modules.bootstrap.annotation.ComponentScanExclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.platform" }, excludeFilters = {@ComponentScan.Filter(
	type = FilterType.ANNOTATION, value = ComponentScanExclude.class)})
public class BaseBootstrapApplication extends SpringBootServletInitializer {

	protected static Logger LOG = LoggerFactory.getLogger(BaseBootstrapApplication.class);

}
