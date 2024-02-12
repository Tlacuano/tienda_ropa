package mx.edu.utez.clothingServices.model.people;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.address.BeanAddress;
import mx.edu.utez.clothingServices.model.sellerInformation.BeanSellerInformation;
import mx.edu.utez.clothingServices.model.user.BeanUser;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "people")
@Entity
public class BeanPeople {
    @Id
    @Column(name = "id_person")
    private Long idPeople;

    //relacion uno a uno con la tabla users, usamos la misma llave primaria
    @OneToOne
    @MapsId
    @JoinColumn(name = "fk_id_user")
    private BeanUser user;

    //relacion uno a uno con la tabla seller_information
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private BeanSellerInformation sellerInformation;

    //relacion uno a muchos con la tabla address
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BeanAddress> address;
}
