package com.example.latriumback.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_theme")
    private Long idTheme;
    private String name;
    @Column(name = "icon_svg")
    private String iconSvg;

    @ManyToMany(mappedBy = "themes")
    private Set<Board> boards;

    @OneToMany(mappedBy = "parentTheme", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Theme> subThemes;

    @ManyToOne
    @JoinColumn(name="id_subtheme")
    private Theme parentTheme;

    public Theme() {}

    public Theme(Long idTheme, String name, String iconSvg) {
        this.idTheme = idTheme;
        this.name = name;
        this.iconSvg = iconSvg;
    }

    public Long getIdTheme() {
        return idTheme;
    }

    public String getName() {
        return name;
    }

    public Set<Theme> getSubThemes() {
        return subThemes;
    }

    public String getIconSvg() {
        return iconSvg;
    }
}
