package com.memoire.web;

import com.memoire.dao.*;
import com.memoire.entity.*;
import com.memoire.payloads.Planning;
import com.memoire.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class CordinateurController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private PlanningSoutenanceRepository planningSoutenanceRepository;
    @Autowired
    private JuryRepository juryRepository;
    @Autowired
    private EnsigniantRepository ensigniantRepository;
    @Autowired
    private FilliereRepository filliereRepository;

    @Autowired
    private SujetRepository sujetRepository;


    @GetMapping("/sujetValider/{titreSujet}")
    public Sujet ValiderSujet(@PathVariable String titreSujet) {
        return accountService.validerSujet(titreSujet);
    }

    @GetMapping("/RefuserSujet/{titreSujet}")
    public Sujet RefuserSujet(@PathVariable String titreSujet) {
        return accountService.RefuserSujet(titreSujet);
//    Sujet sujetValider = new Sujet() ;
//    for (Sujet sujet1 :
//            accountService.getSujets()) {
//
//        if (sujet1.getValider()==false)
//               sujet1.setValider(true);
//               sujet1.getCordinateur();
//        sujetValider =sujet1;
//
//
//
//    return sujetValider;

    }

    @GetMapping("/planning/{date}/{idJury}/{heuredebut}")
    public Planning plannin(@PathVariable Date date, @PathVariable long idJury, @PathVariable Time heuredebut) {
        List<PlanningSoutenance> list = planningSoutenanceRepository.findByDateSoutence(date);
        if (list == null) return new Planning(true, "Disponible");
        else {
            for (PlanningSoutenance planningSoutenance : list) {
                if (!planningSoutenance.isSoutene() &&
                        planningSoutenance.getJury_planning().getIdJury() == idJury &&
                        heuredebut.after(planningSoutenance.getHeure_debut()) &&
                        heuredebut.before(planningSoutenance.getHeure_fin()))
                    return new Planning(false, "Jury n'est pas disponible");
            }
        }
        return new Planning(true, "Disponible");
    }

    @PostMapping(value = "/addplanningsoutenance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean addPlanningSoutenace(@RequestBody PlanningSoutenance planningSoutenance) {

        PlanningSoutenance planningSoutenance1 = planningSoutenanceRepository.save(planningSoutenance);
        if (planningSoutenance1 != null) {
            return true;
        }
        return false;
    }

    @GetMapping("/getsoutenances")
    public List<PlanningSoutenance> getSoutenaces() {
        return planningSoutenanceRepository.findAll();
    }

    @GetMapping("/updatesoutenance/{id}/{mention}/{note}")
    public boolean getSoutenaces(@PathVariable long id, @PathVariable String mention, @PathVariable int note) {
        Optional<PlanningSoutenance> planningSoutenance = planningSoutenanceRepository.findById(id);
        if (planningSoutenance.isPresent()) {
            planningSoutenance.get().setMention(mention);
            planningSoutenance.get().setNote(note);
            planningSoutenance.get().setSoutene(true);
            planningSoutenanceRepository.save(planningSoutenance.get());
            return true;
        }
        return false;
    }

    @PostMapping("/addjury")
    public boolean addJury(@RequestBody List<Long> list) {
        if (list != null && list.size() > 0) {
            Jury jury = new Jury();
            list.forEach(aLong -> {
                Optional<Ensigniant> optionalEnsigniant = ensigniantRepository.findById(aLong);
                if (optionalEnsigniant.isPresent()) {
                    jury.setEnsigniant(optionalEnsigniant.get());
                }
            });
            juryRepository.save(jury);
            return true;
        }
        return false;
    }

    @GetMapping("/getjurys")
    public List<Jury> getJurys() {
        return juryRepository.findAll();
    }

    @GetMapping("/getfilliers")
    public List<Filliere> getFilliers() {
        return filliereRepository.findAll();
    }

    @GetMapping("/groupefillier/{id}")
    public Collection<Groupe> getGroupsFillier(@PathVariable long id) {
        return filliereRepository.getOne(id).getGroupes();
    }

    @GetMapping("/sujetsfillier/{id}")
    public List<Sujet> getSujetsFillier(@PathVariable long id) {
        return sujetRepository.findSujetsByFillieres(filliereRepository.getOne(id));


    }
}