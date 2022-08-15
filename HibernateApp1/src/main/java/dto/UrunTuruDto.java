package dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class UrunTuruDto {
    private Long id;
    private String adi;
    private BigDecimal minFiyat;
    private BigDecimal maxFiyat;
    private Double ortalamaFiyat;
    private Long toplamStokMiktari;
    private Long toplamStokSayisi;

    public UrunTuruDto(Long id, String adi, BigDecimal minFiyat, BigDecimal maxFiyat, Double ortalamaFiyat, Long toplamStokMiktari, Long toplamStokSayisi) {
        this.id = id;
        this.adi = adi;
        this.minFiyat = minFiyat;
        this.maxFiyat = maxFiyat;
        this.ortalamaFiyat = ortalamaFiyat;
        this.toplamStokMiktari = toplamStokMiktari;
        this.toplamStokSayisi = toplamStokSayisi;
    }

    @Override
    public String toString() {
        return "UrunTuruDto{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", minFiyat=" + minFiyat +
                ", maxFiyat=" + maxFiyat +
                ", ortalamaFiyat=" + ortalamaFiyat +
                ", toplamStokMiktari=" + toplamStokMiktari +
                ", toplamStokSayisi=" + toplamStokSayisi +
                '}';
    }
}
