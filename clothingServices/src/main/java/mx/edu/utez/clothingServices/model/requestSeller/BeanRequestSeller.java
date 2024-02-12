package mx.edu.utez.clothingServices.model.requestSeller;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.requestStatus.BeanRequestStatus;
import mx.edu.utez.clothingServices.model.user.BeanUser;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "requests_seller")
public class BeanRequestSeller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private Long idRequest ;

    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private BeanUser user;

    @ManyToOne
    @JoinColumn(name = "fk_id_status")
    private BeanRequestStatus status;
}
