package it.marconi.catalogo.services;

import org.springframework.stereotype.Service;

import it.marconi.catalogo.model.Prodotto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdottoService {

    private List<Prodotto>  prodotti = new ArrayList<>();

    public ProdottoService() {
        // Dati di esempio
        prodotti.add(new Prodotto("P001", "Prodotto 1", "Categoria 1", 2021, 10));
        prodotti.add(new Prodotto("P002", "Prodotto 2", "Categoria 2", 2022, 5));
    }

    public List<Prodotto> getAllProdotti() {
        return prodotti;
    }

    public void saveProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public Prodotto getProdottoByCodice(String codice) {
        return prodotti.stream().filter(p -> p.getCodice().equals(codice)).findFirst().orElse(null);
    }

    public void deleteProdottoByCodice(String codice) {
        prodotti.removeIf(p -> p.getCodice().equals(codice));
    }

    public void deleteAllProdotti() {
        prodotti.clear();
    }
}

