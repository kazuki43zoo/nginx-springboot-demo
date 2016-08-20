package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.io.Serializable;

@SpringBootApplication
public class NginxSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NginxSpringbootDemoApplication.class, args);
    }

    @RestController
    static class HelloRestController {

        @RequestMapping("/hello")
        String hello() {
            return "Hello";
        }

    }

    @RestController
    static class FileUploadRestController {

        @RequestMapping("/files")
        String upload(MultipartFile multipartFile) {
            return multipartFile.getOriginalFilename();
        }

        @ExceptionHandler
        @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
        public ApiError handleMultipartException(MultipartException e) {
            e.printStackTrace();
            ApiError error = new ApiError();
            error.setCode("UPLOAD_SIZE_ERROR");
            return error;
        }

    }

    static class ApiError implements Serializable {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    @Configuration
    static class WebMvcConfig {
        @Bean
        StandardServletMultipartResolver multipartResolver() {
            StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
            resolver.setResolveLazily(true);
            return resolver;
        }
    }


}
