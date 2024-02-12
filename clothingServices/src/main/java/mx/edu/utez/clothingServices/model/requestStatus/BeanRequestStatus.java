package mx.edu.utez.clothingServices.model.requestStatus;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.requestSellProduct.BeanReuestSellProduct;
import mx.edu.utez.clothingServices.model.requestSeller.BeanRequestSeller;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "request_satus")
public class BeanRequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request_status")
    private Long idRequestStatus ;

    //relacion uno a muchos con la tabla requestSeller
    @OneToMany(mappedBy = "status")
    private List<BeanRequestSeller> requestsSellers;

    //relacion uno a muchos con la tabla requestSellProduct
    @OneToMany(mappedBy = "status")
    private List<BeanReuestSellProduct> reuestsSellProducts;


}
