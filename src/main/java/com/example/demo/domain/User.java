package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String firstname;
    String surname;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    File photo;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Company company;
    @Lob
    String about;
    String email;
    String phone;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id")
    Role role;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "group_id")
    CustomGroup group;
    boolean isApproved;
    long logged;
    long created;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
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
