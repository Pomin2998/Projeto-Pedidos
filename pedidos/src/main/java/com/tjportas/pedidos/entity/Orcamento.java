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

public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_orcamento; 
    private Data data;
    private Double valor_total;
    private String cliente;



@ManyToOne
    @JoinColumn(name = "id_orcamento")
    private Orcamento orcamento;




}
