package com.tjportas.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.tjportas.pedidos.entity.Devolucao;

@Repository
public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {

}
