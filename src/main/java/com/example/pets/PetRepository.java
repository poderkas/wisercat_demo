package com.example.pets;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findPetById(Long id);

    void deletePetById(Long id);
}
