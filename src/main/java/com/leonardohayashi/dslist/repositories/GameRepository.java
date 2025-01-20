package com.leonardohayashi.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardohayashi.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
