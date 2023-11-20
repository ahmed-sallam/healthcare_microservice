package com.saif.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
//    scanBasePackages = {
//        "com.saif.shared",
//        "com.saif.appointment"
//
//    }
)
@EnableFeignClients(
    basePackages = {
        "com.saif.shared"
    }
)
public class AppointmentApplication {
  public static void main(String[] args) {
    SpringApplication.run(AppointmentApplication.class, args);
  }
}