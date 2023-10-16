package com.example.moiveAppMicroservice.repositories;

import com.example.moiveAppMicroservice.moive.Moive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoiveRepository extends CrudRepository<Moive,String> {
    public Page<Moive> findAll(Pageable pageable);

//    Optional<Moive> findById(String id);
}
