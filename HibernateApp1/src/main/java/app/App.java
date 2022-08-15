package app;

import Domain.Urun;
import Domain.UrunTuru;
import dto.UrunBılgıDto;
import dto.UrunDto;
import dto.UrunTuruDto;
import entityService.UrunEntityService;
import entityService.UrunTuruEntityService;
import org.hibernate.criterion.MatchMode;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        /*
        //Urun Turu listesini getirir.
        UrunTuruEntityService urunTuruEntityService=new UrunTuruEntityService();
        List<UrunTuru> urunTuruList=urunTuruEntityService.findAll();
        for (UrunTuru urunTuru :urunTuruList) {
            System.out.println(urunTuru.getName());
        }

         */
        /*
        //Urun listesini getirir
        UrunEntityService urunEntityService=new UrunEntityService();
        List<Urun> urunList=urunEntityService.findAll();
        for (Urun urun :urunList) {
            System.out.println(urun.getName());
        }

         */
        //Like kullanımı
        /*UrunTuruEntityService urunTuruEntityService=new UrunTuruEntityService();
       List<UrunTuru> urunTuruList=urunTuruEntityService.findUrunTuruListesiByAdi("ecek", MatchMode.ANYWHERE
       );
        for (UrunTuru urunTuru:urunTuruList) {
            System.out.println(urunTuru.getName());
        }

         */
        /*
        //Order By kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        List<Urun> urunList=urunEntityService.findAllWithOrder();
        for (Urun urun:urunList) {
            System.out.println(urun.getName()+"--"+urun.getStockMiktari());
        }
         */
        /*
        //Limit kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        List<Urun> urunList=urunEntityService.findAllWithOrderLimit(4);
        for (Urun urun:urunList) {
            System.out.println(urun.getName()+"--"+urun.getStockMiktari());
        }

         */
/*
        //Date(Tarih) Kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       Date sonKullanmaTarihi=null;
        try {
            sonKullanmaTarihi= (Date) sdf.parse("2022-07-20");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<Urun> urunList=urunEntityService.findAllByDate(sonKullanmaTarihi);
        for (Urun urun:urunList) {
            System.out.println(urun.getName()+"--"+sdf.format(sonKullanmaTarihi));
        }*/
        /*
        //Sum Kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        Long urunListSum=urunEntityService.sumUrunStockMiktarıBYrunTuruId(1L);
        System.out.println(urunListSum);

         */
        /*
        //Count kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        Long urunListCount=urunEntityService.countUrunBYurunTuruId(1L);
        System.out.println(urunListCount);

         */
        /*
        //Dıstınct kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        List<EnumBirim> urunListEnum=urunEntityService.findAllUrunStokBirim();
        for (EnumBirim enumBirim:urunListEnum) {
            System.out.println(enumBirim.getTuru());
        }
         */
/*
        //AVG kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        Double ortalamaUrunMiktari=urunEntityService.ortalamaUrunMiktari();
        System.out.println(ortalamaUrunMiktari);

 */
        /*
        //Projection kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        List<UrunDto> urunListEnum=urunEntityService.findAllUrunDto();
        for (UrunDto urunDto:urunListEnum) {
            System.out.println(urunDto.getAdi()+"--"+urunDto.getId()+"--"+urunDto.getFiyat());
        }
         */
        /*
        //Join Kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        List<UrunBılgıDto> urunBılgıDtosr=urunEntityService.findByUrunBılgıDto();
        for (UrunBılgıDto urunBılgıDto:urunBılgıDtosr) {
            System.out.println(urunBılgıDto);
        }
         */
        /*
        //min Kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        BigDecimal minfiyat=urunEntityService.findMinFiyat();
        System.out.println(minfiyat);

        //max Kullanımı
        UrunEntityService urunEntityService1=new UrunEntityService();
        BigDecimal maxfiyat=urunEntityService1.findMaxFiyat();
        System.out.println(maxfiyat);

         */
        /*
        //Group By kullanımı
        UrunTuruEntityService urunTuruEntityServiceru=new UrunTuruEntityService();
        List<UrunTuruDto> urunTuruEntityServiceruAllByUrunTuruDto=urunTuruEntityServiceru.findAllByUrunTuruDto();
        for (UrunTuruDto urunTuru:urunTuruEntityServiceruAllByUrunTuruDto) {
            System.out.println(urunTuru);
        }

         */

        /*
        //Stored Procedure non-parameters(native query ile veri tabanı sorgusu çağırma )
        UrunEntityService urunEntityService=new UrunEntityService();
        List<Urun> urun=urunEntityService.callUrunFindAll();
        for (Urun urunBılgıDto:urun) {
            System.out.println(urunBılgıDto);
        }

         */
        /*
        //stored porcedure ile between kullanımı
        UrunEntityService urunEntityService=new UrunEntityService();
        BigDecimal min =new BigDecimal(100);
        BigDecimal max =new BigDecimal(14000);
        List<Urun> urun=urunEntityService.findUrunByBetweenMinAndMax(min,max);
        for (Urun urun1:urun) {
            System.out.println(urun1);
        }
         */
        /*
        //Stored Procedure storedQuery ile çalıştırıldı.
        UrunEntityService urunEntityService=new UrunEntityService();
        List<Urun> urun=urunEntityService.callUrunFindAll1();
        for (Urun urunBılgıDto:urun) {
            System.out.println(urunBılgıDto);
        }
         */
        /*
        //criteriabuilder kullanılaraksql sorgusu olmadan urun verisinin adlarını  çekmek.
        UrunEntityService urunEntityService = new UrunEntityService();
        List<Urun> urun = urunEntityService.findWithCriteria();
        for (Urun urunBılgıDto : urun) {
            System.out.println(urunBılgıDto.getName());
        }

         */
        /*
        // Criteria ile ıdye göre sql yazmadan veri tabanından ismini çekmek.
        UrunEntityService urunEntityService = new UrunEntityService();
      Urun urun =  urunEntityService.findByIdWithCriteria(1L);
        System.out.println(urun.getName());
         */
        /*
        //criteria ya göre Between ile min-max veri getirme
        UrunEntityService urunEntityService = new UrunEntityService();
        List<Urun> urun = urunEntityService.findAllUrunListByStokMiktariMinAndMaxWithCriteria(100L,1000L);
        for (Urun urunBılgıDto : urun) {
            System.out.println(urunBılgıDto.getName());
        }

         */
        /*
       //Criteria ile like kullanımı...
        UrunTuruEntityService urunTuruEntityService=new UrunTuruEntityService();
        List<UrunTuru> urunTuruList=urunTuruEntityService.findUrunTuruListesiByAdi("Y", MatchMode.START);
        for (UrunTuru urunTuru :urunTuruList) {
            System.out.println(urunTuru.getName());
        }

         */
        /*
        //Criteria ile orderby kullanılarak name ve stock miktarını getirip sıralar.
        UrunEntityService urunTuruEntityService=new UrunEntityService();
        List<Urun> urunTuruList=urunTuruEntityService.findAllWithOrderWithCriteria();
        for (Urun urunTuru :urunTuruList) {
            System.out.println(urunTuru.getName()+"--"+urunTuru.getStockMiktari());
        }

         */

        /*
        //criteria ile limit kullanımı...
        UrunEntityService urunTuruEntityService=new UrunEntityService();
        List<Urun> urunTuruList=urunTuruEntityService.findAllWithOrderByLimitWithCriteria(3);
        for (Urun urunTuru :urunTuruList) {
            System.out.println(urunTuru.getName()+"--"+urunTuru.getStockMiktari());
        }

         */
        /*
        //Criteria ile Tarih kullanımı ...(sql sorgusu olmadan)..
        UrunEntityService urunEntityService=new UrunEntityService();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date sonKullanmaTarihi=null;
        try {
            sonKullanmaTarihi= sdf.parse("2022-07-20");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<Urun> urunList=urunEntityService.findAllUrunListBySonKullanmaTarihiGeWithCriteria(sonKullanmaTarihi);
        for (Urun urun:urunList) {
            System.out.println(urun.getName()+"--"+sdf.format(sonKullanmaTarihi));
        }

         */
        /*
        //Criteria ile sum kullanımı (sql sorgusu olmadan)
        UrunEntityService urunTuruEntityService=new UrunEntityService();
       Long urunTuruList=urunTuruEntityService.sumUrunStokMiktariByUrunTuruIdWithCriteria();
        System.out.println(urunTuruList);

         */
        /*
        //Criteri ile count kullanımı sql sorgusu olmadan
        UrunEntityService urunTuruEntityService=new UrunEntityService();
        Long urunTuruList=urunTuruEntityService.countUrunByUrunTuruIdWithCriteria(2L);
        System.out.println(urunTuruList);
         */

        /*
        //Crtieria ile min-max değeri getirme
        UrunEntityService urunTuruEntityService=new UrunEntityService();
        BigDecimal min=urunTuruEntityService.findMinUrunFiyatWithCriteria();
        BigDecimal max=urunTuruEntityService.findMaxUrunFiyatWithCriteria();
        System.out.println(min);
        System.out.println(max);

         */
        /*
        //Criteria ile AVG...
        UrunEntityService urunTuruEntityService=new UrunEntityService();
        Double aDouble=urunTuruEntityService.findOrtalamaStokMiktariWithCriteria();
        System.out.println(aDouble);
         */
        /*
        //Criteria ile Projection kullanımı
        UrunEntityService urunTuruEntityService=new UrunEntityService();
        List<UrunDto> urunDtos=urunTuruEntityService.findAllUrunDtoWithCriteria();
        for (UrunDto urunDto:urunDtos) {
            System.out.println(urunDto.getId()+"--"+urunDto.getAdi()+"--"+urunDto.getFiyat());
        }
         */

        /*
        //Criteria ile Join kullanımı....
        UrunTuruEntityService urunTuruEntityService=new UrunTuruEntityService();
        List<UrunBılgıDto> urunBılgıDtos=urunTuruEntityService.findAllUrunBilgiDtoWithCriteria();
        for (UrunBılgıDto urunBılgıDto:urunBılgıDtos
        ) {
            System.out.println(urunBılgıDto);
        }
         */
        //Criteria ile Group By kullanımı
        UrunTuruEntityService urunTuruEntityService=new UrunTuruEntityService();
        List<UrunTuruDto> urunTuruDtos=urunTuruEntityService.findAllUrunTuruDtoWithCriteria();
        for (UrunTuruDto urunTuruDto:urunTuruDtos
             ) {
            System.out.println(urunTuruDto);
        }

    }
}
