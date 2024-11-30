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

    @ManyToMany(mappedBy = "themes")
    private Set<Board> boards;

    @OneToMany(mappedBy = "parentTheme", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Theme> subThemes;

    @ManyToOne
    @JoinColumn(name="id_subtheme", nullable=false)
    private Theme parentTheme;

    public Theme() {}

    public Long getIdTheme() {
        return idTheme;
    }

    public String getName() {
        return name;
    }

    public Set<Theme> getSubThemes() {
        return subThemes;
    }
}
