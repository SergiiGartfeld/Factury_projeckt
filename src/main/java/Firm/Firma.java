package Firm;


import com.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nazwę;
    private String adres;

    private String nipFirmy;


    @OneToMany(fetch = FetchType.EAGER)
    private List<Model>faktury;


}

