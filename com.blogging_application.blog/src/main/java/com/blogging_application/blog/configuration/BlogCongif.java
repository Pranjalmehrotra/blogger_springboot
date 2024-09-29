package com.blogging_application.blog.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogCongif {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
