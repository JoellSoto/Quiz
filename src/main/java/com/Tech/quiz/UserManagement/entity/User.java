package com.Tech.quiz.UserManagement.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "USERS")
public class User  implements UserDetails{

    @Id
    @SequenceGenerator(
            name="User_sequence",
            sequenceName="User_sequence",
            allocationSize =1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator ="User_sequence"
    )
    private int id;

    private String firstName,secondName,email,password;


    public Collection<? extends GrantedAuthority> getAuthorities() {

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    @JsonManagedReference(value="users")
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
    @JoinTable(name="USER_ROLES",
            joinColumns = @JoinColumn(name="user_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id"))
    private Collection<Roles>roles=new HashSet<>();
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
