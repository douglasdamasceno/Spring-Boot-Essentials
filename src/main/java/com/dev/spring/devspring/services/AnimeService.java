package com.dev.spring.devspring.services;

import com.dev.spring.devspring.domain.Anime;
import com.dev.spring.devspring.dtos.AnimePostRequestBody;
import com.dev.spring.devspring.dtos.AnimePutRequestBody;
import com.dev.spring.devspring.exceptions.BadRequestException;
import com.dev.spring.devspring.mapper.AnimeMapper;
import com.dev.spring.devspring.repositories.AnimeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }
    public List<Anime> listAllNonPageable() {
		return animeRepository.findAll();
	}
    public List<Anime> findByName(String name) {
    	return animeRepository.findByName(name);
    }
    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime ID not Found"));
    }
    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }
    public void update(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
	
}
