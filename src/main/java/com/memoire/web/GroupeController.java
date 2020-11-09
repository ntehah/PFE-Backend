package com.memoire.web;

import com.memoire.dao.GroupRepository;
import com.memoire.entity.Groupe;
import com.memoire.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class GroupeController {
    @Autowired
    private GroupRepository groupRepository;


    @GetMapping("/groupes")
    public List<Groupe> getGroupes(){

        return groupRepository.findAll();
    }
}
