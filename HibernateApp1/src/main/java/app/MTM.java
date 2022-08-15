package app;

import Domain.Kitap;
import Domain.Yazar;
import Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MTM {
    public static void main(String[] args) {
        Kitap kitaplar=new Kitap();
        kitaplar.setName("Sefiller");
        Yazar yazar=new Yazar();
        yazar.setName("Victor Hugo");

        kitaplar.getYazarlar().add(yazar.getName());
        yazar.getKitaplar().add(kitaplar);

        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        kitaplar= (Kitap) session.merge(kitaplar);
        transaction.commit();

    }
}
