package Dao;

import Domain.Urun;
import Domain.UrunTuru;
import Hibernate.HibernateUtil;
import dto.UrunBılgıDto;
import dto.UrunTuruDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

public class UrunTuruDao {
    private SessionFactory sessionFactory;

    public UrunTuruDao() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }
    public List<UrunTuru> findAll(){
        Session session=sessionFactory.openSession();
        Query query= session.createQuery("select urunTuru from UrunTuru urunTuru");
        return query.list();
    }
    public UrunTuru findById(Long id){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery(
                "select urunTuru from UrunTuru urunTuru "+
                " where id= :id");
        query.setParameter("id",id);
        return (UrunTuru) query.uniqueResult();
    }
    public List<UrunTuru> findUrunTuruListesiByAdi(String adi, MatchMode matchMode){
        Session session=sessionFactory.openSession();
        Query query= session.createQuery(
                "select urunTuru from UrunTuru urunTuru "+
                        "where name like: adi"
        );
        switch (matchMode){
            case EXACT:
                query.setParameter("adi",adi);
                break;
            case START:
                query.setParameter("adi",adi+"%");
                break;
            case ANYWHERE:
                query.setParameter("adi","%"+adi+"%");
                break;
            case END:
                query.setParameter("adi","%"+adi);
        }
        return query.list();
    }
    public List<UrunTuruDto> findAllByUrunTuruDto(){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery(
                "select new dto.UrunTuruDto(urunTuru.id" +
                        ",urunTuru.name" +
                        ",min(urun.fiyat)," +
                        "max(urun.fiyat)," +
                        "avg (urun.fiyat)," +
                        "sum(urun.stockMiktari)," +
                        "count (urun.id))"+
                "from Urun urun, UrunTuru urunTuru"+
                        " where urun.urunTuru.id=urunTuru.id"+
                        " group by urunTuru.id,urunTuru.name");

                return query.list();
    }
    public List<UrunBılgıDto> findAllUrunBilgiDtoWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<UrunBılgıDto> query = criteriaBuilder.createQuery(UrunBılgıDto.class);

        Root<Urun> root = query.from(Urun.class);

        root.join("urunTuru", JoinType.INNER);

        query.select(criteriaBuilder.construct(
                UrunBılgıDto.class,
                root.get("id"),
                root.get("name"),
                root.get("fiyat"),
                root.get("urunTuru").get("name"),
                root.get("urunTuru").get("urunTuru")
        ));

        return session.createQuery(query).list();
    }
    public List<UrunTuruDto> findAllUrunTuruDtoWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<UrunTuruDto> query = criteriaBuilder.createQuery(UrunTuruDto.class);

        Root<Urun> root = query.from(Urun.class);

        root.join("urunTuru", JoinType.INNER);

        query.groupBy(root.get("urunTuru").get("id"),root.get("urunTuru").get("name"));

        query.select(criteriaBuilder.construct(UrunTuruDto.class,
                root.get("urunTuru").get("id"),
                root.get("urunTuru").get("name"),
                criteriaBuilder.min(root.<Number>get("fiyat")),
                criteriaBuilder.max(root.<Number>get("fiyat")),
                criteriaBuilder.avg(root.<Number>get("fiyat")),
                criteriaBuilder.sum(root.<Number>get("stockMiktari")),
                criteriaBuilder.count(root.get("id"))
        ));

        return session.createQuery(query).list();

    }
}
