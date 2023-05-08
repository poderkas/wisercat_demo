package com.example.pets;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        pet.setPetCode(UUID.randomUUID().toString());
        return petRepository.save(pet);
    }

    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public Pet updateEmployee(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet findPetById(Long id) {
        return petRepository.findPetById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePet(Long id){
        petRepository.deletePetById(id);
    }
}