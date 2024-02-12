package mx.edu.utez.clothingServices.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.comment.BeanComment;
import mx.edu.utez.clothingServices.model.people.BeanPeople;
import mx.edu.utez.clothingServices.model.product.BeanProduct;
import mx.edu.utez.clothingServices.model.requestSeller.BeanRequestSeller;
import mx.edu.utez.clothingServices.model.shoppingCar.BeanShoppingCar;
import mx.edu.utez.clothingServices.model.userRoles.BeanUserRoles;
import mx.edu.utez.clothingServices.model.wishList.BeanWishList;

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

    //relacion uno a muchos con la tabla products
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BeanProduct> products;

    //relacion uno a muchos con la tabla comments
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BeanComment> comments;

    //relacion uno a muchos con la tabla wish_list
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BeanWishList> wishList;

    //relacion uno a muchos con la tabla shopping_car
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BeanShoppingCar> shoppingCar;


}
