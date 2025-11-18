package com.tjportas.pedidos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private String dataOrcamento;
    private Double valorTotal;
    private String cliente;


    // Relacionamento 1 → N com Venda
    @OneToMany(mappedBy = "orcamento")
    @JsonIgnore
    private List<Venda> vendas;
}
