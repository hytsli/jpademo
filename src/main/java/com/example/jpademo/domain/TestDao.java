package com.example.jpademo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TestDao extends JpaRepository<TestDO, Long> {
}
