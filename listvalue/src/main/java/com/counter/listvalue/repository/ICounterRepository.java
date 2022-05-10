package com.counter.listvalue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.counter.listvalue.entity.Counter;

@Repository
public interface ICounterRepository extends JpaRepository<Counter, Long>{

}
