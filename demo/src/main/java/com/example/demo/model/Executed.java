package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Executed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Orders ordersList;
    @OneToOne
    private Comment comment;

}
