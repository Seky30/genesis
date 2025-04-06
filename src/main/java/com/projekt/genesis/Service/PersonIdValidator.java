package com.projekt.genesis.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonIdValidator {


    private static final String PERSON_ID_FILE_PATH = "src/main/resources/dataPersonId.txt";

    private List<String> validPersonIds;

    public PersonIdValidator() {
        loadValidPersonIds();
    }

    private void loadValidPersonIds() {
        try {
            Path path = Paths.get(PERSON_ID_FILE_PATH);
            validPersonIds = Files.readAllLines(path)
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load valid person IDs", e);
        }
    }

    public boolean isValidPersonId(String personId) {
        if (validPersonIds == null) {
            loadValidPersonIds();
        }
        boolean isValid = validPersonIds.contains(personId);
        return isValid;
    }

    public void validatePersonId(String personId) {
        if (!isValidPersonId(personId)) {
            throw new RuntimeException("chyba"+personId);
        }
    }
}