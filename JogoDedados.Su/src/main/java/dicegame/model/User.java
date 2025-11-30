package dicegame.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 public Long id;
 public String name;
 public String email;
 public String password;

 @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
 public List<Bet> bets;
}
