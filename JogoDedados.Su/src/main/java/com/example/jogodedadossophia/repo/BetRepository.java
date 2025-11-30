package com.example.jogodedadossophia.repo;

import com.example.jogodedadossophia.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByDonoId(Long id);
}
