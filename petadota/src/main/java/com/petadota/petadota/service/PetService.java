package com.petadota.petadota.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petadota.petadota.entity.Pet;
import com.petadota.petadota.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<Pet> listarTodos() {
        return repository.findAll();
    }

    public Pet salvar(Pet pet) {
        return repository.save(pet);
    }

    public Pet buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pet não encontrado"));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
