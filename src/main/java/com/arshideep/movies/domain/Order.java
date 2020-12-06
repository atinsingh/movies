package com.arshideep.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="table_order")
@NoArgsConstructor

@Data
public class Order {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Order( User user,Movie movie, Date orderDate) {
        this.user = user;
        this.movie = movie;
        this.orderDate = orderDate;
    }

    @OneToOne
    private User user;

    @OneToOne
    private Movie movie;

    private Date orderDate;

}
