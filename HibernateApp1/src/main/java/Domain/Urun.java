package Domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "Urun")
@Data
public class Urun {
    @SequenceGenerator(name = "urun",sequenceName = "Urun_Id_Seq")
    @Id
    @GeneratedValue(generator = "urun",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "Adı",length = 100)
    private String name;
    @Column(name = "Fiyat",precision = 15,scale = 2)
    private BigDecimal fiyat;
    @Column(name = "Son_Kullanma_Tarihi")
    @Temporal(TemporalType.DATE)
    private Date sonKullanmaTarihi;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ürün_Türü")
    private UrunTuru urunTuru;
    @Column(name = "Stok_Mıktarı")
    private Long stockMiktari;
    @Enumerated(EnumType.STRING)
    @Column(name = "Stok_Bırım",length = 30)
    private EnumBirim stockBirim;
}
