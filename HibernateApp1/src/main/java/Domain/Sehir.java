package Domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Sehir",indexes ={
        @Index(name = "ındex",columnList = "Adı",unique = true),
}
)
public class Sehir {
    @SequenceGenerator(name = "sehir",sequenceName = "Sehir_Id_Seq")
    @Id
    @GeneratedValue(generator = "sehir",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long Id;
    @Column(name = "Adı",length = 100)
    private String name;
    @ManyToOne (
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Ulke.class
    )
   /* @JoinColumn(
            name = "Ulke",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "Fk_Sehir_Ulke",
                    value = ConstraintMode.CONSTRAINT,
                    foreignKeyDefinition = "UNIQUE(ID)"
            )
    )

    */
    private Ulke ulke;
}
