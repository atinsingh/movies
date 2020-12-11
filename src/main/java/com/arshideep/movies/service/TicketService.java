package com.arshideep.movies.service;


import com.arshideep.movies.domain.TicketInventory;
import com.arshideep.movies.exception.TicketNotFoundException;
import com.arshideep.movies.repo.TicketRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private TicketRepo ticketRepo;


    public List<TicketInventory> getAllTickets(){ return ticketRepo.findAll();}

    public TicketInventory getTicketById(Long id){
        Optional<TicketInventory> byId = this.ticketRepo.findById(id);
        if(!byId.isPresent()){
            throw new TicketNotFoundException("Requested Ticket"+id+"Not Avaliable");
        }else {
            return byId.get();
        }

    }
    public TicketInventory addTicket(@RequestBody TicketInventory ticketInventory){
        return ticketRepo.save(ticketInventory);
    }
    public TicketInventory updateTicket(@RequestBody TicketInventory ticketInventory){
        return ticketRepo.save(ticketInventory);
    }
    public void deleteTicket(@RequestBody TicketInventory ticketInventory){
        ticketRepo.delete(ticketInventory);
    }
}
