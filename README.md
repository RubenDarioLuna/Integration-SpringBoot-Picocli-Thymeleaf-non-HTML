# Integration between Spring Boot, picocli and Thymeleaf (non-HTML)

Basic integration between ***Spring Boot***, ***picocli*** and ***Thymeleaf*** (non-HTML). 

***JavaMailSender*** is used to send emails from a Spring Boot application.

Project created with [IntelliJ IDEA](https://www.jetbrains.com/idea/) and [Spring Initializr](https://start.spring.io/).

##Dependency Management

######Maven

**picocli**
```xml
<dependency>
    <groupId>info.picocli</groupId>
    <artifactId>picocli-spring-boot-starter</artifactId>
    <version>4.5.2</version>
</dependency>
```

**Thymeleaf**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
If you are missing the Apache Commons OGNL framework libraries:
```xml
<dependency>
    <groupId>ognl</groupId>
    <artifactId>ognl</artifactId>
    <version>3.1.12</version>
</dependency>
```

**JavaMailSender**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

Note: The pom already contains all the dependencies.

## Settings to send mail (sender) 

In your gmail account
1. [Set up IMAP in gmail](https://support.google.com/mail/answer/7126229?authuser=2&visit_id=637420362577166044-3739264672&hl=en&rd=1)
2. [Enable control access to less secure apps](https://support.google.com/a/answer/6260879?hl=en)

In application.properties
1. Put mail in the **spring.mail.username** property.
2. Put the mail password in the **spring.mail.password** property.

## Run

Use the maven wrapper [mvnw](https://github.com/takari/maven-wrapper) to compile and run.

```bash
mvnw spring-boot:run
```

Since we specified no command line arguments, Picocli complains about the missing required option --to and outputs the usage help. We have to pass in command line arguments into our command line call, we can use -Dspring-boot.run.arguments for that purpose:
```bash
mvnw spring-boot:run -Dspring-boot.run.arguments=" --to test.receiver@yopmail.com --subject Testmail Through this email I want to notify that the integration tests between Spring Boot, PicoCLI and Thymeleaf were successful."
```

[Check receiving mail](www.yopmail.com/?test.receiver)

Options:
 - **--to** : destination email
 - **--subject** : email subject

Parameters:
 - Space after subject : email body (message)
 
## References

- [picocli Spring Boot example](https://picocli.info/#_spring_boot_example)
- [Thymeleaf non-HTML](https://blog.codeleak.pl/2017/03/getting-started-with-thymeleaf-3-text.html)
- [Thymeleaf textual-syntax](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#textual-syntax)

