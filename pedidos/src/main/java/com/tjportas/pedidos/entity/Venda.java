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
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_venda")
    private Long idVenda;

    @Column(name = "data_venda")
    private String dataVenda;

    @Column(name = "valor_venda")
    private Double valorVenda;

    // FK padronizada para Orcamento
    @ManyToOne
    @JoinColumn(name = "orcamento_id")  // <-- NOME CORRETO
    private Orcamento orcamento;

    @OneToMany(mappedBy = "venda")
    @JsonIgnore
    private List<Devolucao> devolucoes;

    @OneToMany(mappedBy = "venda")
    @JsonIgnore
    private List<Troca> trocas;

    
}