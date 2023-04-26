package com.example.oblig3_f;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillettRepository extends JpaRepository<Billett,Long> {
    public List<Billett> findByOrderByEtterNavnAsc(); //Lager en kalling for å sortere liste med etternavn i stigende rekkefølge
}
