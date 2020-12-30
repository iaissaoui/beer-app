package com.example.demo.repo;

import com.example.demo.model.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface ErrorRepository extends JpaRepository<ErrorLog, Long> {
}

