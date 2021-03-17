package com.lunaru.democli.common.utilities.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 2/28/2021
 */
@Configuration
@PropertySources({
    @PropertySource("classpath:info.properties"),
    @PropertySource("classpath:errors.properties"),
    @PropertySource("classpath:commandInfo.properties"),
    @PropertySource("classpath:startSpringIo.properties")
})
public class PropertiesConfig
{
}
