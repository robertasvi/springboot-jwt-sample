package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name="users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String firstname;
    String surname;
    @OneToOne(fetch = FetchType.EAGER)
    File photo;
    String about;
    String email;
    String phone;
    @OneToMany(fetch = FetchType.EAGER)
    Country country;
    String address;
    @OneToMany(fetch = FetchType.EAGER)
    Company company;
    boolean isAdmin;
    @OneToMany(fetch = FetchType.EAGER)
    Role role;
    @OneToMany(fetch = FetchType.EAGER)
    Group group;
    @OneToMany(fetch = FetchType.LAZY)
    List<Classroom> classrooms;
    long logged;
    long created;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;



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
}
