package com.lunaru.democli.logic.commands;

import com.lunaru.democli.logic.commands.subcommds.SubCommandSendMail;

import org.springframework.stereotype.Component;

import picocli.CommandLine;

@Component
@CommandLine.Command( name = "mainCommand",
                      version = {
                      "@|green,bg(white) Spring-picocli Demo v1.0.0|@",
                      "@|green,bg(white) Picocli: " + picocli.CommandLine.VERSION + "|@",
                      "@|red,bg(white) JVM: ${java.version} (${java.vendor} ${java.vm.name} ${java.vm.version})|@",
                      "@|red,bg(white) OS: ${os.name} ${os.version} ${os.arch}|@",
                      "@|black,bg(white) (c) 2021|@"},
                      header = "%n@|green,bg(white) Cli Application with Spring Boot, picocli and Thymeleaf|@",
                      description = "Basic example of a Cli application using Spring boot, picocli and Thymeleaf.%n",
                      subcommands = SubCommandSendMail.class,
                      mixinStandardHelpOptions = true )
//The mixinStandardHelpOptions attribute adds --help and --version options
public class MainCommand
{
    /*@CommandLine.Spec
    CommandLine.Model.CommandSpec spec;
   */
}
