package com.tjportas.pedidos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
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
public class Troca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_troca")
    private Long idTroca;

    @Column(name = "data_troca")
    private String dataTroca;

    @Column(name = "motivo")
    private String motivo;

    // FK para Venda
    @ManyToOne
    @JoinColumn(name = "venda_id_venda")
    private Venda venda;
}