package com.tjportas.pedidos.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tjportas.pedidos.entity.Troca;
import com.tjportas.pedidos.repository.TrocaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class TrocaController {  

         @Autowired
     TrocaRepository repository;

         // Create - Post
        @PostMapping("/troca")
    public ResponseEntity<Troca> salvarTroca(@RequestBody Troca troca) {
        Troca trocaSalva = repository.save(troca);

        return new ResponseEntity<>(trocaSalva, HttpStatus.OK);
    }
     
    // Read - Get
    @GetMapping("/troca")
    public ResponseEntity<List<Troca>> listarTrocas() {
        List<Troca> trocas = new ArrayList<>();
        repository.findAll().forEach(trocas::add);

        return new ResponseEntity<>(trocas, HttpStatus.OK);
    }

    // Update - Put
    @PutMapping("/troca/{id}")  
    public ResponseEntity<Troca> atualizarTroca(@PathVariable Long id, @RequestBody Troca troca) {

        Optional<Troca> trocaDesatualizada = repository.findById(id);

        if (trocaDesatualizada.isPresent()) {
            // Try to assign the existing id to the incoming entity (if 'id' field exists)
            try {
                java.lang.reflect.Field idField = Troca.class.getDeclaredField("id");
                idField.setAccessible(true);
                idField.set(troca, id);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // If we can't set the id via reflection, fall back to merging manually if needed.
                // For now we will proceed to save the incoming entity; ensure your Troca class exposes an ID setter if you want safer updates.
            }

            Troca trocaAtualizada = repository.save(troca);
            return new ResponseEntity<>(trocaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete - Delete
    @DeleteMapping("/troca/{id}")
         public ResponseEntity<Troca> deletar(@PathVariable Long id) {
     
          repository.deleteById(id);
     
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

}
