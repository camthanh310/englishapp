/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import englishapp.models.NguoiDung;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.AlertDialog;
import util.KiemTraTextField;
/**
 * FXML Controller class
 *
 * @author thanhtieu
 */
public class FXMLDangKyController implements Initializable {

    @FXML
    private JFXTextField txtTenDangNhap;
    @FXML
    private JFXPasswordField txtMatKhau;
    @FXML
    private JFXTextField txtHo;
    @FXML
    private JFXTextField txtTen;
    @FXML
    private JFXButton btnDangKy;
    
    
    public void close(ActionEvent e){
        System.exit(0);
    }
    
    private SessionFactory factory;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.factory = HibernateUtil.getSessionFactory();
    }

    public void themNguoiDung(ActionEvent e){
        Session session = this.factory.openSession();
        
        String maNguoiDung = UUID.randomUUID().toString();
        String tenDangNhap = this.txtTenDangNhap.getText().trim();
        String matKhau = this.txtMatKhau.getText().trim();
        String ho = this.txtHo.getText().trim();
        String ten = this.txtTen.getText().trim();
        boolean loaiQuyen = false;
        NguoiDung nguoiDung = 
                new NguoiDung(maNguoiDung, tenDangNhap, 
                        matKhau, ho, ten, loaiQuyen);
        Transaction trans = session.beginTransaction();
        
        try {
            session.save(nguoiDung);
            trans.commit();
        }catch(HibernateException ex){
            trans.rollback();
        }
        
        session.close();
        
        
    }

    public void lamMoiNguoiDung(ActionEvent e){
        this.txtTen.setText("");
        this.txtHo.setText("");
        this.txtMatKhau.setText("");
        this.txtTenDangNhap.setText("");
    }
    
}
