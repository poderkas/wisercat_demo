package com.example.pets;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public Pet updatePet(Pet pet) {
        Long id = pet.getId();
        petRepository.deletePetById(id);
        return petRepository.save(pet);
    }

    public Pet findPetById(Long id) throws Exception {
        return petRepository.findPetById(id)
                .orElseThrow(() -> new Exception("shii"));
    }

    public void deletePet(Long id){
        petRepository.deletePetById(id);
    }
}