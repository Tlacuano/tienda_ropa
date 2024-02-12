package mx.edu.utez.clothingServices.model.userRoles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.role.BeanRole;
import mx.edu.utez.clothingServices.model.user.BeanUser;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_roles")
@Entity
public class BeanUserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_role")
    private Long idUserRoles;


    //relacion muchos a uno con la tabla users
    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private BeanUser user;

    //relacion muchos a uno con la tabla roles
    @ManyToOne
    @JoinColumn(name = "fk_id_role")
    private BeanRole role;
}
