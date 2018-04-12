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
@Table(name="dap_an")
public class DapAn {

    /**
     * @return the maDapAn
     */
    public String getMaDapAn() {
        return maDapAn;
    }

    /**
     * @param maDapAn the maDapAn to set
     */
    public void setMaDapAn(String maDapAn) {
        this.maDapAn = maDapAn;
    }

    /**
     * @return the dapAn
     */
    public String getDapAn() {
        return dapAn;
    }

    /**
     * @param dapAn the dapAn to set
     */
    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    /**
     * @return the maCauHoi
     */
    public CauHoi getMaCauHoi() {
        return maCauHoi;
    }

    /**
     * @param maCauHoi the maCauHoi to set
     */
    public void setMaCauHoi(CauHoi maCauHoi) {
        this.maCauHoi = maCauHoi;
    }
    @Id
    @Column (name = "ma_dap_an")
    private String maDapAn;
    @Column (name = "dap_an")
    private String dapAn;
    @OneToOne
    @JoinColumn (name = "ma_cau_hoi")
    private CauHoi maCauHoi;
    
    public DapAn(){
    }
    
    public DapAn(String maDapAn, String dapAn, CauHoi maCauHoi){
        this.maDapAn = maDapAn;
        this.dapAn = dapAn;
        this.maCauHoi = maCauHoi;
    }
    
    @Override
    public String toString() {
        return this.dapAn;
    }
    
}
