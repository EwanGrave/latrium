package com.example.latriumback.service;

import com.example.latriumback.dto.board.ThemeDTO;
import com.example.latriumback.entity.Theme;
import com.example.latriumback.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    public List<ThemeDTO> getAllThemes() {
        List<Theme> themes = themeRepository.findAll();
        return themes.stream().map(ThemeDTO::convertToDTO).collect(Collectors.toList());
    }
}
