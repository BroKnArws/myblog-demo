package com.strutnut.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:token.properties")
public class TokenUtils {


    @Value("${token.secert}")
    public String secert;

    @Value("${token.expiration}")
    public Long expiration;
}
