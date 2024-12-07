package com.example.latriumback.controller;

import com.example.latriumback.dto.board.ThemeDTO;
import com.example.latriumback.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
