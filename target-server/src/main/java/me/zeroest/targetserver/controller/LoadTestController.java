package me.zeroest.targetserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/load-test")
public class LoadTestController {

    @GetMapping("/sleep/{milliseconds}")
    public void sleep(
            @PathVariable long milliseconds
    ) throws InterruptedException {
        Random random = new Random();
        int index = random.nextInt(10);
        if (index == 9) {
            throw new IllegalStateException();
        }

        long start = System.currentTimeMillis();
        Thread.sleep(milliseconds);
        long end = System.currentTimeMillis();
        log.info("LoadTest - sleep : {}", (end - start));
    }

}
