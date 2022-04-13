package com.dev.spring.devspring.repositories;

import java.util.List;

import com.dev.spring.devspring.domain.Anime;

public interface AnimeRepository {
    List<Anime> listAll();
}
