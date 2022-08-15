package dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class UrunDto {
    private Long id;
    private String adi;
    private BigDecimal fiyat;

    public UrunDto(Long id, String adi, BigDecimal fiyat) {
        this.id = id;
        this.adi = adi;
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "UrunDto{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
