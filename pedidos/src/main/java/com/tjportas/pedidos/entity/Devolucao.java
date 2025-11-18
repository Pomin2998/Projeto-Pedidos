package com.tjportas.pedidos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString

public class Devolucao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_devolucao;
    private String produto;
    private String motivo;
    private String dataDevolucao;


    // FK para Venda
    @ManyToOne
    @JoinColumn(name = "venda_id_venda")
    private Venda venda;
}
