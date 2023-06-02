package com.example.nplusone.repository;

import com.example.nplusone.entity.Filial;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {

    //@Query("Select f FROM Filial f LEFT JOIN f.company c WHERE f.id = :id")
    Optional<Filial> findById(@Param("id") Long id);
}
