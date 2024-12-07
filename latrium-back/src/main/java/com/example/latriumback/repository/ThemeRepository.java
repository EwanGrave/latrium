package com.example.latriumback.repository;

import com.example.latriumback.entity.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {
    @Override
    List<Theme> findAll();
}
