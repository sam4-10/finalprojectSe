package edu.miu.mumschedule.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
//        String sam = "eyuel"; // secret key used by password encoding
//            // hash width in bits
//
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//      //  String encodedPassword = pbkdf2PasswordEncoder.encode(plainPassword);
//        System.out.println(bCryptPasswordEncoder.encode(sam));
    }

}
