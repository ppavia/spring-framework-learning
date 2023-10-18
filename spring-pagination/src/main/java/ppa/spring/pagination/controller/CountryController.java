package ppa.spring.pagination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {


    @GetMapping("/country")
    public String loadContry() {
        throw new Error("toto");

    }

}
