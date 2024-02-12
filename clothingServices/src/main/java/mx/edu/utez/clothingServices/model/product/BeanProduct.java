package mx.edu.utez.clothingServices.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.category.BeanCategory;
import mx.edu.utez.clothingServices.model.comment.BeanComment;
import mx.edu.utez.clothingServices.model.department.BeanDepartment;
import mx.edu.utez.clothingServices.model.orderHasProducts.BeanOrderHasProducts;
import mx.edu.utez.clothingServices.model.productGallery.BeanProductGallery;
import mx.edu.utez.clothingServices.model.requestSellProduct.BeanReuestSellProduct;
import mx.edu.utez.clothingServices.model.shoppingCar.BeanShoppingCar;
import mx.edu.utez.clothingServices.model.user.BeanUser;
import mx.edu.utez.clothingServices.model.variant.BeanVariant;
import mx.edu.utez.clothingServices.model.wishList.BeanWishList;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
@Entity
public class BeanProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    //relacion muchos a uno con la tabla categories
    @ManyToOne
    @JoinColumn(name = "fk_id_category")
    private BeanCategory category;

    //relacion muchos a uno con la tabla departments
    @ManyToOne
    @JoinColumn(name = "fk_id_department")
    private BeanDepartment department;

    //relacion muchos a uno con la tabla users
    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private BeanUser user;

    //relacion uno a muchos con la tabla variants
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BeanVariant> variants;

    //relacion uno a muchos con la tabla product gallery
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BeanProductGallery> productGallery;

    //relacion uno a muchos con la tabla request_sell_product
    @OneToMany(mappedBy = "product")
    private List<BeanReuestSellProduct> reuestsSellProducts;

    //relacion uno a muchos con la tabla comments
    @OneToMany(mappedBy = "product")
    private List<BeanComment> comments;

    //relacion uno a muchos con la tabla wish_list
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<BeanWishList> wishList;

    //relacion uno a muchos con la tabla shopping_car
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<BeanShoppingCar> shoppingCar;

    //relacion uno a muchos con la tabla order_has_product
    @OneToMany(mappedBy = "product")
    private List<BeanOrderHasProducts> orderHasProducts;


}
