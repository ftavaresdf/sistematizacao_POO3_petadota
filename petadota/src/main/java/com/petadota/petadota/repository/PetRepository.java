package com.petadota.petadota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petadota.petadota.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}

