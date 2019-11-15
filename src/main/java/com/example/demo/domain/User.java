package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    String firstname;
    String surname;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    File photo;
    String about;
    String email;
    String phone;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Country country;
    String address;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Company company;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Role role;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    CustomGroup group;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Classroom> classrooms;
    long logged;
    long created;


    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin() {
        return true;
    }
}
