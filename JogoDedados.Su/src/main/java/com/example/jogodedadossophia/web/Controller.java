package com.example.jogodedadossophia.web;

import com.example.jogodedadossophia.model.*;
import com.example.jogodedadossophia.repo.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
@RequestMapping("/api")
public class UglyController {

    private final UserRepository ur;
    private final BetRepository br;
    Random r = new Random();

    public UglyController(UserRepository ur, BetRepository br) {
        this.ur = ur;
        this.br = br;
    }

    @PostMapping("/usuario")
    public ResponseEntity<User> criar(@RequestBody User u) {
        if (ur.findByEmail(u.email)!=null) return ResponseEntity.badRequest().build();
        if (u.senha==null) u.senha="123";
        return ResponseEntity.ok(ur.save(u));
    }

    @PostMapping("/apostar/{id}")
    public ResponseEntity<Bet> apostar(@PathVariable Long id, @RequestBody Bet b) {
        Optional<User> u = ur.findById(id);
        if (u.isEmpty()) return ResponseEntity.notFound().build();
        b.dono = u.get();
        int d1=r.nextInt(6)+1;
        int d2=r.nextInt(6)+1;
        b.ganhou = d1+d2>7;
        if (b.valor==null) b.valor=1;
        return ResponseEntity.ok(br.save(b));
    }

    @GetMapping("/usuarios")
    public List<User> users(){ return ur.findAll(); }

    @GetMapping("/apostas")
    public List<Bet> bets(){ return br.findAll(); }

    @GetMapping("/apostas/usuario/{id}")
    public List<Bet> betsUser(@PathVariable Long id){ return br.findByDonoId(id); }
}
