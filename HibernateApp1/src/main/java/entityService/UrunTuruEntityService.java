package entityService;

import Dao.UrunTuruDao;
import Domain.UrunTuru;
import dto.UrunBılgıDto;
import dto.UrunTuruDto;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class UrunTuruEntityService {
    private UrunTuruDao urunTuruDao;

    public UrunTuruEntityService() {
      urunTuruDao=new UrunTuruDao();
    }
    public List<UrunTuru> findAll(){
        return urunTuruDao.findAll();
    }
    public List<UrunTuru> findUrunTuruListesiByAdi(String adi, MatchMode matchMode){
        return urunTuruDao.findUrunTuruListesiByAdi(adi,matchMode);
    }
    public List<UrunTuru> findUrunTuruListByAdiWithCriteria(String adi, MatchMode matchMode){
        return urunTuruDao.findUrunTuruListesiByAdi(adi,matchMode);
    }
    public List<UrunTuruDto> findAllByUrunTuruDto(){
        return urunTuruDao.findAllByUrunTuruDto();
    }
    public List<UrunBılgıDto> findAllUrunBilgiDtoWithCriteria(){
        return urunTuruDao.findAllUrunBilgiDtoWithCriteria();
    }
    public List<UrunTuruDto> findAllUrunTuruDtoWithCriteria(){
        return urunTuruDao.findAllUrunTuruDtoWithCriteria();
    }
}
