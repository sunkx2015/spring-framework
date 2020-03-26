package com.sun.spring.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(value = {"com.sun.spring.test"},excludeFilters = {
		@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {com.sun.spring.test.filter.myFilter.class})}
		)
public class SpringStartConfig {
}
