package com.m20a20x.hairfactorybackend.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    @Bean("gMailFrom")
    public String getGMmailFrom() {
        return "catherine.vasyuk11@gmail.com";
    }

    @Bean("gMailTo")
    public String getGMailTo() {
        return "maks0681912507@gmail.com";
    }

    @Bean("gMailSender")
    public JavaMailSender getJavaGMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("catherine.vasyuk11@gmail.com");
        mailSender.setPassword("gvjtdtivpyogxejc");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }

    // @Bean
    // public WebMvcConfigurer corsConfigurer() {
    // return new WebMvcConfigurer() {
    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // registry.addMapping("/**").allowedOrigins("*");
    // }
    // };
    // }
}
