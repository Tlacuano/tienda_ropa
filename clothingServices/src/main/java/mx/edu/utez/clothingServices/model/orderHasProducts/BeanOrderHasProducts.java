package mx.edu.utez.clothingServices.model.orderHasProducts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.order.BeanOrder;
import mx.edu.utez.clothingServices.model.product.BeanProduct;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_has_products")
public class BeanOrderHasProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_has_product")
    private Long idOrderHasProduct;

    //relacion muchos a uno con la tabla orders
    @ManyToOne
    @JoinColumn(name = "fk_id_order")
    private BeanOrder order;

    //relacion muchos a uno con la tabla products
    @ManyToOne
    @JoinColumn(name = "fk_id_product")
    private BeanProduct product;

}
