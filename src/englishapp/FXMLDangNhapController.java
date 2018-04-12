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
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * FXML Controller class
 *
 * @author thanhtieu
 */
public class FXMLDangNhapController implements Initializable {

    @FXML
    private JFXTextField txtTenDangNhap;
    @FXML
    private JFXPasswordField txtMatKhau;
    
    
    public void thoat(ActionEvent e){
        System.exit(0);
    }
    
    private SessionFactory factory; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.factory = HibernateUtil.getSessionFactory();
        
    }
    
    
    
    public void dangNhap(ActionEvent e) throws IOException{
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(NguoiDung.class);

        cr.add(Restrictions.eq("tenDangNhap", txtTenDangNhap.getText()));
        cr.add(Restrictions.eq("matKhau", txtMatKhau.getText()));
        cr.add(Restrictions.eq("loaiQuyen",true));
        List nd = cr.list();
        
        session.close();
        Iterator iterator = nd.iterator();

        if(iterator.hasNext()){
            this.quanTri();
        }
        this.nguoiDung();
    }
    
    private void quanTri() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void nguoiDung() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBaiTap.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
