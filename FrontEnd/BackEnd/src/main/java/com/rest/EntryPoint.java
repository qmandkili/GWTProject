package com.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by InsideWorld on 15.06.2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rest")
public class EntryPoint {
}
