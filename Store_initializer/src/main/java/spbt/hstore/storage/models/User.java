package spbt.hstore.storage.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "employee_tab")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String name;
    //счетчик купленных вещей
    private Integer count;
    @Enumerated(value = EnumType.STRING)
    private UserRoles role;

    @Column(name = "hash_password")
    private String hashPassword;

//    @OneToMany(mappedBy = "user") не нужно????
//    private List<CookieValue> cookieValue;
}