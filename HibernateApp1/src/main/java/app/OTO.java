package app;

import Domain.Kisi;
import Domain.Parmakİzi;
import Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OTO {
    public static void main(String[] args) {
        Kisi kisi=new Kisi();
        kisi.setName("ahmet");
        Parmakİzi parmakİzi = new Parmakİzi();
        parmakİzi.setDosyaNo("4aB7");
        parmakİzi.setKisi(kisi);
        kisi.setParmakİzi(parmakİzi.getKisi().getParmakİzi());
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        parmakİzi= (Parmakİzi) session.merge(parmakİzi);
        transaction.commit();

    }}

