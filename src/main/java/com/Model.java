package com;


import Firm.Firma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Model {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

   private Long id;
   private String nazwę;
   private LocalDate data;
   private String wystawienia;
   private LocalDate dataterminPłatności;
   private String kwota;
   private String nipFirmyWystawiającej;
   private String nipPłatnika;

   @ManyToOne(fetch = FetchType.LAZY)
   private Firma firma;
}
