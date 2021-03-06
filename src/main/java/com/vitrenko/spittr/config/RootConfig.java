package com.vitrenko.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by vitalii on 12.07.16.
 */
@Configuration
@ComponentScan(basePackages = "com.vitrenko.spittr.model")
@Import({RepositoryConfig.class})
public class RootConfig {
}
