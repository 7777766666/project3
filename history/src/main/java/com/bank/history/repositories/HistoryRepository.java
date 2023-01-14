package com.bank.history.repositories;

import com.bank.history.models.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, Long> {
    Optional<History> findById(Long id);
    List<History> findAll();


}
