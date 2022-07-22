package com.example.esameengim.controller;

import com.example.esameengim.model.Articolo;
import com.example.esameengim.model.Ordine;
import com.example.esameengim.model.TariffaCorriere;
import com.example.esameengim.model.Voce;
import com.example.esameengim.model.repository.ArticoloRepository;
import com.example.esameengim.model.repository.OrdineRepository;
import com.example.esameengim.model.repository.TariffaCorriereRepository;
import com.example.esameengim.model.repository.VoceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/esame")
public class Controller {

    @GetMapping("/articoli")
    public List<Articolo> getArticoli(){
        return ArticoloRepository.getArticoli();
    }

    @GetMapping("/ordini")
    public List<Ordine> getOrdini() { return OrdineRepository.getOrdini(); }

    @GetMapping("/tariffe")
    public List<TariffaCorriere> getTariffe() { return TariffaCorriereRepository.getTariffeCorrieri(); }

    @GetMapping("/voci")
    public List<Voce> getVoci() { return VoceRepository.getVoci(); }

    @DeleteMapping("/tariffe/delete")
    public void deleteTariffa(int id){ TariffaCorriereRepository.deleteTariffa(id); }

    @PostMapping("/tariffe/add")
    public TariffaCorriere addTariffa(@RequestBody TariffaCorriere tariffa){ return TariffaCorriereRepository.addTariffa(tariffa); }

}
