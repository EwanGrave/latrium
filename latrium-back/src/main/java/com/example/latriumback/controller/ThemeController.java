package com.example.latriumback.controller;

import com.example.latriumback.dto.board.ThemeDTO;
import com.example.latriumback.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/theme", produces = MediaType.APPLICATION_JSON_VALUE)
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @GetMapping("/all")
    public List<ThemeDTO> getAllThemes() {
        return themeService.getAllThemes();
    }

    @PostMapping("")
    public ResponseEntity<String> saveTheme(@RequestBody ThemeDTO theme) {
        try {
            themeService.saveTheme(theme);
            return ResponseEntity.status(HttpStatus.CREATED).body("Theme created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating theme : " + e.getMessage());
        }
    }
}
