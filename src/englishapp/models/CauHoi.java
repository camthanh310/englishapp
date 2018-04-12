/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp.models;
import javax.persistence.*;
/**
 *
 * @author thanhtieu
 */
@Entity
@Table(name = "cau_hoi")
public class CauHoi {

    /**
     * @return the maCauHoi
     */
    public String getMaCauHoi() {
        return maCauHoi;
    }

    /**
     * @param maCauHoi the maCauHoi to set
     */
    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    /**
     * @return the cauHoi
     */
    public String getCauHoi() {
        return cauHoi;
    }

    /**
     * @param cauHoi the cauHoi to set
     */
    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    /**
     * @return the maDapAn
     */
    public DapAn getMaDapAn() {
        return maDapAn;
    }

    /**
     * @param maDapAn the maDapAn to set
     */
    public void setMaDapAn(DapAn maDapAn) {
        this.maDapAn = maDapAn;
    }
    @Id
    @Column(name = "ma_cau_hoi")
    private String maCauHoi;
    @Column(name = "cau_hoi")
    private String cauHoi;
    @OneToOne
    @JoinColumn(name = "ma_dap_an")
    private DapAn maDapAn;
    
    public CauHoi(){
    }
    
    public CauHoi(String maCauHoi, String cauHoi, DapAn maDapAn){
        this.maCauHoi = maCauHoi;
        this.cauHoi = cauHoi;
        this.maDapAn = maDapAn;
    }

    @Override
    public String toString() {
        return this.cauHoi;
    }
    
    
    
}
