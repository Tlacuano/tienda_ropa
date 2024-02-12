package mx.edu.utez.clothingServices.model.shoppingCar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.product.BeanProduct;
import mx.edu.utez.clothingServices.model.user.BeanUser;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "shopping_car")
public class BeanShoppingCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping_car")
    private Long idShoppingCar;

    //relacion muchos a uno con la tabla products
    @ManyToOne
    @JoinColumn(name = "fk_id_product")
    private BeanProduct product;

    //relacion muchos a uno con la tabla users
    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private BeanUser user;
}
