package com.lunaru.democli.common.utilities;

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
    @PropertySource("classpath:errors.properties")
})
public class PropertiesConfig
{
}
