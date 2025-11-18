package com.tjportas.pedidos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orcamento")
    private Long idOrcamento;

    @Column(name = "data_orcamento")
    private String dataOrcamento;

    @Column(name = "valor_total")
    private Double valorTotal;

    private String cliente;

    // Relacionamento 1 → N com Venda
    @OneToMany(mappedBy = "orcamento")
    @JsonIgnore
    private List<Venda> vendas;
}