package Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "Ulke")
public class Ulke {
    @SequenceGenerator(name = "ulke",sequenceName = "Ulke_Id_Seq")
    @Id
    @GeneratedValue(generator = "ulke",strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "Adı",length = 100)
    private String name;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ulke",
            targetEntity = Sehir.class
    )
    private Set sehirler=new HashSet();

}
