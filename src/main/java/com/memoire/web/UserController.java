package com.memoire.web;

import com.memoire.dao.*;
import com.memoire.entity.*;
import com.memoire.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AccountService accountService;
    @Autowired
    ParamatrageAnneeRepository paramatrageAnneeRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    FilliereRepository filliereRepository;
    @Autowired
    NiveouRepository niveouRepository;

    @PostMapping("/register")
    public User register(@RequestBody UserForme userForme) {
        return accountService.saveUser(userForme.getUsername(), userForme.getPassword(), userForme.getConfirmedPassword());

    }

    @PostMapping("/PlaningFilliers")
    public void PlaningFilliers(@RequestBody UserForme userForme) {
        accountService.PlaningFilliers(userForme.getNomfilliere(), userForme.getAnneeEncours(), userForme.getDebutperiodeProposesujet(), userForme.getFinperiodeProposesujet());

    }

//    @PostMapping("/soutenaceFilliers")
//    public void SoutenaceFilliers(@RequestBody UserForme userForme) {
//        accountService.SoutenaceFilliers(userForme.getNomfilliere(), userForme.getDateSoutence(), userForme.getFindateSoutence());
//
//    }

    @GetMapping("/ActualUser/{username}")
    public User actualUser(@PathVariable String username) {
        return accountService.loadUsername(username);

    }

    @GetMapping("/getAnneeEncours/")
    public ParamatrageAnnee getAnneeEncours(@PathVariable String anneeEncours) {
        return paramatrageAnneeRepository.findByAnneeEncours(anneeEncours);

    }

    @PostMapping("/saveRole")
    public Role SaveRole(@RequestBody UserForme userForme) {
        return accountService.save(userForme.getRole());
    }

//    @PostMapping("/savePlanigsoutenace")
//    public void SavePlanigsoutenace(@RequestBody UserForme userForme) {
//        accountService.SavePlanigsoutenace(userForme.getDateSoutence(), userForme.getFindateSoutence());
//    }

    @GetMapping("/addRoleToUser/{username}/{roleName}")
    public void addRoleToUser(@PathVariable("username") String username, @PathVariable("roleName") String roleName) {
        accountService.addRoleToUser(username, roleName);
    }

    @GetMapping("/addEtudiantToGroup/{nomGrp}/{matriculeetudiant}")
    public void addEtudiantToGroup(@PathVariable("matriculeetudiant") String matriculeetudiant, @PathVariable("nomGrp") String nomGrp) {
        accountService.addEtudiantToGroup(matriculeetudiant, nomGrp);
    }

    @GetMapping("/addEtudiantToCompte/{nom}/{username}")
    public void addEtudiantToCompte(@PathVariable("nom") String nom, @PathVariable("username") String username) {
        accountService.addEtudiantToCompte(nom, username);
    }

    @GetMapping("/addEnsegniantToCompte/{nomEnseigniant}/{username}")
    public void addEnsegniantToCompte(@PathVariable("nomEnseigniant") String nomEnseigniant, @PathVariable("username") String username) {
        accountService.addEnsegniantToCompte(nomEnseigniant, username);
    }

    @GetMapping("/getGroupeFilliere/{id}")
    public List<Groupe> getWilayaMoughataas(@PathVariable Long id) {
        return

                groupRepository.findByFilliere(id);
    }

    @GetMapping("/getDepertementFilliers/{id}")
    public List<Filliere> getDepertementFilliers(@PathVariable Long id) {
        return

                filliereRepository.findByDepartement(id);
    }

    @GetMapping("/getFillierNiveou/{id}")
    public List<Niveau> getFillierNiveou(@PathVariable Long id) {
        return
                niveouRepository.findByFilliere(id);
    }

    @GetMapping("/getNiveouGroupe/{id}")
    public List<Groupe> getNiveouGroupe(@PathVariable Long id) {
        return
                groupRepository.findByNiveau(id);
    }
//    @GetMapping("/getGroupeFilliere/{nomfilliere}")
//    public void getGroupeFilliere(@PathVariable ("nomfilliere")String nomfilliere)
//    {
//        accountService.getGroupeFilliere(nomfilliere);
//    }


    @GetMapping("/supprimerFilliere/{id}")
    public void supprimerFilliere(@PathVariable("id") Long id) {
        accountService.supprimerFilliere(id);
    }

    @GetMapping("/effectFilterToSujet/{nomfilliere}/{nomEnseigniant}")
    public void EffectFilterToSujet(@PathVariable("nomfilliere") String nomfilliere, @PathVariable("nomEnseigniant") String nomEnseigniant) {
        accountService.EffectFilterToSujet(nomfilliere, nomEnseigniant);
    }

    @GetMapping("/effectdepertementToEnsegniat/{nomDepartement}/{nomEnseigniant}")
    public void EffectdepertementToEnsegniat(@PathVariable("nomDepartement") String nomDepartement, @PathVariable("nomEnseigniant") String nomEnseigniant) {
        accountService.EffectdepertementToEnsegniat(nomDepartement, nomEnseigniant);
    }

    @GetMapping("/EffectPeriodeProposeToSujet/{periodeProposesujet}/{titreSujet}")
    public void EffectPeriodeProposeToSujet(@PathVariable("periodeProposesujet") Date periodeProposesujet, @PathVariable("titreSujet") String titreSujet) {
        accountService.EffectPeriodeProposeToSujet(periodeProposesujet, titreSujet);
    }

    @PostMapping("/saveEtudint")
    public Etudiant saveEtudint(@RequestBody UserForme userForme) {
        return accountService.saveEtudint(userForme.getMatriculeetudiant(), userForme.getNom(), userForme.getPrenom(), userForme.getNomGrp(), userForme.getNomfilliere(), userForme.getNomNiveou());

    }

    @PostMapping("/saveNiveou")
    public Niveau saveNiveou(@RequestBody UserForme userForme) {
        return accountService.saveNiveou(userForme.getNomNiveou(), userForme.getCode(), userForme.getAnnee(), userForme.getNomfilliere());

    }

    @PostMapping("/saveParamatrageAnnee")
    public ParamatrageAnnee SaveParamatrageAnnee(@RequestBody UserForme userForme) {
        return accountService.SaveParamatrageAnnee(userForme.getAnneeEncours());

    }

    @PostMapping("/savePeriodePropose")
    public ParamatragePeriodePropose SavePeriodePropose(@RequestBody UserForme userForme) {
        return accountService.SavePeriodePropose(userForme.getDebutperiodeProposesujet(), userForme.getFinperiodeProposesujet());

    }

    @GetMapping("/user/{username}")
    public User getUserByUserName(@PathVariable String username) {

        return accountService.loadUsername(username);
    }

    @PostMapping("/saveGroup")
    public Groupe saveGroup(@RequestBody UserForme userForme) {
        return accountService.saveGroup(userForme.getNomGrp(), userForme.getNomfilliere(), userForme.getNomNiveou());

    }

    @PostMapping("/saveEnsigniant")
    public Ensigniant saveEnsigniant(@RequestBody UserForme userForme) {
        return accountService.saveEnsigniant(userForme.getTelEnsegniant(), userForme.getNomEnseigniant(), userForme.getPrenom(), userForme.getNomDepartement());

    }

    @PostMapping("/saveEntreprice")
    public Entreprise SaveEntreprice(@RequestBody UserForme userForme) {
        return accountService.SaveEntreprice(userForme.getNomEntreprice(), userForme.getAdresse());

    }

    @PostMapping("/saveFillier")
    public Filliere SaveFillier(@RequestBody UserForme userForme) {
        return accountService.SaveFillier(userForme.getNomfilliere(), userForme.getCodefilliere(), userForme.getNomDepartement());
    }

    @PostMapping("/saveDepertement")
    public Departement SaveDepertement(@RequestBody UserForme userForme) {
        return accountService.SaveDepertement(userForme.getNomDepartement(), userForme.getCodeDepartement());


    }

    @GetMapping("/listNiveaus")
    public Page<Niveau> afficherAllNiveau(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "1") int size) {
        return accountService.afficherAllNiveau(page, size);
    }

    @GetMapping(value = "/chercherNiveaus")
    public Page<Niveau> chercherNiveaus(
            @RequestParam(name = "nomNiveou", defaultValue = "") String nom,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return accountService.chercherNiveau(nom, page, size);
    }
}

@Data
class UserForme {
    private Date findateSoutence;
    private Date debutperiodeProposesujet;
    private Date finperiodeProposesujet;
    private Date dateSoutence;
    private String annee;
    private String nomNiveou;
    private String code;
    private String Codefilliere;
    private String codeDepartement;
    private String nomfilliere;
    private String nomEnseigniant;
    private Date periodeProposesujet;
    private String anneeEncours;
    private String nomDepartement;

    private String nomEntreprice;
    private String adresse;
    private String nomGrp;
    private String specialiter;

    private Long telEnsegniant;
    private String username;
    private String password;
    private String confirmedPassword;
    private String matriculeetudiant;
    private String nom;
    private String prenom;
    private Role role;
    private String rolename;

    public Date getFindateSoutence() {
        return findateSoutence;
    }

    public void setFindateSoutence(Date findateSoutence) {
        this.findateSoutence = findateSoutence;
    }

    public Date getDebutperiodeProposesujet() {
        return debutperiodeProposesujet;
    }

    public void setDebutperiodeProposesujet(Date debutperiodeProposesujet) {
        this.debutperiodeProposesujet = debutperiodeProposesujet;
    }

    public Date getFinperiodeProposesujet() {
        return finperiodeProposesujet;
    }

    public void setFinperiodeProposesujet(Date finperiodeProposesujet) {
        this.finperiodeProposesujet = finperiodeProposesujet;
    }

    public Date getDateSoutence() {
        return dateSoutence;
    }

    public void setDateSoutence(Date dateSoutence) {
        this.dateSoutence = dateSoutence;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getNomNiveou() {
        return nomNiveou;
    }

    public void setNomNiveou(String nomNiveou) {
        this.nomNiveou = nomNiveou;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodefilliere() {
        return Codefilliere;
    }

    public void setCodefilliere(String codefilliere) {
        Codefilliere = codefilliere;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getNomfilliere() {
        return nomfilliere;
    }

    public void setNomfilliere(String nomfilliere) {
        this.nomfilliere = nomfilliere;
    }

    public String getNomEnseigniant() {
        return nomEnseigniant;
    }

    public void setNomEnseigniant(String nomEnseigniant) {
        this.nomEnseigniant = nomEnseigniant;
    }

    public Date getPeriodeProposesujet() {
        return periodeProposesujet;
    }

    public void setPeriodeProposesujet(Date periodeProposesujet) {
        this.periodeProposesujet = periodeProposesujet;
    }

    public String getAnneeEncours() {
        return anneeEncours;
    }

    public void setAnneeEncours(String anneeEncours) {
        this.anneeEncours = anneeEncours;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getNomEntreprice() {
        return nomEntreprice;
    }

    public void setNomEntreprice(String nomEntreprice) {
        this.nomEntreprice = nomEntreprice;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomGrp() {
        return nomGrp;
    }

    public void setNomGrp(String nomGrp) {
        this.nomGrp = nomGrp;
    }

    public String getSpecialiter() {
        return specialiter;
    }

    public void setSpecialiter(String specialiter) {
        this.specialiter = specialiter;
    }

    public Long getTelEnsegniant() {
        return telEnsegniant;
    }

    public void setTelEnsegniant(Long telEnsegniant) {
        this.telEnsegniant = telEnsegniant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getMatriculeetudiant() {
        return matriculeetudiant;
    }

    public void setMatriculeetudiant(String matriculeetudiant) {
        this.matriculeetudiant = matriculeetudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}