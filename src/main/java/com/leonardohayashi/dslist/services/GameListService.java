package com.leonardohayashi.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardohayashi.dslist.dto.GameListDTO;
import com.leonardohayashi.dslist.entities.GameList;
import com.leonardohayashi.dslist.projections.GameMinProjection;
import com.leonardohayashi.dslist.repositories.GameListRepository;
import com.leonardohayashi.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;

	
	public List<GameListDTO> findAll () {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO (x)).toList();
		
	}
	
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(destinationIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		
		for (int i = min; i<= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
