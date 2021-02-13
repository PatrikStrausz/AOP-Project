package sk.it.strausz.service;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class CarService {


    public String getHint(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int hp = random.nextInt();
        return "Your car has "+hp+" HP";
    }
}
