package Domain;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "parmak_izi")
@Data
public class Parmakİzi {
    @SequenceGenerator(name = "parmak",sequenceName = "ParmakId")
    @Id
    @GeneratedValue(generator = "parmak",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(length = 10,name = "Dosya_No")
    private String dosyaNo;
    @OneToOne(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    orphanRemoval = true,
    optional = false)
    private Kisi kisi;
}
