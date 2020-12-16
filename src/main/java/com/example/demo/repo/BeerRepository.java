package com.example.demo.repo;

import com.example.demo.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface BeerRepository extends JpaRepository<Beer, Long> {
}

