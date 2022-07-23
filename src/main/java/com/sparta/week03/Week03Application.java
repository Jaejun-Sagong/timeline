package com.sparta.week03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //우리JPA쓸껀데 뭔가 데이터 변동이 있으면 알아서 반영해줘
@SpringBootApplication
public class Week03Application {

    public static void main(String[] args) {
        SpringApplication.run(Week03Application.class, args);
    }

}
