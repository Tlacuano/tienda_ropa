package mx.edu.utez.clothingServices.model.role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.userRoles.BeanUserRoles;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class BeanRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    //relacion muchos a muchos con la tabla users
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<BeanUserRoles> users;
}
