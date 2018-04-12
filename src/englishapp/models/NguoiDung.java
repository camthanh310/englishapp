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
@Table(name = "nguoi_dung")
public class NguoiDung {

    /**
     * @return the maNguoiDung
     */
    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    /**
     * @param maNguoiDung the maNguoiDung to set
     */
    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    /**
     * @return the tenDangNhap
     */
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    /**
     * @param tenDangNhap the tenDangNhap to set
     */
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    /**
     * @return the matKhau
     */
    public String getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    /**
     * @return the ho
     */
    public String getHo() {
        return ho;
    }

    /**
     * @param ho the ho to set
     */
    public void setHo(String ho) {
        this.ho = ho;
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the loaiQuyen
     */
    public boolean isLoaiQuyen() {
        return loaiQuyen;
    }

    /**
     * @param loaiQuyen the loaiQuyen to set
     */
    public void setLoaiQuyen(boolean loaiQuyen) {
        this.loaiQuyen = loaiQuyen;
    }
    @Id
    @Column(name = "ma_nguoi_dung")
    private String maNguoiDung;
    @Column(name = "ten_dang_nhap", length = 50, nullable = false)
    private String tenDangNhap;
    @Column(name = "mat_khau", length= 50, nullable = false)
    private String matKhau;
    @Column(name = "ho_va_ten_lot", length = 100, nullable = false)
    private String ho;
    @Column(name = "ten", length = 100, nullable = false)
    private String ten;
    @Column(name = "loai_quyen")
    private boolean loaiQuyen;
    
    public NguoiDung(){
        
    }
    
    public NguoiDung(String maNguoiDung, String tenDangNhap, String matKhau, 
            String ho, String ten, boolean loaiQuyen){
        this.maNguoiDung = maNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.ho = ho;
        this.ten = ten;
        this.loaiQuyen = loaiQuyen;
    }
    
    public String loaiQuyenView(){
        if(this.loaiQuyen == true)
            return "1";
        else
            return "0";
    }
}
