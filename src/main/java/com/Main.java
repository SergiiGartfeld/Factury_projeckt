package com;

import Firm.Firma;
import Firm.FirmaDao;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Model st = new Model(null,"Bla", LocalDate.now(),"Wystawiono",LocalDate.now().plusMonths(1),"2000","3223-2323-444","1231-1231-333", null);
        Firma fm = new Firma(null, "Kluk", "al. Niepodległości","3211-1212-211", null);
        FacturaDao facturaDao = new FacturaDao();
        facturaDao.saveFactureIntoDataBase(st);
        System.out.println(facturaDao.getAllFacturyFromDataBase());
        FirmaDao firmaDao = new FirmaDao();
        //firmaDao.saveFactureIntoDataBase(fm);
        System.out.println(firmaDao.getAllFacturyFromDataBase());
    }
}
