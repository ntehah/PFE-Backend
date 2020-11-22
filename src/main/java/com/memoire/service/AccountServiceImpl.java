package com.memoire.service;

import com.memoire.dao.*;
import com.memoire.entity.*;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    ParamatrageAnneeRepository paramatrageAnneeRepository;
    @Autowired
    ParamatragePeriodeProposeRepository paramatragePeriodeProposeRepository;
    @Autowired


    private SujetRepository sujetRepository;
    @Autowired
    Encad_acadimiqueRepository encad_acadimiqueRepository;
    @Autowired
    JuryRepository juryRepository;
    @Autowired

    EntrepriseRepository entrepriseRepository;
    private UserRepository userRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private  CordinateurRepository cordinateurRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private EnsigniantRepository ensigniantRepository;
    @Autowired
    private  FilliereRepository filliereRepository;
    @Autowired
    private NiveouRepository niveouRepository;
    @Autowired
    //private CordinateurRepository cordinateurRepository;
    private RoleRepository roleRepoitory;
    @Autowired
    DepartementRepository departementRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
private PlanningSoutenanceRepository planningSoutenanceRepository;

    public AccountServiceImpl(UserRepository userRepository, RoleRepository roleRepoitory, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepoitory = roleRepoitory;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public User saveUser(String username, String password, String confirmedPassword) {
        User user1 = userRepository.findByUsername(username);
//        if (user1 != null) throw new RuntimeException("Use already exists");
        if (!password.equals(confirmedPassword)) throw new RuntimeException("please confirme your password");
        User user = new User();
        user.setUsername(username);
        user.setActived(true);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
        addRoleToUser(username,"USER");
        return user;
    }
    public Role save (Role role){

        return roleRepoitory.save(role);
    }

    public User loadUsername (String username){

        return userRepository.findByUsername(username);
    }

    public void addRoleToUser (String username, String rolename){
        User user = userRepository.findByUsername(username);
        Role role = roleRepoitory.findByRoleName(rolename);
        user.getRoles().add(role);

    }

    @Override
    public Niveau saveNiveou(String nomNiveou, String code, String annee,String nomfilliere) {
        Niveau niveau1 = niveouRepository.findByNomNiveou(nomNiveou);

//        if (niveau1 != null) throw new RuntimeException("niveou already exists");
        Niveau niveau = new Niveau();
//        if (user1 != null) throw new RuntimeException("Use already exists");
//        if (!password.equals(confirmedPassword)) throw new RuntimeException("please confirme your password");

        niveau.setNomNiveou(nomNiveou);
        niveau.setCode(code);
        niveau.setAnnee(annee);
         niveau.setFilliere(filliereRepository.findByNomfilliere(nomfilliere));
         niveouRepository.save(niveau);
        return niveau;
    }


    @Override
    public Etudiant saveEtudint(String matriculeetudiant, String nom, String prenom,String nomfilliere,String nomNiveou, String nomGrp) {
        Etudiant etudiant1 = etudiantRepository.findByNom(nom);
        if (etudiant1 != null) throw new RuntimeException("etudiant already exists");
        Etudiant etudiant = new Etudiant();
        etudiant.setMatriculeetudiant(matriculeetudiant);
        etudiant.setNom(nom);

        etudiant.setFilliere(filliereRepository.findByNomfilliere(nomfilliere));
        etudiant.setNiveau(niveouRepository.findByNomNiveou(nomNiveou));
        etudiant.setGroupe(groupRepository.findByNomGrp(nomGrp));
        etudiant.setPrenom(prenom);

        etudiantRepository.save(etudiant);

        return etudiant;
    }

    @Override
    public void addEtudiantToCompte(String nom,String username) {
        User user = userRepository.findByUsername(username);
        Etudiant etudiant = etudiantRepository.findByNom(nom);
//        etudiant.setUser(userRepository.findByUsername(username));
        etudiant.setNom(nom);
        user.getEtudiants().add(etudiant);

    }

    @Override
    public void addEnsegniantToCompte(String nomEnseigniant, String username) {
        User user = userRepository.findByUsername(username);
        Ensigniant ensigniant = ensigniantRepository.findByNomEnseigniant(nomEnseigniant);
//        ensigniant.setUser(userRepository.findByUsername(username));
        ensigniant.setNomEnseigniant(nomEnseigniant);
        user.getEnsigniants().add(ensigniant);
    }

    @Override
    public void EffectAnneeToSujet(String anneeEncours, String titreSujet) {
        ParamatrageAnnee paramatrageAnnee = paramatrageAnneeRepository.findByAnneeEncours(anneeEncours);
        Sujet sujet = sujetRepository.findBytitreSujet(titreSujet);
        sujet.setParamatrageAnnee(paramatrageAnneeRepository.findByAnneeEncours(anneeEncours));
        sujet.setTitreSujet(titreSujet);
        paramatrageAnnee.getSujets().add(sujet);
    }

    @Override
    public void EffectPeriodeProposeToSujet(Date periodeProposesujet, String titreSujet) {
        ParamatragePeriodePropose paramatragePeriodePropose = paramatragePeriodeProposeRepository.findByDebutperiodeProposesujet(periodeProposesujet);
        Sujet sujet = sujetRepository.findBytitreSujet(titreSujet);
        sujet.setParamatragePeriodePropose(paramatragePeriodeProposeRepository.findByDebutperiodeProposesujet(periodeProposesujet));
        sujet.setTitreSujet(titreSujet);
        paramatragePeriodePropose.getSujets().add(sujet);
    }

    @Override
    public Jury saveJury(String idJury) {
        Jury jury1 = juryRepository.findByIdJury(idJury);
        if (jury1 != null) throw new RuntimeException("jury already exists");
        Jury jury = new Jury();

//        jury.setIdJury(idJury);


        juryRepository.save(jury);
        return jury;
    }

    @Override
    public Entreprise SaveEntreprice(String nomEntreprice, String adresse) {
        Entreprise entreprise1 = entrepriseRepository.findByNomEntreprice(nomEntreprice);
//       if (entreprise1 != null) throw new RuntimeException("entreprice already exists");
        Entreprise entreprise = new Entreprise();
        entreprise.setNomEntreprice(nomEntreprice);
        entreprise.setAdresse(adresse);
        entrepriseRepository.save(entreprise);
        return entreprise;}

    @Override
    public ParamatrageAnnee SaveParamatrageAnnee(String anneeEncours) {
        ParamatrageAnnee paramatrageAnnee1 = paramatrageAnneeRepository.findByAnneeEncours(anneeEncours);
        if (paramatrageAnnee1 != null) throw new RuntimeException("anee already exists");
        ParamatrageAnnee paramatrageAnnee = new ParamatrageAnnee();

        paramatrageAnnee.setAnneeEncours(anneeEncours);
        paramatrageAnneeRepository.save(paramatrageAnnee);
        return paramatrageAnnee;
    }

    @Override
    public ParamatragePeriodePropose SavePeriodePropose(Date debutperiodeProposesujet,Date finperiodeProposesujet) {
        ParamatragePeriodePropose paramatragePeriodePropose1 = paramatragePeriodeProposeRepository.findByDebutperiodeProposesujet(debutperiodeProposesujet);
        if (paramatragePeriodePropose1 != null) throw new RuntimeException("ParamatragePeriodePropose already exists");
        ParamatragePeriodePropose paramatragePeriodePropose = new ParamatragePeriodePropose();
paramatragePeriodePropose.setFinperiodeProposesujet(finperiodeProposesujet);
        paramatragePeriodePropose.setDebutperiodeProposesujet(debutperiodeProposesujet);
        paramatragePeriodeProposeRepository.save(paramatragePeriodePropose);
        return paramatragePeriodePropose;
    }

//    @Override
//    public PlanningSoutenance SavePlanigsoutenace(Date dateSoutence , Date findateSoutence) {
//        PlanningSoutenance planningSoutenance1 = planningSoutenanceRepository.findByFindateSoutence(findateSoutence);
//        if (planningSoutenance1 != null) throw new RuntimeException("planningSoutenance1 already exists");
//        PlanningSoutenance planningSoutenance = new PlanningSoutenance();
//        planningSoutenance.setDateSoutence(dateSoutence);
//        planningSoutenance.setFindateSoutence(findateSoutence);
//        planningSoutenanceRepository.save(planningSoutenance);
//        return  planningSoutenance;
//    }
//
//    @Override
//    public void SoutenaceFilliers(String nomfilliere, Date dateSoutencePrevu, Date findateSoutence) {
//        PlanningSoutenance planningSoutenance = planningSoutenanceRepository.findByDateSoutencePrevu(dateSoutencePrevu);
//
//        Filliere filliere = filliereRepository.findByNomfilliere(nomfilliere);
//        filliere.setPlanningSoutenance(planningSoutenanceRepository.findByDateSoutencePrevu(dateSoutencePrevu));
//        filliere.setPlanningSoutenance(planningSoutenanceRepository.findByFindateSoutence(findateSoutence));
//
////        planningSoutenance.getFilliere().add(filliere);
//    }

//    @Override
//    public PlanningSoutenance SavePlanigsoutenace(Date dateSoutence , Date findateSoutence) {
//        PlanningSoutenance planningSoutenance1 = planningSoutenanceRepository.findByDateSoutence(dateSoutence);
//        if (planningSoutenance1 != null) throw new RuntimeException("planningSoutenance1 already exists");
//        PlanningSoutenance planningSoutenance = new PlanningSoutenance();
//        planningSoutenance.setDateSoutence(dateSoutence);
//        planningSoutenanceRepository.save(planningSoutenance);
//        return  planningSoutenance;
//    }


    public Groupe saveGroup(String nomGrp,String nomfilliere,String nomNiveou ){
        Groupe groupe1 = groupRepository.findByNomGrp(nomGrp);
//        if (groupe1 != null) throw new RuntimeException("group already exists");
        Groupe groupe = new Groupe();
        groupe.setFilliere(filliereRepository.findByNomfilliere(nomfilliere));
        groupe.setNiveau(niveouRepository.findByNomNiveou(nomNiveou));
        groupe.setNomGrp(nomGrp);
        groupRepository.save(groupe);
        return groupe;

    }

    @Override
    public void addEtudiantToGroup(String nomGrp,String matriculeetudiant) {
        Etudiant etudiant=etudiantRepository.findByMatriculeetudiant(matriculeetudiant);
        Groupe groupe=groupRepository.findByNomGrp(nomGrp);
        groupe.getEtudiants().add(etudiant);

    }

    @Override
    public void addEnsegnintToJury(String idJury, String nomEnseigniant) {
        Ensigniant ensigniant=ensigniantRepository.findByNomEnseigniant(nomEnseigniant);
        Jury jury=juryRepository.findByIdJury(idJury);
        jury.getEnsigniants().add(ensigniant);

    }

    @Override
    public Sujet ProposeSujetParGrp(String titreSujet, String nomEntreprice, String nomGrp,String description) {
        Sujet sujet1 = sujetRepository.findBytitreSujet(titreSujet);
        if (sujet1 != null) throw new RuntimeException("sujet already exists");
        Sujet sujet = new Sujet();

        sujet.setTitreSujet(titreSujet);
        sujet.setEntreprise(entrepriseRepository.findByNomEntreprice(nomEntreprice));
        sujet.setGroupe(groupRepository.findByNomGrp(nomGrp));
        sujet.setValider(false);

        sujet.setDemendeEncadrant(false);
        sujet.setDescription(description);
        sujetRepository.save(sujet);
        return sujet;
    }
    public Sujet ProposeSujetParEnseigniat(String titreSujet, String nomEntreprice, String nomEnseigniant) {

        Sujet sujet1 = sujetRepository.findBytitreSujet(titreSujet);
        if (sujet1 != null) throw new RuntimeException("sujet already exists");
        Sujet sujet = new Sujet();
        sujet.setTitreSujet(titreSujet);
        sujet.setEntreprise(entrepriseRepository.findByNomEntreprice(nomEntreprice));
//       sujet.setEntreprice_acceuil(Entreprice_acceuil);
        sujet.setEnsigniant(ensigniantRepository.findByNomEnseigniant(nomEnseigniant));
        sujet.setValider(false);
        sujet.setDemendeEncadrant(false);
        sujetRepository.save(sujet);
        Sujet sujet2 = sujetRepository.findBytitreSujet(titreSujet);
        Ensigniant ensigniant = ensigniantRepository.findByNomEnseigniant(nomEnseigniant);
        ensigniant.getSujets_proposer().add(sujet2);
        return sujet;
    }

    @Override
    public Ensigniant saveEnsigniant(Long telEnsegniant, String nomEnseigniant, String prenom, String nomDepartement) {
        Ensigniant enseigniant1 = ensigniantRepository.findByNomEnseigniant(nomEnseigniant);
        if (enseigniant1 != null) throw new RuntimeException("enseigniant already exists");
        Ensigniant ensigniant = new Ensigniant();
        ensigniant.setTelEnsegniant(telEnsegniant);
        ensigniant.setNomEnseigniant(nomEnseigniant);
        ensigniant.setPrenom(prenom);
        ensigniant.setDepartement(departementRepository.findByNomDepartement(nomDepartement));
        ensigniantRepository.save(ensigniant);
        return ensigniant;
    }

    @Override
    public Filliere SaveFillier(String nomfilliere, String Codefilliere,String nomDepartement) {
        Filliere filliere1 = filliereRepository.findByNomfilliere(nomfilliere);
        if (filliere1 != null) throw new RuntimeException("filiere already exists");
        Filliere filliere = new Filliere();
        filliere.setCodefilliere(Codefilliere);
        filliere.setNomfilliere(nomfilliere);
        filliere.setDepartement(departementRepository.findByNomDepartement(nomDepartement));
        filliereRepository.save(filliere);
        return filliere;
    }



    @Override
    public Departement SaveDepertement(String nomDepartement,String codeDepartement){
        Departement departement1 = departementRepository.findByNomDepartement(nomDepartement);
        if (departement1 != null) throw new RuntimeException("departement already exists");
        Departement departement = new Departement();
        departement.setNomDepartement(nomDepartement);
        departement.setCodeDepartement(codeDepartement);

        departementRepository.save(departement);
        return departement;
    }
    @Override
    public void EffectFilterToSujet(String nomfilliere, String titreSujet) {

        Filliere filliere = filliereRepository.findByNomfilliere(nomfilliere);
        Sujet sujet = sujetRepository.findBytitreSujet(titreSujet);
        sujet.setFillieres(filliereRepository.findByNomfilliere(nomfilliere));
        sujet.setTitreSujet(titreSujet);
        filliere.getSujets().add(sujet);
    }

    @Override
    public void EffectdepertementToEnsegniat(String nomDepartement, String nomEnseigniant) {
        Departement departement = departementRepository.findByNomDepartement(nomDepartement);
        Ensigniant ensigniant = ensigniantRepository.findByNomEnseigniant(nomEnseigniant);
        ensigniant.setDepartement(departementRepository.findByNomDepartement(nomDepartement));
        ensigniant.setNomEnseigniant(nomEnseigniant);
        departement.getEnsigniantsapartient().add(ensigniant);
    }
    @Override
    public Cordinateur saveCordinateure(String nomEnseigniant) {
        Cordinateur cordinateur = cordinateurRepository.findByNomEnseigniant(nomEnseigniant);
        if (cordinateur != null) throw new RuntimeException("cordinateure already exists");


        cordinateur.setNomEnseigniant(nomEnseigniant);
        cordinateurRepository.save(cordinateur);
        return cordinateur;
    }

    @Override
    public void AddCordinateureToFilliere(String nomfilliere , String nomEnseigniant) {
        Filliere filliere = filliereRepository.findByNomfilliere(nomfilliere);
        Cordinateur cordinateur = cordinateurRepository.findByNomEnseigniant(nomEnseigniant);
        cordinateur.getFillier_cordone().add(filliere);
    }

    @Override
    public Sujet validerSujet(String titreSujet) {
       Sujet s =sujetRepository.findBytitreSujet(titreSujet);
       s.setValider(true);
       sujetRepository.save(s);
       return s;
    }

    @Override
    public Sujet RefuserSujet(String titreSujet) {
        Sujet s =sujetRepository.findBytitreSujet(titreSujet);
        s.setValider(false);
        sujetRepository.save(s);
        return s;
    }

    @Override
    public Sujet DemandeEncadrantSujet(String titreSujet, String nomEnseigniant) {
        Sujet s =sujetRepository.findBytitreSujet(titreSujet);
        s.setDemendeEncadrant(false);
        s.setEncad_acadimique(ensigniantRepository.findByNomEnseigniant(nomEnseigniant));
        sujetRepository.save(s);
        return s;
    }

    @Override
    public Sujet ValiderDemendeEncadrant(String titreSujet) {
        Sujet s =sujetRepository.findBytitreSujet(titreSujet);
        s.setDemendeEncadrant(true);
        return s;
    }

    @Override
    public Sujet RefuserDemendeEncadrant(String titreSujet) {
        Sujet s =sujetRepository.findBytitreSujet(titreSujet);
        s.setDemendeEncadrant(false);
        return s;
    }

    @Override
    public Sujet DetaillesSujet(String titreSujet) {
        Sujet s =sujetRepository.findBytitreSujet(titreSujet);
        s.getDescription();
        s.getNbrEtudiantMax();
        s.getNbrEtudiantMin();
        s.getResultatsattendus();
        s.getCompetances();

        return s;
    }

    public Ensigniant getEnseignantById(long id) {
        return ensigniantRepository.getOne(id);
    }

    @Override
    public void supprimerFilliere(Long id) {
     this.filliereRepository.deleteById(id);
    }

    @Override
    public void supprimerGoupe(Long id) {
        this.groupRepository.deleteById(id);
    }

    @Override
    public void supprimerDepartement(Long id) {
        this.departementRepository.deleteById(id);
    }

    @Override
    public void supprimerEnsegnint(Long id) {
        this.ensigniantRepository.deleteById(id);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        this.etudiantRepository.deleteById(id);
    }

    @Override
    public void PlaningFilliers(String nomfilliere, String anneeEncours, Date debutperiodeProposesujet ,Date finperiodeProposesujet) {
//        ParamatragePeriodePropose paramatragePeriodePropose = paramatragePeriodeProposeRepository.findByDebutperiodeProposesujet(debutperiodeProposesujet);
//        PlanningSoutenance planningSoutenance = planningSoutenanceRepository.findByDateSoutence(dateSoutence);

        Filliere filliere = filliereRepository.findByNomfilliere(nomfilliere);
//        filliere.setParamatragePeriodePropose(paramatragePeriodeProposeRepository.findByDebutperiodeProposesujet(debutperiodeProposesujet));
//        filliere.setParamatragePeriodePropose(paramatragePeriodeProposeRepository.findByDebutperiodeProposesujet(finperiodeProposesujet));
//        filliere.setPlanningSoutenance(planningSoutenanceRepository.findByDateSoutence(dateSoutence));
        filliere.setDebutperiodeProposesujet(debutperiodeProposesujet);
        filliere.setFinperiodeProposesujet(finperiodeProposesujet);
        filliere.setParamatrageAnnee(paramatrageAnneeRepository.findByAnneeEncours(anneeEncours));

    }

//    @Override
//    public void SoutenaceFilliers(String nomfilliere, Date dateSoutence,Date findateSoutence) {
//        PlanningSoutenance planningSoutenance = planningSoutenanceRepository.findByDateSoutence(dateSoutence);
//
//        Filliere filliere = filliereRepository.findByNomfilliere(nomfilliere);
//        filliere.setPlanningSoutenance(planningSoutenanceRepository.findByDateSoutence(dateSoutence));
//        filliere.setPlanningSoutenance(planningSoutenanceRepository.findByFindateSoutence(findateSoutence));
//
//planningSoutenance.getFillieres().add(filliere);
//    }

    @Override
    public List<Groupe> getGroupeFilliere(String nomfilliere) {
        Filliere filliere = filliereRepository.findByNomfilliere(nomfilliere);

        filliere.getGroupes();
        return getGroupes();

    }

    @Override
    public Page<Niveau> afficherAllNiveau(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return niveouRepository.affichierNiveau(pageable);
    }

    @Override
    public Page<Niveau> chercherNiveau(String nomNiveou, int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        return niveouRepository.chercherNiveau("%"+nomNiveou+"%",pageable);
    }

    @Override
    public Niveau modifierNiveau(long id, Niveau o) {
        o.setId(id);
        return niveouRepository.save(o);
    }


    @Override
    public Ensigniant modifierEnsegniant(long id, Ensigniant o) {
        o.setId(id);
        return ensigniantRepository.save(o);
    }

    @Override
    public Groupe modifierGroupe(long id, Groupe o) {
        o.setId(id);
        return groupRepository.save(o);
    }

    @Override
    public Filliere modifierFilliere(long id, Filliere o) {
        o.setId(id);
        return filliereRepository.save(o);
    }

    @Override
    public Departement modifierDepartement(long id, Departement o) {
        o.setId(id);
        return departementRepository.save(o);
    }

    @Override
    public Sujet modifierSujet(long id, Sujet o) {
        o.setId(id);
        return sujetRepository.save(o);
    }

    @Override
    public Page<Etudiant> afficherAllEtudiant(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return etudiantRepository.affichierEtudiant(pageable);
    }

    @Override
    public Page<Etudiant> chercherEtudiant(String matriculeetudiant, int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        return etudiantRepository.chercherEtudiant("%"+matriculeetudiant+"%",pageable);
    }

//    @Override
//    public Etudiant modifierEtudiant(long id, Etudiant o) {
//        o.setId(id);
//        return etudiantRepository.save(o);
//    }

    @Override
    public Page<Filliere> afficherAllFilliere(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return filliereRepository.affichierFilliere(pageable);
    }

    @Override
    public Page<Ensigniant> afficherEnsigniant(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return ensigniantRepository.affichierEnsigniant(pageable);
    }

    @Override
    public Page<Groupe> afficherGroupe(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return groupRepository.affichierGroupe(pageable);
    }

    @Override
    public Page<Ensigniant> chercherEnsigniant(String nomEnseigniant, int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        return ensigniantRepository.chercherEnsigniant("%"+nomEnseigniant+"%",pageable);
    }

    @Override
    public Page<Filliere> chercherFilliere(String nomfilliere, int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        return filliereRepository.chercherFilliere("%"+nomfilliere+"%",pageable);
    }

    @Override
    public Page<Groupe> chercherGroupe(String nomGrp, int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        return groupRepository.chercherGroupe("%"+nomGrp+"%",pageable);
    }

    @Override
    public Page<Sujet> afficherAllSujet(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return sujetRepository.affichierSujet(pageable);
    }

    @Override
    public Page<Sujet> chercherSujet(String titreSujet, int page, int size) {
        Pageable pageable=PageRequest.of(page, size);
        return sujetRepository.chercherSujet("%"+titreSujet+"%",pageable);
    }

    @Override
    public Niveau afficherByIdNiveau(long id) {

        // TODO Auto-generated method stub
        return niveouRepository.findById(id).get();
    }

    @Override
    public Departement afficherByIdDepartement(long id) {
        return departementRepository.findById(id).get();
    }

    @Override
    public Filliere afficherByIdFillier(long id) {
        return filliereRepository.findById(id).get();
    }

    @Override
    public Groupe afficherByIdGroup(long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public Ensigniant afficherByIdEnsegniant(long id) {
        return ensigniantRepository.findById(id).get();
    }

    @Override
    public Etudiant afficherByIdEtudiant(long id)
    {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public Sujet afficherByIdSujet(long id) {
        return sujetRepository.findById(id).get();    }

    @Override
    public void supprimerSujet(Long id) {
        this.sujetRepository.deleteById(id);
    }

    @Override
    public void supprimerNiveou(Long id) {
        this.niveouRepository.deleteById(id);

    }



//
//        Filliere filliere = filliereRepository.findByNomfilliere(nomfilliere);
//        if (filliere != null) throw new RuntimeException("Planig filliers already exists");
//        Filliere filliere1 = new Filliere();
//        filliere.setNomfilliere(nomfilliere);filliere.setParamatrageAnnee(paramatrageAnneeRepository.findByAnneeEncours(anneeEncours));
//        filliere.setParamatragePeriodePropose(paramatragePeriodeProposeRepository.findByDebutperiodeProposesujet(debutperiodeProposesujet));
//        filliere.setParamatragePeriodePropose(paramatragePeriodeProposeRepository.findByFinperiodeProposesujet(finperiodeProposesujet));
//        filliere.setPlanningSoutenance(planningSoutenanceRepository.findByDateSoutence(dateSoutence));
//        filliereRepository.save(filliere);
//
//        return filliere;

//    @Override
//    public void AddCordinateureToFilliere(long idfilliere, String NonCordinateur) {
//       Cordinateur cordinateur = cordinateurRepository.findByNonCordinateur(NonCordinateur);
//        Filliere filliere = filliereRepository.findByIdfilliere(idfilliere);
//       cordinateur.getFillier_cordone().add(filliere);
//   }
//
////
//   @Override
//  public Cordinateur saveCordinateure(long telEnsegniant, String NonCordinateur) {
//       Cordinateur cordinateur1 = cordinateurRepository.findByNonCordinateur(NonCordinateur);
//       if (cordinateur1 != null) throw new RuntimeException("cordinateur already exists");
//       Cordinateur cordinateur = new Cordinateur();
//        cordinateur.setNonCordinateur(NonCordinateur);
//        cordinateur.setTelEnsegniant(telEnsegniant);
//       cordinateurRepository.save(cordinateurRepository);
//      return cordinateur;
//   }


//    public Groupe saveSujetToGrp(String idGrp,Sujet sujet) {
//        Groupe groupe1 = groupRepository.findByIdGrp(idGrp);
//        if (groupe1 != null) throw new RuntimeException("group already exists");
//        Groupe groupe = new Groupe();
//        groupe.setIdGrp(idGrp);
//        groupe.setSujet(sujet);
//        groupRepository.save(groupe);
//        return groupe;
//    }


    @Override
    public List<Groupe> getGroupes() {
        return groupRepository.findAll();
    }

    @Override
    public List<Sujet> getSujets() {
        return sujetRepository.findAll();
    }

    @Override
    public String getNomEnsgniet() {
        Ensigniant ensigniant1 = new Ensigniant();
        ensigniant1.getNomEnseigniant();
        return  getNomEnsgniet();
    }
}











