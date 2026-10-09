package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class InfoController {

        @GetMapping ("/infor")
        public String getinfo() {return  "My very first Spring Boot Application";}


}
