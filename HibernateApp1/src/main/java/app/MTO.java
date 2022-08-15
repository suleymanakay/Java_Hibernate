package app;

import Domain.Sehir;
import Domain.Ulke;
import Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MTO {
    public static void main(String[] args) {
        Ulke ulke=new Ulke();
        ulke.setName("Turkiye");

        Sehir sehir=new Sehir();
        sehir.setName("Batman");

        sehir.setUlke(ulke);

        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.merge(sehir);
        transaction.commit();
    }
}
