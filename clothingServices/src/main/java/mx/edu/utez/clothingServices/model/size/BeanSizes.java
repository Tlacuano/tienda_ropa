package mx.edu.utez.clothingServices.model.size;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.variant.BeanVariant;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sizes")
public class BeanSizes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_size")
    private Long idSize;

    //relacion uno a muchos con la tabla variants
    @OneToMany(mappedBy = "size")
    private List<BeanVariant> variants;
}
