package com.arshideep.movies.repo;

import com.arshideep.movies.domain.TicketInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TickerRepo extends JpaRepository<TicketInventory, Long> {
}
