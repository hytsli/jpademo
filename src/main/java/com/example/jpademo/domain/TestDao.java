package com.example.jpademo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  TestDao extends JpaRepository<TestDO, Long> {
    List<TestDO> findByDescription(String description);

    Optional<TestDO> findByName(String name);

    @Query("select t from TestDO t where t.description = ?1")
    Page<TestDO> findPageByDescription(String description, Pageable page);

    @Query(nativeQuery =true,value = "select * from jap_test  where description = ?")
    Page<TestDO> findPageByDescriptionInSql(String description, Pageable page);
}
