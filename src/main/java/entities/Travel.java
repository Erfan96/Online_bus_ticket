package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "travel")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "origin", nullable = false)
    private City origin;

    @ManyToOne
    @JoinColumn(name = "destination", nullable = false)
    private City destination;

    @Column(name = "departure_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Column(name = "departure_time", nullable = false)
    private String departureTime;

    @Column(name = "travel_id", nullable = false)
    private String travelId;

    @Override
    public String toString() {
        return origin + " - " + destination;
    }
}
