package com.arshideep.movies.controller;

import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.TicketInventory;
import com.arshideep.movies.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public List<TicketInventory> getAllTickets(){
        return  ticketService.getAllTickets();
    }
    @GetMapping("/id")
    public TicketInventory getTicketById(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public TicketInventory addTicket(@RequestBody TicketInventory ticketInventory){
        return ticketService.addTicket(ticketInventory);
    }
/*
Ticket update mapping should have been for updating status from Active to Cancel.
 */
    @PutMapping
    public TicketInventory updateMovie(@RequestBody TicketInventory ticketInventory) { return ticketService.updateTicket(ticketInventory);}
    /*
    Ticket delete mapping may not be required.
     */
    @DeleteMapping
    public void deleteTicket(@RequestBody TicketInventory ticketInventory) { ticketService.deleteTicket(ticketInventory); }

}
