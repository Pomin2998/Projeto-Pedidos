package com.tjportas.pedidos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_venda;
    private String datavenda;
    private Double valorVenda;


     // FK para Orcamento
    @ManyToOne
    @JoinColumn(name = "orcamento_id_orcamento")
    private Orcamento orcamento;

    // Relacionamento 1 → N com Devolucao
    @OneToMany(mappedBy = "venda")
    @JsonIgnore
    private List<Devolucao> devolucoes;

    // Relacionamento 1 → N com Troca
    @OneToMany(mappedBy = "venda")
    @JsonIgnore
    private List<Troca> trocas;
}
