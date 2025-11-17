package com.tjportas.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.tjportas.pedidos.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
