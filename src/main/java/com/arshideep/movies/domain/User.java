package com.arshideep.movies.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name="table_user")
public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)

      private Long userId;

      public User(@NonNull String firstName, @NonNull String lastName, @NonNull String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
      }

      @Column(length = 255)
      @NonNull private String firstName;

      @Column(length = 255)
      @NonNull private String lastName;

      @Column(length = 255)
      @NonNull private String email;
}
