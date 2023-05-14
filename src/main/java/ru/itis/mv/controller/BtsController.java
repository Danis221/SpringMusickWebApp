package ru.itis.mv.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.mv.service.BtsService;

import java.util.Random;

@RequiredArgsConstructor
@RequestMapping("api")
@RestController
public class BtsController {

    private final BtsService btsService;

    @GetMapping("/ajax/bts")
    @ResponseBody
    public String funnyBts() {
        return btsService.getRandomBts();
    }
}
