package Dao;

import Domain.EnumBirim;
import Domain.Urun;
import Domain.UrunTuru;
import Hibernate.HibernateUtil;
import dto.UrunBılgıDto;
import dto.UrunDto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.crypto.SealedObject;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UrunDao {
    private SessionFactory sessionFactory;

    public UrunDao() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }
    public List<Urun> findAll(){
        Session session=sessionFactory.openSession();
        Query query= session.createQuery("select urun from Urun urun");
        return query.list();
    }
    public List<Urun> findAllWithOrder() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select urun from Urun urun" +
                " order by stockMiktari,name");

        return query.list();
    }

        public List<Urun> findAllWithOrderLimit (int maxResult) {
            Session session1 = sessionFactory.openSession();
            Query query1 = session1.createQuery("select urun from Urun urun" +
                    " order by stockMiktari desc ,name desc ");

            query1.setMaxResults(maxResult);

            return query1.list();
        }
    public List<Urun> findAllByDate(Date sonKullanmaTarihi) {
        Session session1 = sessionFactory.openSession();
        Query query1 = session1.createQuery("select urun from Urun urun" +
                " where sonKullanmaTarihi >= :sonKullanmaTaihi ");

        query1.setParameter("sonKullanmaTaihi",sonKullanmaTarihi);

        return query1.list();
    }
    public Long sumUrunStockMiktarıBYrunTuruId(Long urunTuruId){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("select sum(stockMiktari) from Urun urun"
        +" where urunTuru.id =:urunTuruId");
        query.setParameter("urunTuruId",urunTuruId);
        return (Long) query.uniqueResult();
    }
    public Long countUrunBYurunTuruId(Long urunTuruId){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("select count(urun) from Urun urun"
                +" where urunTuru.id =:urunTuruId");
        query.setParameter("urunTuruId",urunTuruId);
        return (Long) query.uniqueResult();
    }
    public List<EnumBirim> findAllUrunStokBirim(){
        Session session1 = sessionFactory.openSession();
        Query query1 = session1.createQuery("select distinct(stockBirim) from Urun urun");
        return query1.list();
    }


    public Double ortalamaUrunMiktari(){
        Session session1 = sessionFactory.openSession();
        Query query1 = session1.createQuery("select avg(stockMiktari) from Urun urun");
        return (Double) query1.uniqueResult();
    }

    public List<UrunDto> findAllUrunDto(){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("select "+
                " new dto.UrunDto(urun.id,urun.name,urun.fiyat)"+
                "from Urun urun");
        return query.list();
    }
    public List<UrunBılgıDto> findByUrunBılgıDto(){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("select "+"" +
                "new dto.UrunBılgıDto( urun.id,urun.name,urun.fiyat,urunTuru.name,urunTuru.urunTuru )"+
                "from Urun urun,UrunTuru urunTuru"+
                " where urun.urunTuru.id=urunTuru.id ");
        return query.list();
    }
    public BigDecimal findMinFiyat(){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("select min(urun.fiyat) from Urun urun");
        return (BigDecimal) query.uniqueResult();
    }
    public BigDecimal findMaxFiyat(){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("select max (urun.fiyat) from Urun urun");
        return (BigDecimal) query.uniqueResult();
    }
    public List<Urun> callUrunFindAll(){
        Session session=sessionFactory.openSession();
      NativeQuery<Urun> nativeQuery= session.createNativeQuery("{call urun_findAll()}",Urun.class);
      return nativeQuery.list();

    }
    public List<Urun> callUrunFindAll1(){
        Session session=sessionFactory.openSession();
        StoredProcedureQuery nativeQuery= session.createStoredProcedureQuery(" urun_findAll()",Urun.class);
        return nativeQuery.getResultList();

    }
    public List<Urun> findUrunByBetweenMinAndMax(BigDecimal min,BigDecimal max){
        Session session=sessionFactory.openSession();
        NativeQuery<Urun> nativeQuery=session.createNativeQuery(" {call find_urun_between(:minimum,:maximum)}");
        nativeQuery.setParameter("minimum",min);
        nativeQuery.setParameter("maximum",max);
        return nativeQuery.list();

    }
    public List<Urun> findWithCriteria(){
        Session session=sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Urun> urunCriteriaQuery=criteriaBuilder.createQuery(Urun.class);
        urunCriteriaQuery.from(Urun.class);
        return session.createQuery(urunCriteriaQuery).getResultList();
    }
    public Urun findByIdWithCriteria(Long id){
        Session session=sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Urun> urunCriteriaQuery=criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root=urunCriteriaQuery.from(Urun.class);
        urunCriteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"),id));
        return  session.createQuery(urunCriteriaQuery).uniqueResult();
    }
    public List<Urun> findAllUrunListByStokMiktariMinAndMaxWithCriteria(Long minStok, Long maxStok){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(root).where(
                criteriaBuilder.between(root.get("stockMiktari"), minStok,maxStok)
        );

        return session.createQuery(query).list();
    }
    public List<UrunTuru> findUrunTuruListByAdiWithCriteria(String adi, MatchMode matchMode){

        String parameter = "";
        switch (matchMode){
            case EXACT:
                parameter = adi;
                break;

            case START:
                parameter = adi + "%";
                break;

            case END:
                parameter = "%" + adi;
                break;

            case ANYWHERE:
                parameter = "%" + adi + "%";
                break;
        }

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<UrunTuru> query = criteriaBuilder.createQuery(UrunTuru.class);

        Root<UrunTuru> root = query.from(UrunTuru.class);

        query.select(root).where(criteriaBuilder.like(root.<String>get("adi"), parameter));

        return session.createQuery(query).list();
    }
    public List<Urun> findAllWithOrderWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(root);
        // tekli
        /*
       query.orderBy(criteriaBuilder.asc(root.get("stokMiktari")));

       Order stokMiktari = criteriaBuilder.asc(root.get("stokMiktari"));
       Order adi = criteriaBuilder.asc(root.get("adi"));
       query.orderBy(stokMiktari, adi);

         */
        List<Order> orderList = new ArrayList<>();
        orderList.add(criteriaBuilder.asc(root.get("stockMiktari")));
        orderList.add(criteriaBuilder.asc(root.get("name")));
        query.orderBy(orderList);

        return session.createQuery(query).list();
    }
    public List<Urun> findAllWithOrderByLimitWithCriteria(int maxResult){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(root);

        query.orderBy(criteriaBuilder.asc(root.get("id")));

        return session.createQuery(query).setMaxResults(maxResult).list();
    }
    public List<Urun> findAllUrunListBySonKullanmaTarihiGeWithCriteria(Date sonKullanmaTarihi){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        ParameterExpression<Date> parameter = criteriaBuilder.parameter(Date.class);

        Predicate tarih = criteriaBuilder.greaterThanOrEqualTo(root.<Comparable>get("sonKullanmaTarihi").as(Date.class), parameter);

        query.where(tarih);

        return session.createQuery(query).setParameter(parameter, sonKullanmaTarihi, TemporalType.DATE).list();
    }
    public Long sumUrunStokMiktariByUrunTuruIdWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.sumAsLong(root.<Integer>get("stockMiktari")));

        return session.createQuery(query).uniqueResult();
    }
    public Long countUrunByUrunTuruIdWithCriteria(Long urunTuruId){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.count(root.get("id")));

        query.where(criteriaBuilder.equal(
                root.get("urunTuru").get("id"), urunTuruId
        ));

        return session.createQuery(query).uniqueResult();
    }
    public BigDecimal findMinUrunFiyatWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.min(root.<BigDecimal>get("fiyat")));

        return session.createQuery(query).uniqueResult();

    }

    public BigDecimal findMaxUrunFiyatWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.max(root.<BigDecimal>get("fiyat")));

        return session.createQuery(query).uniqueResult();
    }
    public Double findOrtalamaStokMiktariWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.avg(root.<Number>get("stockMiktari")));

        return session.createQuery(query).uniqueResult();

    }
    public List<UrunDto> findAllUrunDtoWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<UrunDto> query = criteriaBuilder.createQuery(UrunDto.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.construct(UrunDto.class,
                root.get("id"),
                root.get("name"),
                root.get("fiyat")
        ));

        return session.createQuery(query).list();
    }
    }

