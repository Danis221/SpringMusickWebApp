package ru.itis.mv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 63)
    private String password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles;

    private boolean enabled;

    @Column(length = 64)
    private String verificationCode;

    @OneToMany(mappedBy = "author")
    private List<Article> articles;


    @ManyToMany(mappedBy = "organizers")
    private Set<Event> events;

    @OneToMany(mappedBy = "author")
    private List<Forum> forums;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;
}
