package entityService;

import Dao.UrunDao;
import Domain.EnumBirim;
import Domain.Urun;
import dto.UrunBılgıDto;
import dto.UrunDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UrunEntityService {
    private UrunDao urunDao;

    public UrunEntityService() {
        urunDao=new UrunDao();
    }
    public List<Urun> findAll(){
        return urunDao.findAll();
    }
    public List<Urun> findAllWithOrder(){
        return urunDao.findAllWithOrder();
    }
    public List<Urun> findAllWithOrderLimit (int maxResult) {
        return urunDao.findAllWithOrderLimit(maxResult);
    }
    public List<Urun> findAllByDate(Date sonKullanmaTarihi) {
        return urunDao.findAllByDate(sonKullanmaTarihi);
    }
    public Long sumUrunStockMiktarıBYrunTuruId(Long urunTuruId){
        return urunDao.sumUrunStockMiktarıBYrunTuruId(urunTuruId);
    }
    public Long countUrunBYurunTuruId(Long urunTuruId){
        return urunDao.countUrunBYurunTuruId(urunTuruId);
    }
    public List<EnumBirim> findAllUrunStokBirim(){
        return urunDao.findAllUrunStokBirim();
    }
    public Double ortalamaUrunMiktari(){
        return urunDao.ortalamaUrunMiktari();
    }
    public List<UrunDto> findAllUrunDto(){
        return urunDao.findAllUrunDto();

    }
    public List<UrunBılgıDto> findByUrunBılgıDto(){
        return urunDao.findByUrunBılgıDto();
    }
    public BigDecimal findMinFiyat(){
        return urunDao.findMinFiyat();
    }
    public BigDecimal findMaxFiyat(){
        return urunDao.findMaxFiyat();
    }
    public List<Urun> callUrunFindAll(){
        return urunDao.callUrunFindAll();
    }
    public List<Urun> findUrunByBetweenMinAndMax(BigDecimal min,BigDecimal max){
        return urunDao.findUrunByBetweenMinAndMax(min,max);
    }
    public List<Urun> callUrunFindAll1(){
        return urunDao.callUrunFindAll1();
    }
    public List<Urun> findWithCriteria() {
        return urunDao.findWithCriteria();
    }
    public Urun findByIdWithCriteria(Long id){
        return urunDao.findByIdWithCriteria(id);
    }
    public List<Urun> findAllUrunListByStokMiktariMinAndMaxWithCriteria(Long minStok, Long maxStok){
        return urunDao.findAllUrunListByStokMiktariMinAndMaxWithCriteria(minStok,maxStok);
    }
    public List<Urun> findAllWithOrderWithCriteria(){
        return urunDao.findAllWithOrderWithCriteria();
    }
    public List<Urun> findAllWithOrderByLimitWithCriteria(int maxResult){
        return urunDao.findAllWithOrderByLimitWithCriteria(maxResult);
    }
    public List<Urun> findAllUrunListBySonKullanmaTarihiGeWithCriteria(Date sonKullanmaTarihi){
        return urunDao.findAllUrunListBySonKullanmaTarihiGeWithCriteria(sonKullanmaTarihi);
    }
    public Long sumUrunStokMiktariByUrunTuruIdWithCriteria(){
        return urunDao.sumUrunStokMiktariByUrunTuruIdWithCriteria();
    }
    public Long countUrunByUrunTuruIdWithCriteria(Long urunTuruId){
    return urunDao.countUrunByUrunTuruIdWithCriteria(urunTuruId);
    }
    public BigDecimal findMinUrunFiyatWithCriteria(){
        return urunDao.findMinUrunFiyatWithCriteria();
    }
    public BigDecimal findMaxUrunFiyatWithCriteria(){
        return urunDao.findMaxUrunFiyatWithCriteria();
    }
    public Double findOrtalamaStokMiktariWithCriteria(){
        return urunDao.findOrtalamaStokMiktariWithCriteria();
    }
    public List<UrunDto> findAllUrunDtoWithCriteria(){
        return urunDao.findAllUrunDtoWithCriteria();
    }
    }

