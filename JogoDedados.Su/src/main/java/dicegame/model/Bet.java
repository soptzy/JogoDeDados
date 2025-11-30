package dicegame.model;

import jakarta.persistence.*;

@Entity
public class Bet {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 public Long id;
 public String title;
 public Integer amount;
 public Boolean win;

 @ManyToOne @JoinColumn(name="user_id")
 public User user;
}
