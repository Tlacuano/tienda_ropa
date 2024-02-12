package mx.edu.utez.clothingServices.model.requestSellProduct;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.product.BeanProduct;
import mx.edu.utez.clothingServices.model.requestStatus.BeanRequestStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "request_sell_product")
public class BeanReuestSellProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private Long idRequest;

    //relacion muchos a uno con la tabla products
    @ManyToOne
    @JoinColumn(name = "fk_id_product")
    private BeanProduct product;

    //relacion muchos a uno con la tabla request_status
    @ManyToOne
    @JoinColumn(name = "fk_id_status")
    private BeanRequestStatus status;
}
