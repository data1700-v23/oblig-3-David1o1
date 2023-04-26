package com.example.oblig3_f;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    BillettRepository billettRepository;

    @PostMapping("/lagre") //Sender billett til serveren og lagrer den der
    public void lagreBillett(Billett her){
        billettRepository.save(her);
    }

    @GetMapping("/send") // Henter billett fra klientside - og returnerer fra arrayet til tabellen
    public List<Billett>utBillett(){
        List<Billett> billettList = billettRepository.findByOrderByEtterNavnAsc(); //Sortere etter etternavn i stigende rekkerfølge
        return billettList;
    }

    @PostMapping("/slett") //Sender beskjed til server om å slette array
    public void slett(){
        billettRepository.deleteAll();
    }

}
