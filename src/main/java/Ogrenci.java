import java.io.Serializable;
public class Ogrenci implements Serializable {
    private String ad;
    public Ogrenci() {
    }
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
}