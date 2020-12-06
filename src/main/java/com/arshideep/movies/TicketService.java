package com.arshideep.movies;

import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.TicketInventory;
import com.arshideep.movies.repo.MovieRepo;
import com.arshideep.movies.repo.TickerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TickerRepo repo;


    public TicketInventory createTicket(TicketInventory ticket) {
        return repo.save(ticket);
    }

    public List<TicketInventory> getAllTickets() {
        return this.repo.findAll();
    }

    public TicketInventory getTicketById(Long id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("TicketInventory Not Found"));
    }

    public void deleteTicketInventory(TicketInventory ticketInventory){
        repo.delete(ticketInventory);
    }
}

