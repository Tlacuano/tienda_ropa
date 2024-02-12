package mx.edu.utez.clothingServices.model.department;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.product.BeanProduct;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "departments")
@Entity
public class BeanDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    private Long idDepartment;

    //relacion uno a muchos con la tabla products
    @OneToMany(mappedBy = "department")
    private List<BeanProduct> products;
}
