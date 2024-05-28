package it.marconi.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prodotto {
    private String codice;
    private String nome;
    private String categoria;
    private int annoProduzione;
    private int quantita;
}
