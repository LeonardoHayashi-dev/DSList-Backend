package com.leonardohayashi.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardohayashi.dslist.dto.GameListDTO;
import com.leonardohayashi.dslist.entities.GameList;
import com.leonardohayashi.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	
	public List<GameListDTO> findAll () {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO (x)).toList();
		
	}
	
}
