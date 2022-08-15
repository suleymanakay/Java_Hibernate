package Domain;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
    @Entity
    @Data
    @Table(name = "Pojo_Table")
    public class Pojo {
        @TableGenerator(name = "Pojo_Table",table = "Pojo_Table",allocationSize = 1,initialValue = 1,pkColumnName = "ColumnName",
                valueColumnName = "Deger")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
        private Long Id;
        @Column(name = "name",length = 100,nullable = false)
        private String name;
        @Column(name = "Deger",precision = 15,scale = 2)
        private BigDecimal deger;
        @Column(name = "Tarih")
        @Temporal(TemporalType.DATE)
        private Date tarih;
        @Column(name = "Saat")
        @Temporal(TemporalType.TIME)
        private Date saat;
        @Column(name = "TarihSaat")
        @Temporal(TemporalType.TIMESTAMP)
        private Date tarihSaat;
        @Column(name = "BuyukString")
        private String buyukString;
        @Column(name = "BuyukBLob")
        private byte [] buyukBLOb;
        @Column(name = "BuyukCLob")
        private char [] buyukCLOb;


    }

