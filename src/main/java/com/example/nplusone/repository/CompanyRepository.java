package com.example.nplusone.repository;

import com.example.nplusone.entity.Company;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

//        @Query("FROM Company c LEFT JOIN FETCH c.users WHERE c.id = :id")
////    @EntityGraph(value = "Company.users")
//    Optional<Company> findById(@Param("id") Long id);
}
