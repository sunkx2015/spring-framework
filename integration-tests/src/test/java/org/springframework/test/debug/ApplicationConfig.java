package org.springframework.test.debug;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component("org.springframework.test.service.*")
public class ApplicationConfig {

}
