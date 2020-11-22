package com.memoire.service;

import com.memoire.entity.*;
import com.sun.javafx.sg.prism.EffectFilter;
import javafx.scene.effect.Effect;
import org.springframework.data.domain.Page;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public  interface AccountService {
	
	public User saveUser(String username,String password,String confirmedPassword);
	public Role save(Role role);
    public User loadUsername(String username);

    public void addRoleToUser(String username ,String roleName);
    public Niveau saveNiveou(String nomNiveou,String code, String annee,String nomfilliere);

    public Etudiant saveEtudint(String matriculeetudiant,String nom, String prenom,String nomfilliere,String nomNiveou,String nomGrp);

    public void addEtudiantToCompte(String nom,String Compte );
    public void addEnsegniantToCompte(String nomEnseigniant,String Compte );
    public Groupe saveGroup(String nomGrp,String nomfilliere,String nomNiveou);
    public   Entreprise SaveEntreprice(String nomEntreprice,String adresse);
    public  ParamatrageAnnee SaveParamatrageAnnee(String anneeEncours);
    public  ParamatragePeriodePropose SavePeriodePropose(Date debutperiodeProposesujet,Date finperiodeProposesujet);
//    public PlanningSoutenance SavePlanigsoutenace(Date dateSoutence,Date findateSoutence);
//public PlanningSoutenance SavePlanigsoutenace(Date dateSoutence,Date findateSoutence);
//    public  void PlaningFilliers(String  nomfilliere,String anneeEncours,Date debutperiodeProposesujet,Date finperiodeProposesujet);
//    public  void SoutenaceFilliers(String  nomfilliere,Date dateSoutence,Date findateSoutence);



    public  void addEtudiantToGroup(String nomGrp,String matriculeetudiant);
    public  void addEnsegnintToJury(String idJury,String nomEnseigniant);
   public Sujet ProposeSujetParGrp(String titreSujset, String nomEntreprice,String nomGrp,String description);
    public Sujet ProposeSujetParEnseigniat(String titreSujet,String nomEnseigniant ,String nomEntreprice );
    public Ensigniant saveEnsigniant(Long telEnsegniant, String nomEnseigniant,String prenom,String nomDepartement);

    public Filliere SaveFillier(String nomfilliere,String Codefilliere,String nomDepartement);
    public Departement SaveDepertement(String nomDepartement, String codeDepartement);
    public void  EffectFilterToSujet( String nomfilliere,String nomEnseigniant);
    public void  EffectdepertementToEnsegniat( String nomDepartement,String nomEnseigniant);
    public void  EffectAnneeToSujet( String anneeEncours,String titreSujet);
    public void  EffectPeriodeProposeToSujet(Date periodeProposesujet, String titreSujet);
    public  Jury saveJury( String idJury);
    public List<Groupe> getGroupes();
    public List<Sujet> getSujets();
    public String getNomEnsgniet();
    //public  void AddCordinateureToFilliere(long idfilliere, String NonCordinateur);
    //public  Cordinateur saveCordinateure(long telEnsegniant,String NonCordinateur);

    public  Cordinateur saveCordinateure(String nomEnseigniant);
    public  void AddCordinateureToFilliere(String nomfilliere, String nomEnseigniant);
    public Sujet validerSujet(String titreSujet);
    public Sujet RefuserSujet(String titreSujet);
    public Sujet DemandeEncadrantSujet(String titreSujet,String nomEnseigniant);
    public  Sujet ValiderDemendeEncadrant(String titreSujet);
    public  Sujet RefuserDemendeEncadrant(String titreSujet);
    public  Sujet DetaillesSujet(String titreSujet);
    Ensigniant getEnseignantById(long id);

    public  void PlaningFilliers(String  nomfilliere,String anneeEncours,Date debutperiodeProposesujet,Date finperiodeProposesujet);
//    public  void SoutenaceFilliers(String  nomfilliere,Date dateSoutence,Date findateSoutence);
    public  List<Groupe> getGroupeFilliere(String nomfilliere );
    public Page<Niveau> afficherAllNiveau(int page, int size);
    public Page<Niveau> chercherNiveau(String nomNiveou,int page,int size);
    public Niveau modifierNiveau(long id,Niveau o);
//    public Etudiant modifierEtudiant(long id,Etudiant o);
    public Ensigniant modifierEnsegniant(long id,Ensigniant o);
    public Groupe modifierGroupe(long id,Groupe o);
    public Filliere modifierFilliere(long id,Filliere o);
    public Departement modifierDepartement(long id,Departement o);
    public Sujet modifierSujet(long id,Sujet o);
    public Page<Etudiant> afficherAllEtudiant(int page, int size);
    public Page<Etudiant> chercherEtudiant(String matriculeetudiant,int page,int size);

    public Page<Filliere> afficherAllFilliere(int page, int size);
    public Page<Ensigniant> afficherEnsigniant(int page, int size);
    public Page<Groupe> afficherGroupe(int page, int size);
    public Page<Ensigniant> chercherEnsigniant(String nomEnseigniant,int page,int size);
    public Page<Filliere> chercherFilliere(String nomfilliere,int page,int size);
    public Page<Groupe> chercherGroupe(String nomGrp,int page,int size);
    public Page<Sujet> afficherAllSujet(int page, int size);
    public Page<Sujet> chercherSujet(String titreSujet,int page,int size);
    public Niveau afficherByIdNiveau(long id);
    public Departement afficherByIdDepartement(long id);
    public Filliere afficherByIdFillier(long id);
    public Groupe afficherByIdGroup(long id);
    public Ensigniant afficherByIdEnsegniant(long id);
    public Etudiant afficherByIdEtudiant(long id);
    public Sujet afficherByIdSujet(long id);
    public void supprimerSujet(Long id);
    public void supprimerNiveou(Long id);
    public void supprimerFilliere(Long id);
    public void supprimerGoupe(Long id);
    public void supprimerDepartement(Long id);
    public void supprimerEnsegnint(Long id);
    public void supprimerEtudiant(Long id);



}
