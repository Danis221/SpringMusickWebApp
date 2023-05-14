package ru.itis.mv.service.impl;

import org.springframework.stereotype.Service;
import ru.itis.mv.service.BtsService;

import java.util.Random;

@Service
public class BtsServiceImpl implements BtsService {
    @Override
    public String getRandomBts() {
        String[] namesArr = {"Nadjyn", "Chonguk", "Chingachkyk", "Goiko", "Mitch", "Djin", "Uingi"};
        Random r = new Random();
        return namesArr[r.nextInt(namesArr.length)];
    }
}
