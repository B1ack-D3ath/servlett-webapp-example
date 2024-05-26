import java.io.Serializable;

public class Ogrenci_01 implements Serializable {
    private String isimSoyisim;
    private Long ogrenciNo;

    public Ogrenci_01() {
        // yapilandirma
    }
    public void setIsimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }
    public String getIsimSoyisim() {
        return this.isimSoyisim;
    }
    public void setOgrenciNo(Long ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }
    public Long getOgrenciNo() {
        return this.ogrenciNo;
    }
}