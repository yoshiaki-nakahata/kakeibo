package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "kakeibos")
@NamedQueries({
    @NamedQuery(
            name = "getAllKakeibos",
            query = "SELECT k FROM Kakeibo AS k ORDER BY k.id DESC"
            ),
    @NamedQuery(
            name = "getKakeibosCount",
            query = "SELECT COUNT(k) FROM Kakeibo AS k"
            )
})
@Entity
public class Kakeibo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kakeibo_date", nullable = false)
    private Date kakeibo_date;


    @Column(name = "syokuhi", length = 255, nullable = false)
    private String syokuhi;

    @Column(name = "nitiyouhin", length = 255, nullable = false)
    private String nitiyouhin;

    @Column(name = "kousai", length = 255, nullable = false)
    private String kousai;

    @Column(name = "biyou", length = 255, nullable = false)
    private String biyou;

    @Column(name = "koutuu", length = 255, nullable = false)
    private String koutuu;

    @Column(name = "iryou", length = 255, nullable = false)
    private String iryou;

    @Column(name = "tuusin", length = 255, nullable = false)
    private String tuusin;

    @Column(name = "suidou", length = 255, nullable = false)
    private String suidou;

    @Column(name = "denki", length = 255, nullable = false)
    private String denki;

    @Column(name = "gasu", length = 255, nullable = false)
    private String gasu;


    @Column(name = "yatin", length = 255, nullable = false)
    private String yatin;

    @Column(name = "zeikin", length = 255, nullable = false)
    private String zeikin;

    @Column(name = "hoken", length = 255, nullable = false)
    private String hoken;

    @Column(name = "sonota", length = 255, nullable = false)
    private String sonota;




    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Date getKakeibo_date() {
        return kakeibo_date;
    }

    public void setKakeibo_date(Date kakeibo_date) {
        this.kakeibo_date = kakeibo_date;
    }

    public String getSyokuhi() {
        return syokuhi;
    }

    public void setSyokuhi(String syokuhi) {
        this.syokuhi = syokuhi;
    }

    public String getNitiyouhin() {
        return nitiyouhin;
    }

    public void setNitiyouhin(String nitiyouhin) {
        this.nitiyouhin = nitiyouhin;
    }

    public String getKousai() {
        return kousai;
    }

    public void setKousai(String kousai) {
        this.kousai = kousai;
    }

    public String getBiyou() {
        return biyou;
    }

    public void setBiyou(String biyou) {
        this.biyou = biyou;
    }

    public String getKoutuu() {
        return koutuu;
    }

    public void setKoutuu(String koutuu) {
        this.koutuu = koutuu;
    }

    public String getIryou() {
        return iryou;
    }

    public void setIryou(String iryou) {
        this.iryou = iryou;
    }

    public String getTuusin() {
        return tuusin;
    }

    public void setTuusin(String tuusin) {
        this.tuusin = tuusin;
    }

    public String getSuidou() {
        return suidou;
    }

    public void setSuidou(String suidou) {
        this.suidou = suidou;
    }

    public String getDenki() {
        return denki;
    }

    public void setDenki(String denki) {
        this.denki = denki;
    }

    public String getGasu() {
        return gasu;
    }

    public void setGasu(String gasu) {
        this.gasu = gasu;
    }

    public String getYatin() {
        return yatin;
    }

    public void setYatin(String yatin) {
        this.yatin = yatin;
    }

    public String getZeikin() {
        return zeikin;
    }

    public void setZeikin(String zeikin) {
        this.zeikin = zeikin;
    }

    public String getHoken() {
        return hoken;
    }

    public void setHoken(String hoken) {
        this.hoken = hoken;
    }
    public String getSonota() {
        return sonota;
    }

    public void setSonota(String sonota) {
        this.sonota = sonota;
    }


    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}