package com.memoire.secerity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //descecivi
        http.csrf().disable();
        //pas de session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**", "/register").permitAll();
        //different autheristion

        http.authorizeRequests().antMatchers("/users", "/user/**","/roles", "/groupes", "/ensigniantslist", "/ensigniants/**", "/Sujets", "/etudiants", "/paramatragePeriodeProposes", "/paramatrageAnnees", "/usersetudiants", "/planningSoutenances", "/jurys", "/ProposeSujetParGrp", "/ProposeSujetParEnseigniat/**", "/entreprises", "/ListeSujetPropose", "/DemandeEncadrantSujet", "/nomEnseginat", "/ValiderDemendeEncadrant", "/RefuserDemendeEncadrant", "/DetaillesSujet/**", "/user/**", "/supprimerFilliere","/listNiveaus","/chercherNiveaus","/chercherEtudiant","/listEtudiant","/listFilliere","/listEnsigniant","/listGroupe","chercherEnsigniant","/chercherFilliere","/chercherGroupe","/supprimerNiveou").hasAnyAuthority("Etudiant");

        http.authorizeRequests().antMatchers("/users","/user/**", "/roles", "/groupes", "/ensigniantslist", "/ensigniants", "/Sujets", "/etudiants", "/paramatragePeriodeProposes", "/paramatrageAnnees", "/usersetudiants", "/planningSoutenances", "/jurys", "/ProposeSujetParGrp", "/ProposeSujetParEnseigniat", "/entreprises", "/ListeSujetPropose", "/nomEnseginat", "/ValiderDemendeEncadrant", "/RefuserDemendeEncadrant", "/DetaillesSujet", "/user", "/supprimerFilliere","/listNiveaus","/chercherNiveaus","/chercherEtudiant","/listEtudiant","/listFilliere","/listEnsigniant","/listGroupe","chercherEnsigniant","/chercherFilliere","/chercherGroupe","/supprimerNiveou","/modifierSujet","/supprimerSujet","/afficherByIdSujet","/chercherSujet","/listSujet").hasAnyAuthority("Ensigniant","Etudiant","Admin");
        http.authorizeRequests().antMatchers("/users","/user/**","/roles/**","/groupes","/ensigniants","/Sujets","/etudiants","/paramatragePeriodeProposes","/paramatrageAnnees","/usersetudiants","/planningSoutenances","/jurys","/ProposeSujetParGrp","/ProposeSujetParEnseigniat","/entreprises","/ListeSujetPropose","/nomEnseginat","/ValiderDemendeEncadrant","/RefuserDemendeEncadrant","/DetaillesSujet","/saveRole","/addRoleToUser","/saveEtudint","/register","/saveGroup","/saveEnsigniant","/addEtudiantToGroup","/saveEntreprice","/saveFillier","/saveDepertement","/addEtudiantToCompte","/saveParamatrageAnnee","/savePeriodePropose","/effectFilterToSujet","/addEnsegniantToCompte","/effectdepertementToEnsegniat","/fillieres","/departements","/saveNiveou","/niveaus","/PlaningFilliers","/soutenaceFilliers","/planningSoutenances","/savePlanigsoutenace","/getGroupeFilliere","/getDepertementFilliers","/getFillierNiveou","/getNiveouGroupe","/getAnneeEncours","/modifierNiveau","/afficherByIdNiveau","/afficherByIdGroup","/afficherByIdFillier","/afficherByIdDepartement","/afficherByIdEtudiant","/afficherByIdEnsegniant","/supprimerFilliere","/supprimerDepartement","/supprimerGoupe","/supprimerEnsegnint","/supprimerNiveou","/supprimerEtudiant","/modifierDepartement","/modifierFilliere","/modifierEtudiant","/modifierEnsegniant","/modifierGroupe").hasAnyAuthority("Admin");


        http.authorizeRequests().antMatchers("/sujetValider/**","/user/**", "/RefuserSujet/**").hasAnyAuthority("Cordinateur","USER");

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthentificationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
