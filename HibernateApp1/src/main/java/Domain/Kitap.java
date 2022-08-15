package Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Kitap")
@Data
public class Kitap {
    @SequenceGenerator(name = "kitap",sequenceName = "Kitap_Id_Sequnece",allocationSize = 1)
    @Id
    @GeneratedValue(generator = "kitap",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "İsim",length = 100)
    private String name;
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Yazar.class
    )
    private Set yazarlar=new HashSet();
}
