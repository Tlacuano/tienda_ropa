package mx.edu.utez.clothingServices.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.people.BeanPeople;
import mx.edu.utez.clothingServices.model.requestSeller.BeanRequestSeller;
import mx.edu.utez.clothingServices.model.userRoles.BeanUserRoles;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class BeanUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;


    //relacion muchos a muchos con la tabla roles
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BeanUserRoles> roles;

    //relacion uno a uno con la tabla people
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BeanPeople person;

    //relacion muchos a muchos con la tabla requests_seller
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BeanRequestSeller> requestsSeller;

}
