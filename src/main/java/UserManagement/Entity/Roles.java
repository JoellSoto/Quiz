package UserManagement.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name= "ROLE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Roles
{

    @Id
    @SequenceGenerator(
            name="Role_sequence",
            sequenceName="Role_sequence",
            allocationSize =1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator ="Role_sequence"
    )
    private int id;

    @NaturalId
    private String name;

    @JsonBackReference(value="users")
    @ManyToMany(mappedBy="roles")
    private Collection<User> users=new HashSet<>();
    public void removeAllUsersFromRole() {
        if(getUsers()!= null) {
            List<User> usersInRole = getUsers().stream().toList();
            usersInRole.forEach(this::removeUserFromRole);
        }
    }

    public void removeUserFromRole(User user) {
        user.getRoles().remove(this);
        this.getUsers().remove(user);
    }

    public void addUserFromRole(User user) {
        user.getRoles().add(this);
        this.getUsers().add(user);
    }
}
