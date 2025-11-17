package com.tjportas.pedidos.entity;

import java.sql.Date;

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


public class Troca {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_troca;
    private String produto;
    private String motivo;
    private Date troca;
    private String produto_novo;
    private Double diferenca_valor;
    private String cliente;
    

    

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;


}
