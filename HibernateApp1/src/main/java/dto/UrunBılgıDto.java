package dto;
import Domain.EnumBirim;
import Domain.EnumUrunTuru;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class UrunBılgıDto {
    private Long id;
    private String adi;
    private BigDecimal fiyat;
    private String urunTuruAdi;
    private EnumUrunTuru enumUrunTuru;

    public UrunBılgıDto(Long id, String adi, BigDecimal fiyat, String urunTuruAdi, EnumUrunTuru enumUrunTuru) {
        this.id = id;
        this.adi = adi;
        this.fiyat = fiyat;
        this.urunTuruAdi = urunTuruAdi;
        this.enumUrunTuru = enumUrunTuru;
    }

    @Override
    public String toString() {
        return "UrunBılgıDto{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", fiyat=" + fiyat +
                ", urunTuruAdi='" + urunTuruAdi + '\'' +
                ", enumUrunTuru=" + enumUrunTuru +
                '}';
    }
}
