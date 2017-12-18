package com.zms.girl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GirlController {
    @Getter
    @Setter
    private GirlService girlService;
    @GetMapping(value = "/getList")
    public List<Girldb> getList(){

        return girlService.findAll();
    }
}
