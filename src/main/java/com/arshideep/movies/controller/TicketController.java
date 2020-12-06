package com.arshideep.movies.controller;

import com.arshideep.movies.TicketService;
import com.arshideep.movies.UserService;
import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.Order;
import com.arshideep.movies.domain.TicketInventory;
import com.arshideep.movies.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")

@Api(value = "TicketInventory", description = "TicketInventory API")
public class TicketController {
    @Autowired
    private TicketService service;



    @ApiOperation(value = "Create TicketInventory resource", response = TicketInventory.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = TicketInventory.class)})
    @PostMapping(value = "/ticket" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public TicketInventory createTicketInventory(@RequestBody TicketInventory ticketInventory) {
        return this.service.createTicket(ticketInventory);
    }

    @ApiOperation(value = "Get all TicketInventory resources", response = TicketInventory.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = TicketInventory.class)})
    @GetMapping(value = "/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketInventory> getAllTicketInventorys() {
        return this.service.getAllTickets();
    }


    @ApiOperation(value = "Finds TicketInventory by id", response = TicketInventory.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = TicketInventory.class), @ApiResponse(code = 404, message = "TicketInventory respurce does not exists") })
    @GetMapping(value = "/ticket/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketInventory getMovieById(@PathVariable("id") Long id) {
        return this.service.getTicketById(id);
    }



    @ApiOperation(value = "Delete TicketInventory ", response = TicketInventory.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 404, message = "TicketInventory resource does not exists") })
    @DeleteMapping(value = "/ticket")
    public void deleteTicketInventory(@RequestBody TicketInventory ticketInventory) {
        this.service.deleteTicketInventory(ticketInventory);
    }



    @ApiOperation(value = "Update TicketInventory resource", response = TicketInventory.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = TicketInventory.class)})
    @PutMapping(value = "/ticket" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public TicketInventory updateTicketInventory(@RequestBody TicketInventory ticketInventory) {
        return this.service.createTicket(ticketInventory);
    }

}
