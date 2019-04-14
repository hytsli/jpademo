package com.example.jpademo.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "jap_test")
public class TestDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String description;
}