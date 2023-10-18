package com.example.moiveAppMicroservice.repositories;

import com.example.moiveAppMicroservice.moive.Moive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoiveRepository extends CrudRepository<Moive,String> {
    Page<Moive> findAll(Pageable pageable);

}
