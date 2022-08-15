package app;

import Domain.Sehir;
import Domain.Ulke;
import Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OTM {
    public static void main(String[] args) {
        Ulke ulke=new Ulke();
        ulke.setName("Turkiye");

        Sehir sehir=new Sehir();
        sehir.setName("İstanbul");
        sehir.setUlke(ulke);

        Sehir sehir1=new Sehir();
        sehir1.setName("İzmir");
        sehir1.setUlke(ulke);

        ulke.getSehirler().add(sehir);
        ulke.getSehirler().add(sehir1);

        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(ulke);
        transaction.commit();
}}
