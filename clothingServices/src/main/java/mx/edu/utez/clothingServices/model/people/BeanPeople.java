package mx.edu.utez.clothingServices.model.people;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.sellerInformation.BeanSellerInformation;
import mx.edu.utez.clothingServices.model.user.BeanUser;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "people")
@Entity
public class BeanPeople {
    @Id
    @Column(name = "id_person")
    private Long idPeople;

    @OneToOne
    @MapsId
    @JoinColumn(name = "fk_id_user")
    private BeanUser user;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private BeanSellerInformation sellerInformation;
}
