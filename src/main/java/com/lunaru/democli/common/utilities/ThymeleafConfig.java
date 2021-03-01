package com.lunaru.democli.common.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean(name = "textTemplateEngine")
    public TemplateEngine textTemplateEngine()
    {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addTemplateResolver( textTemplateResolver() );
        return templateEngine;
    }

    @Bean(name = "contextTemplateEngine")
    public Context contextTemplateEngine()
    {
        return new Context();
    }

    private ITemplateResolver textTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix( "/templates/text/" );
        templateResolver.setSuffix( ".txt" );
        templateResolver.setTemplateMode( TemplateMode.TEXT );
        templateResolver.setCharacterEncoding( "UTF8" );
        templateResolver.setCheckExistence( true );
        templateResolver.setCacheable( false );
        return templateResolver;
    }
}
