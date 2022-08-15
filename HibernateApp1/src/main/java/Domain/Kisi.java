package Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "Kisi")
public class Kisi {
    @SequenceGenerator(name = "Kisi",sequenceName = "KisiId")
    @Id
    @GeneratedValue(generator = "Kisi",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "İsim",length = 100)
    private String name;
    @OneToOne(fetch = FetchType.LAZY,
    optional = false,
    mappedBy = "kisi")
    private Parmakİzi parmakİzi;
}
