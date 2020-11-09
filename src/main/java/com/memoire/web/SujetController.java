package com.memoire.web;

import com.memoire.entity.Sujet;
import com.memoire.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SujetController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/DetaillesSujet/{titreSujet}")
    public Sujet DetaillesSujet(@PathVariable String titreSujet) {
        return accountService.DetaillesSujet(titreSujet);
    }
}
