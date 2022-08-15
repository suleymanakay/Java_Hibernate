package Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "urunlerin_sinifi")
@Data
public class UrunTuru {
    @SequenceGenerator(name = "tur",sequenceName = "Urun_Id_Seq")
    @Id
    @GeneratedValue(generator = "tur",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "Ad",length = 100)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "ürün_Türü", length = 100)
    private EnumUrunTuru urunTuru;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Urun.class,mappedBy = "urunTuru")
    private Set urunler=new HashSet();
}
