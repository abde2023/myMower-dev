package com.mymower.automower.service;

import com.mymower.automower.exceptions.CannotReadFileException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileReaderService {

    private final ResourceLoader resourceLoader;

    /**
     * Read a file from path, file can be placed in classpath or from fileSystem
     *
     * @param path
     * @return
     */
    List<String> readAndProcessFile(String path) {
        Resource classPathResource = resourceLoader.getResource(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            log.error("cannot read file {}", e.getMessage());
            throw new CannotReadFileException();
        }

    }
}
