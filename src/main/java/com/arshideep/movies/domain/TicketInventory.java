package com.arshideep.movies.domain;

import lombok.*;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class TicketInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @NonNull  private Movie movie;

    @NonNull private Long inventoryCount;

}
