package com.sparta.samplememo1;

import com.sparta.samplememo1.model.Memo;
import com.sparta.samplememo1.service.Const;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.nio.charset.Charset;
import java.util.ArrayList;

@EnableJpaAuditing // 시간 자동 변경이 가능하도록 합니다.
@SpringBootApplication // 스프링 부트임을 선언합니다.
@CrossOrigin(origins = Const.ClientServerHost)
public class Samplememo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Samplememo1Application.class, args);
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }



}
