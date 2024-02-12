package mx.edu.utez.clothingServices.model.wishList;

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
@Table(name = "wish_list")
public class BeanWishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wish")
    private Long idWish;

    //relacion muchos a uno con la tabla products
    @ManyToOne
    @JoinColumn(name = "fk_id_product")
    private BeanProduct product;

    //relacion muchos a uno con la tabla users
    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private BeanUser user;
}
