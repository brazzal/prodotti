package it.marconi.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.marconi.catalogo.model.Prodotto;
import it.marconi.catalogo.services.ProdottoService;

@Controller
public class CatalogoController {

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping("/catalogo")
    public String viewCatalogo(Model model) {
        model.addAttribute("prodotti", prodottoService.getAllProdotti());
        return "catalogo";
    }

    @GetMapping("/prodotto/nuovo")
    public String showNewProdottoForm(Model model) {
        Prodotto prodotto = new Prodotto();
        model.addAttribute("prodotto", prodotto);
        return "formProdotto";
    }

    @PostMapping("/prodotto/salva")
    public String saveProdotto(@ModelAttribute("prodotto") Prodotto prodotto) {
        prodottoService.saveProdotto(prodotto);
        return "redirect:/catalogo";
    }

    @GetMapping("/prodotto/{codice}")
    public String viewDettaglioProdotto(@PathVariable(value = "codice") String codice, Model model) {
        Prodotto prodotto = prodottoService.getProdottoByCodice(codice);
        model.addAttribute("prodotto", prodotto);
        return "dettaglio";
    }

    @GetMapping("/prodotto/elimina/{codice}")
    public String deleteProdotto(@PathVariable(value = "codice") String codice) {
        prodottoService.deleteProdottoByCodice(codice);
        return "redirect:/catalogo";
    }

    @GetMapping("/catalogo/svuota")
    public String deleteAllProdotti() {
        prodottoService.deleteAllProdotti();
        return "redirect:/catalogo";
    }

    @GetMapping("/prodotto/modifica/{codice}")
    public String showUpdateProdottoForm(@PathVariable(value = "codice") String codice, Model model) {
        Prodotto prodotto = prodottoService.getProdottoByCodice(codice);
        model.addAttribute("prodotto", prodotto);
        return "formProdotto";
    }
}
