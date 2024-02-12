package mx.edu.utez.clothingServices.model.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.address.BeanAddress;
import mx.edu.utez.clothingServices.model.orderHasProducts.BeanOrderHasProducts;
import mx.edu.utez.clothingServices.model.orderStatus.BeanOrderStatus;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class BeanOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    //relacion muchos a uno con la tabla addresses
    @ManyToOne
    @JoinColumn(name = "fk_id_address")
    private BeanAddress address;

    //relacion muchos a uno con la tabla orders_status
    @ManyToOne
    @JoinColumn(name = "fk_id_order_status")
    private BeanOrderStatus orderStatus;

    //relacion uno a muchos con la tabla order_has_products
    @OneToMany(mappedBy = "order")
    private List<BeanOrderHasProducts> orderHasProducts;
}
