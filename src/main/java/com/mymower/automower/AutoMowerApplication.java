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
        InputStream resource = new ClassPathResource("input.txt").getInputStream();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
            List<String> fileLines = reader.lines().collect(Collectors.toList());
            log.debug("Application will process positions for {} ",fileLines);

            mowerService.initialGardenWithMowers(fileLines);
            List<Position> process = mowerService.process();
            for (Position pos : process) {
                StringBuilder printPosition = new StringBuilder();
                printPosition.append(pos.getX());
                printPosition.append(pos.getY());
                printPosition.append(pos.getDirection().getCode());
                log.debug("Mower final position is {}  ",printPosition);
                System.out.println(printPosition);
            }
        } catch (IOException e) {
            log.error("cannot read file {}", e.getMessage());
            System.exit(1);
        }
    }
}
