package com.example.oblig3_f;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billett")
public class Billett {
    @Id
    @GeneratedValue
    private int id;
    private String film, antall, navn, etterNavn, telefon, epost;

    public Billett(int id,String film, String antall, String navn, String etterNavn, String telefon, String epost){
        this.id = id;
        this.film = film;
        this.antall = antall;
        this.navn = navn;
        this.etterNavn = etterNavn;
        this.telefon = telefon;
        this.epost = epost;
    }

    public Billett() {

    }

    public String getFilm(){
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getAntall() {
        return antall;
    }

    public void setAntall(String antall) {
        this.antall = antall;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEtterNavn() {
        return etterNavn;
    }

    public void setEtterNavn(String etterNavn) {
        this.etterNavn = etterNavn;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    @Override
    public String toString() {
        return "Billett{" +
                "id=" + id +
                "film='" + film + '\'' +
                ", antall='" + antall + '\'' +
                ", navn='" + navn + '\'' +
                ", etterNavn='" + etterNavn + '\'' +
                ", telefon='" + telefon + '\'' +
                ", epost='" + epost + '\'' +
                '}';
    }
}
