package com.example.latriumback.dto.board;

import com.example.latriumback.entity.Theme;

import java.util.List;
import java.util.stream.Collectors;

public class ThemeDTO {
    private Long idTheme;
    private String name;
    private String iconSvg;
    private List<ThemeDTO> subThemes;

    public ThemeDTO(Long idTheme, String name, String iconSvg, List<ThemeDTO> subThemes) {
        this.idTheme = idTheme;
        this.name = name;
        this.subThemes = subThemes;
        this.iconSvg = iconSvg;
    }

    public Long getIdTheme() {
        return idTheme;
    }

    public String getName() {
        return name;
    }

    public String getIconSvg() {
        return iconSvg;
    }

    public List<ThemeDTO> getSubThemes() {
        return subThemes;
    }

    public static ThemeDTO convertToDTO(Theme theme) {
        return new ThemeDTO(
                theme.getIdTheme(),
                theme.getName(),
                theme.getIconSvg(),
                theme.getSubThemes().stream().map(ThemeDTO::convertToDTO).collect(Collectors.toList())
        );
    }

    public static Theme convertToEntity(ThemeDTO theme) {
        return new Theme(theme.getIdTheme(), theme.getName(), theme.getIconSvg());
    }
}
