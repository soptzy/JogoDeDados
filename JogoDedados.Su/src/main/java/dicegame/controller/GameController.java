package dicegame.controller;

import org.springframework.web.bind.annotation.*;
import dicegame.repo.*;
import dicegame.model.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class GameController {

 private final UserRepository ur;
 private final BetRepository br;
 Random r=new Random();

 public GameController(UserRepository ur, BetRepository br){
  this.ur=ur; this.br=br;
 }

 @PostMapping("/users")
 public User create(@RequestBody User u){
  if(u.password==null) u.password="123";
  return ur.save(u);
 }

 @PostMapping("/bets/{id}")
 public Bet bet(@PathVariable Long id, @RequestBody Bet b){
  User u=ur.findById(id).orElse(null);
  b.user=u;
  int d1=r.nextInt(6)+1;
  int d2=r.nextInt(6)+1;
  b.win = d1+d2>7;
  return br.save(b);
 }

 @GetMapping("/users")
 public List<User> all(){ return ur.findAll(); }

 @GetMapping("/bets")
 public List<Bet> allb(){ return br.findAll(); }

 @GetMapping("/bets/user/{id}")
 public List<Bet> bu(@PathVariable Long id){ return br.findByUserId(id); }
}
