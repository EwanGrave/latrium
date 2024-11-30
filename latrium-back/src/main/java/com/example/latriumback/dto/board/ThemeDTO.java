package com.example.latriumback.dto.board;

import com.example.latriumback.entity.Theme;

import java.util.List;
import java.util.stream.Collectors;

public class ThemeDTO {
    private Long idTheme;
    private String name;
    private List<ThemeDTO> subThemes;

    public ThemeDTO(Long idTheme, String name, List<ThemeDTO> subThemes) {
        this.idTheme = idTheme;
        this.name = name;
        this.subThemes = subThemes;
    }

    public Long getIdTheme() {
        return idTheme;
    }

    public String getName() {
        return name;
    }

    public List<ThemeDTO> getSubThemes() {
        return subThemes;
    }

    public static ThemeDTO convertToDTO(Theme theme) {
        return new ThemeDTO(
                theme.getIdTheme(),
                theme.getName(),
                theme.getSubThemes().stream().map(ThemeDTO::convertToDTO).collect(Collectors.toList())
        );
    }
}
