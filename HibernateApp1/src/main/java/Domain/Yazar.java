package Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Yazar_Table")
public class Yazar {
    @SequenceGenerator(name = "yazar",allocationSize = 1)
    @Id
    @GeneratedValue(generator = "yazar",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "yazarlar"
    )
    private Set<Kitap> kitaplar=new HashSet<>();
}
