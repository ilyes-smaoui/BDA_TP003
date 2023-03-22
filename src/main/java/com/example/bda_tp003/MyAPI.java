package com.example.bda_tp003;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MyAPI {

    public static ArrayList<Etudiant> liste = new ArrayList<>();

    static {
        liste.add(new Etudiant(0, "Et1", 19));
        liste.add(new Etudiant(1, "Et2", 19));
        liste.add(new Etudiant(2, "Et3", 19));
        liste.add(new Etudiant(3, "Et4", 19));
    }

    @GetMapping(value = "/liste")
    public ArrayList<Etudiant> getAllEtudiants() {
        return  liste;
    }

    @GetMapping(value = "/getEtudiant")
    public Etudiant getEtudiant(int identifiant) {
        return liste.get(identifiant);
    }

    @PostMapping(value = "/addEtudiant")
    public Etudiant addEtudiant(Etudiant etudiant) {
        liste.add(etudiant);
        return etudiant;
    }

    @DeleteMapping(value = "/deleteEtudiant")
    public void supprimerEtudiant (int identifiant) {
        liste.remove(identifiant);
    }

    @PutMapping(value = "/modifierEtudiant")
    public void modifierEtudiant(int identifiant, String nom) {
        liste.get(identifiant).setNom(nom);
    }

    // Get permet de renvoyer une ressource
    // POST permet créer une nouvelle ressource
    // PUT permet de modifier une ressource
    // DELETE permet de supprimer une ressource

    @GetMapping(value = "/bj")
    public String bonjour() {
        return "Bonjour !";
    }

    @GetMapping(value = "/bs")
    public String bonsoir() {
        return "Bonsoir";
    }

    @GetMapping(value = "/newEtudiant")
    public Etudiant newEtudiant() {
        return new Etudiant(1, "A", 19);
    }

    @GetMapping(value = "/somme")
    public double somme (double a, double b) {
        return a + b;
    }
}
