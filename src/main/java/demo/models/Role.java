package demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseModel {

    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
