package com.mymower.automower;

import com.mymower.automower.model.Position;
import com.mymower.automower.service.MowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootApplication
public class AutoMowerApplication implements CommandLineRunner {
    @Autowired
    private MowerService mowerService;

    public static void main(String[] args) {
        SpringApplication.run(AutoMowerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("AutoMowerApplication Start ... ");

//TODO get file from args path , path can be like this "file:C:\\input.txt"

        String inputFilePath = "classpath:input.txt";
        List<Position> finalPositionOfMowersFromFile = this.mowerService.getFinalPositionOfMowersFromFile(inputFilePath);

        for (Position pos : finalPositionOfMowersFromFile) {
            StringBuilder printPosition = new StringBuilder();
            printPosition.append(pos.getX());
            printPosition.append(pos.getY());
            printPosition.append(pos.getDirection().getCode());
            log.debug("Mower final position is {}  ", printPosition);
            System.out.println(printPosition);
        }

    }
}
