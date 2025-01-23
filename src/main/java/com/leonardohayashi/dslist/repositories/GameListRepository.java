package com.leonardohayashi.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardohayashi.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
