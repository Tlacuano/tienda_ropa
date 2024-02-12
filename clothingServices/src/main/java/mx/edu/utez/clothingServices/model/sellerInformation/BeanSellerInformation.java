package mx.edu.utez.clothingServices.model.sellerInformation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.people.BeanPeople;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sellers_information")
@Entity
public class BeanSellerInformation {
    @Id
    @Column(name = "id_seller_information")
    private Long idSellerInformation;

    //relacion uno a uno con la tabla people
    @OneToOne
    @MapsId
    @JoinColumn(name = "fk_id_user")
    private BeanPeople person;
}
