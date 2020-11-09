



package com.memoire;
import  java.lang.NullPointerException;
import java.util.Date;
import java.util.stream.Stream;

import com.memoire.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.memoire.service.AccountService;

@SpringBootApplication
public class GestionMemoireApplication  {
	@Autowired
	private RepositoryRestConfiguration restConfiguration;


	public static void main(String[] args) {
		SpringApplication.run(GestionMemoireApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountService accontService) {
		return args->{
			restConfiguration.exposeIdsFor(ParamatragePeriodePropose.class);
			restConfiguration.exposeIdsFor(Departement.class);
			restConfiguration.exposeIdsFor(Groupe.class);
			restConfiguration.exposeIdsFor(Etudiant.class);
			restConfiguration.exposeIdsFor(Sujet.class);
			restConfiguration.exposeIdsFor(Ensigniant.class);
			restConfiguration.exposeIdsFor(Entreprise.class);
			restConfiguration.exposeIdsFor(Filliere.class);
			restConfiguration.exposeIdsFor(User.class);
			restConfiguration.exposeIdsFor(ParamatrageAnnee.class);
			accontService.save(new Role(1,"USER"));
			accontService.save(new Role(2,"Etudiant"));
			accontService.save(new Role(3,"Ensigniant"));
			accontService.save(new Role(4,"Cordinateur"));
			accontService.save(new Role(5,"Admin"));





//
//
//			Stream.of("ediye@gmail.com","Cheikh","Moussa","Meimoune@gmail.com","mouna@gmail.com","admin").forEach(un->{
//				accontService.saveUser(un,"1234","1234");
//			});
//
//			accontService.addRoleToUser("ediye@gmail.com","Etudiant");
//			accontService.addRoleToUser("Cheikh","Ensigniant");
//			accontService.addRoleToUser("Cheikh","Cordinateur");
//			accontService.addRoleToUser("Moussa","Ensigniant");
//
//			accontService.addRoleToUser("admin","Admin");
//			accontService.addRoleToUser("mouna@gmail.com","Etudiant");
//			accontService.addRoleToUser("Meimoune@gmail.com","Etudiant");
//			accontService.SaveDepertement("Méthodes Quantitatives et Informatiques","M.Q.I");
//			accontService.SaveDepertement("Management Economie et Droit","MED");
//
//			accontService.SaveFillier("Finance et Comptabilite","FC","Management Economie et Droit");
//			accontService.SaveFillier("Banques & Assurances","BA","Management Economie et Droit");
//			accontService.SaveFillier("Gestion des Ressources Humaines","RH","Management Economie et Droit");
//			accontService.SaveFillier("Informatique du Gestion","IG","Méthodes Quantitatives et Informatiques");
//			accontService.SaveFillier("Reseaux informatiques et Telecommunications","RS","Méthodes Quantitatives et Informatiques");
//			accontService.SaveFillier("Statistique appliquee a l Economie","SE","Méthodes Quantitatives et Informatiques");
//			accontService.SaveFillier("Techniques  Commerciales et Marketing","TCM","Management Economie et Droit");
//
//			accontService.SaveFillier("Develeoppment_Informatique","D.I","Méthodes Quantitatives et Informatiques");
//			accontService.saveNiveou("Licence1","L1","2019-2020","Develeoppment_Informatique");
//			accontService.saveNiveou("Licence2","L2","2019-2020","Develeoppment_Informatique");
//			accontService.saveNiveou("Licence3","L3","2019-2020","Develeoppment_Informatique");
//			accontService.saveNiveou("Master1","M1","2019-2020","Develeoppment_Informatique");
//			accontService.saveNiveou("Master2","M2","2019-2020","Develeoppment_Informatique");
//			accontService.saveGroup( "Groupe1","Develeoppment_Informatique","Licence3");
//			accontService.saveGroup( "Groupe2","Develeoppment_Informatique","Licence3");
//			accontService.saveGroup( "Groupe3","Develeoppment_Informatique","Licence3");
//			accontService.saveEtudint("IP17660","Meimoune","Med salem","Develeoppment_Informatique","Licence3","Groupe1");
//			accontService.saveEtudint("l31256","lbekay","Med salem","Informatique du Gestion","Licence3","Groupe1");
//			accontService.saveEtudint("l31123","sara","Med ","Statistique appliquee a l Economie","Licence3","Groupe1");
//			accontService.saveEtudint("l35678","Aly","Atigh","Techniques  Commerciales et Marketing","Licence3","Groupe2");
//			accontService.saveEtudint("l3006","Melike","babe","Banques & Assurances","Licence3","Groupe2");
//
//			accontService.saveEtudint("l31678","Med","salem","Finance et Comptabilite","Licence3","Groupe2");
//			accontService.saveEtudint("l3700","faty","sidi","Banques & Assurances","Licence3","Groupe2");
//			accontService.saveEtudint("l30412","vayze","salem","Gestion des Ressources Humaines","Licence3","Groupe2");
//			accontService.saveEtudint("l38702","Iman","salem","Reseaux informatiques et Telecommunications","Licence3","Groupe2");
//			accontService.saveEtudint("IP17659","Mouna","Isselmou","Develeoppment_Informatique","Licence3","Groupe1");
//			accontService.saveEtudint("IE17623","ediye","babe ahmed","Develeoppment_Informatique","Licence3","Groupe1");
//
//			accontService.addEtudiantToCompte("ediye","ediye@gmail.com");
//			accontService.addEtudiantToCompte("Meimoune","Meimoune@gmail.com");
//			accontService.addEtudiantToCompte("Mouna","mouna@gmail.com");
//			accontService.saveEnsigniant((long) 3679082,"Moussa","Dembe","Méthodes Quantitatives et Informatiques");
//			accontService.saveEnsigniant((long) 36119845,"Cheikh ","dhib","Méthodes Quantitatives et Informatiques");
//			accontService.saveEnsigniant((long) 26790987,"Sidi ","bihe","Méthodes Quantitatives et Informatiques");
//			accontService.saveEnsigniant((long) 22334455,"Hamadi ","med","Management Economie et Droit");
//
//
//
//			accontService.addEnsegniantToCompte("Cheikh","Cheikh");
//
//			accontService.EffectdepertementToEnsegniat("Méthodes Quantitatives et Informatiques","Moussa");
//			accontService.EffectdepertementToEnsegniat("Méthodes Quantitatives et Informatiques","Cheikh");
//			accontService.addEnsegniantToCompte("Moussa","Moussa");
//
//
//			accontService.addEtudiantToGroup("Groupe1","IE17623");
//			accontService.addEtudiantToGroup("Groupe1","IP17660");
//			accontService.addEtudiantToGroup("Groupe2","IP17659");
//			accontService.addEtudiantToGroup("Groupe3","med");
//			accontService.SaveEntreprice("A2","add1");
//			accontService.SaveEntreprice("Alpha","add1");
//			accontService.SaveEntreprice("SISCAT","add1");
//			accontService.SaveEntreprice("Zayed","add1");
//			accontService.SaveEntreprice("STM","add1");
//			accontService.SaveEntreprice("SMCP","add1");
//			accontService.ProposeSujetParGrp("CompangeVaccination","SISCAT","Groupe1","une platforme de collection des donnes pour une  Compange de Vaccination ....");
////	accontService.ProposeSujetParGrp("GestionCabinetMedical","Zayed","g2");
//			accontService.ProposeSujetParGrp("SupplyChainMangment","A2","Groupe2"," une platforme de  SupplyChainMangment........ ");
//			accontService.ProposeSujetParEnseigniat("GetionRessource","SMCP", "Moussa");
//			accontService.ProposeSujetParEnseigniat("E_Commerce","Alpha","Cheikh");
////			accontService.saveCordinateure(36119845,"Cheikh");
////		accontService.AddCordinateureToFilliere(1,36119845);
//			accontService.EffectFilterToSujet("Develeoppment_Informatique","E_Commerce");
//			accontService.EffectFilterToSujet("Develeoppment_Informatique","GetionRessource");
//			accontService.EffectFilterToSujet("Develeoppment_Informatique","SupplyChainMangment");
//			accontService.EffectFilterToSujet("Develeoppment_Informatique","CompangeVaccination");
////			accontService.saveAnneEncours(2020/2021);
////			accontService.SaveParamatrageAnnee("2020-2021");
////			accontService.EffectAnneeToSujet("2020-2021","CompangeVaccination");
//////			accontService.EffectAnneeToSujet("2020-2021","GestionCabinetMedical");
//////			accontService.EffectAnneeToSujet("2020-2021","SupplyChainMangment");
////			accontService.EffectAnneeToSujet("2020-2021","GetionRessource");
////			accontService.EffectAnneeToSujet("2020-2021","E_Commerce");
//			accontService.DemandeEncadrantSujet("CompangeVaccination","Cheikh");
////	     accontService.SavePeriodePropose( new Date(16-8-2020));
//			accontService.saveJury("jery1");
//		accontService.saveJury("jery1");
////			accontService.saveJury("jery2");
////			accontService.saveJury("jery3");
////			accontService.saveJury("jery");
////			accontService.addEnsegnintToJury("jery1","Moussa");
////			accontService.addEnsegnintToJury("jery1","Cheikh");
//			accontService.SaveParamatrageAnnee("2019-2020");
//		accontService.SavePeriodePropose(new Date(04/03/2019),new Date(04/04/2019));
//		accontService.SavePlanigsoutenace(new Date(15/11/2019),new Date(15/12/2019));
//	accontService.PlaningFilliers("Develeoppment_Informatique","2019-2020",new Date(04/03/2019),new Date(20/11/2019));
//accontService.SoutenaceFilliers("Develeoppment_Informatique",new Date(20/11/2019),new Date(15/12/2019));
//
//
//
//


		};
	}
	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
}


















