package com.memoire.web;

import com.memoire.dao.*;
import com.memoire.entity.*;
import com.memoire.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;


@RestController
public class EnsegniatController {
    @Autowired
    private AccountService accountService;
    @Autowired
    SujetRepository sujetRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    DemandRepository demandRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private EnsigniantRepository ensigniantRepository;

    @PostMapping("/ProposeSujetParEnseigniat")
    public Sujet ProposeSujetParGrp(@RequestBody EnseigniantForme enseigniantForme) {

        return accountService.ProposeSujetParEnseigniat(enseigniantForme.getTitreSujet(), enseigniantForme.getNomEnseigniant(), enseigniantForme.getNomEnseigniant());

    }
    @GetMapping("/ensigniantslist")
    public List<Ensigniant> getEnseingant() {
        return ensigniantRepository.findAll();
    }

    @GetMapping("/EnseignantListeSujetPropose")
    public List<Sujet> ListeSujet() {
        List<Sujet> sujetList = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println("USERNAME: " + name);
        User user = userRepository.findByUsername(name);
        Collection<Ensigniant> ensigniants = user.getEnsigniants();
        if (ensigniants != null) {
            ensigniants.forEach(ensigniant -> {
                List<Sujet> list = sujetRepository.findSujetsByEnsigniant(ensigniant);
                list.forEach(sujet -> {
                    sujetList.add(sujet);
                });
            });
        }

        return sujetList;
    }
//    @GetMapping("/nomEnseginat")
//    public String getNomEnsgniet(String nomEnseigniant) {
//        return ensigniantRepository.findByNomEnseigniant(nomEnseigniant);
//    }


//    public Sujet ValiderSujet(@PathVariable String titreSujet, String nomEnseigniant) {
//        return accountService.validerSujet(titreSujet);
//    }

    @GetMapping("/DemandeEncadrantSujet/{titreSujet}/{nomEnseigniant}")
    public Sujet DemandeEncadrantSujet(@PathVariable("titreSujet") String titreSujet, @PathVariable("nomEnseigniant") String nomEnseigniant) {
        return accountService.DemandeEncadrantSujet(titreSujet, nomEnseigniant);
    }

    @GetMapping("/ValiderDemendeEncadrant/{titreSujet}")
    public Sujet ValiderDemendeEncadrant(@PathVariable("titreSujet") String titreSujet) {
        return accountService.ValiderDemendeEncadrant(titreSujet);
    }

    @GetMapping("/RefuserDemendeEncadrant/{titreSujet}")
    public Sujet RefuserDemendeEncadrant(@PathVariable String titreSujet) {
        return accountService.RefuserDemendeEncadrant(titreSujet);
    }

    //    @PostMapping("/DemandeEncadrantSujet")
//    public Sujet DemandeEncadrantSujet(@PathVariable String titreSujet ,
//                                       @RequestBody EnseigniantForme enseigniantForme) {
//        return accountService.DemandeEncadrantSujet(titreSujet,enseigniantForme.getNomEnseigniant());
//}
    @GetMapping("/savedemande/{idSujet}/{idGroupe}")
    public String SaveDemande(@PathVariable long idSujet, @PathVariable Long idGroupe) {
        Optional<Sujet> optionalSujet = sujetRepository.findById(idSujet);
        Optional<Groupe> optionalGroupe = groupRepository.findById(idGroupe);
        if (optionalSujet.isPresent() && optionalGroupe.isPresent()) {
            Demande demande1 = demandRepository.findDemandeByGroupe(optionalGroupe.get());
            if (demande1 != null) {
                Demande demande = new Demande();
                demande.setSujet(optionalSujet.get());
                demande.setGroupe(optionalGroupe.get());
                demande.setEtat(0);
                demande.setNote("");
                demandRepository.save(demande);
                return "Demande est enregistrer";
            } else {
                return "vous avez deja demande un sujet.";
            }

        }
        return "ERREUR IL YA UN PROBLEME";
    }

    @GetMapping("/demandexist/{idGroupe}")
    public boolean DemandExist(@PathVariable Long idGroupe) {
        AtomicBoolean b = new AtomicBoolean(false);
        Optional<Groupe> optionalGroupe = groupRepository.findById(idGroupe);
        if (optionalGroupe.isPresent()) {
            Demande demande = demandRepository.findDemandeByGroupe(optionalGroupe.get());
            if (demande != null )
                b.set(true);
            List<Sujet> sujetList = sujetRepository.findSujetsByGroupe(optionalGroupe.get());
            sujetList.forEach(sujet -> {
                if (sujet.getValider())
                    b.set(true);
            });

        }
        return b.get();
    }

    @GetMapping("/getDemands")
    public List<Demande> getDemandes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println("USERNAME: " + name);
        User user = userRepository.findByUsername(name);
        Optional<Ensigniant> optionalEnsigniant = user.getEnsigniants().stream().findFirst();
        if (optionalEnsigniant.isPresent()) {
            return demandRepository.findDemandesBySujet_Ensigniant_Id(optionalEnsigniant.get().getId());
        }
        return new ArrayList<>();
    }
    @GetMapping("/getDemand")
    public Demande getDemandGroup() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println("USERNAME: " + name);
        User user = userRepository.findByUsername(name);
        Optional<Etudiant> optionalEtudiant = user.getEtudiants().stream().findFirst();
        if (optionalEtudiant.isPresent()) {
            return demandRepository.findDemandeByGroupe(optionalEtudiant.get().getGroupe());
        }
        return null;
    }

    @GetMapping("/acceptDemand/{id}")
    public boolean acceptDemand(@PathVariable long id) {
        Optional<Demande> demandeOptional = demandRepository.findById(id);
        if (demandeOptional.isPresent()) {
            demandeOptional.get().setEtat(1);
            demandRepository.save(demandeOptional.get());
            return true;
        }
        return false;
    }

    @GetMapping("/refuseDemand/{id}/{note}")
    public boolean refuseDemand(@PathVariable long id,@PathVariable String note) {
        Optional<Demande> demandeOptional = demandRepository.findById(id);
        if (demandeOptional.isPresent()) {
            demandeOptional.get().setEtat(2);
            demandeOptional.get().setNote(note);
            demandRepository.save(demandeOptional.get());
            return true;
        }
        return false;
    }


}


@Data
class EnseigniantForme {
    private String titreSujet;
    private String nomEntreprice;
    private String nomEnseigniant;

    public EnseigniantForme() {
    }

    public String getTitreSujet() {
        return titreSujet;
    }

    public void setTitreSujet(String titreSujet) {
        this.titreSujet = titreSujet;
    }

    public String getNomEntreprice() {
        return nomEntreprice;
    }

    public void setNomEntreprice(String nomEntreprice) {
        this.nomEntreprice = nomEntreprice;
    }

    public String getNomEnseigniant() {
        return nomEnseigniant;
    }

    public void setNomEnseigniant(String nomEnseigniant) {
        this.nomEnseigniant = nomEnseigniant;
    }
}