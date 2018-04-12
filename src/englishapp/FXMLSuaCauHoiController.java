/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import englishapp.models.CauHoi;
import englishapp.models.DapAn;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author thanhtieu
 */
public class FXMLSuaCauHoiController implements Initializable {

    @FXML
    private JFXTextArea txtCauHoi;
    @FXML
    private JFXTextField txtA;
    @FXML
    private JFXTextField txtB;
    @FXML
    private JFXTextField txtC;
    @FXML
    private JFXTextField txtD;
    @FXML
    private JFXRadioButton rdA;
    @FXML
    private ToggleGroup chon;
    @FXML
    private JFXRadioButton rdB;
    @FXML
    private JFXRadioButton rdC;
    @FXML
    private JFXRadioButton rdD;
    @FXML
    private Label lbMaCauHoi;
    private SessionFactory factory;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.factory = HibernateUtil.getSessionFactory();
    }    
    
    public void suaCauHoi(ActionEvent e){
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        
        try{   
        //Cau hoi
            String maCauHoi = lbMaCauHoi.getText();
            String cauHoi = this.txtCauHoi.getText().trim();
            String maDapAn = this.txtA.getText().trim();
            DapAn da = new DapAn();
            
            CauHoi ch = new CauHoi(maCauHoi, cauHoi, null);
            session.update(ch);
            trans.commit();
        
        }
        catch(HibernateException ex){
            trans.rollback();
        }
        session.close();
    }
    
    public void lamMoiCauHoi(ActionEvent e){
        this.txtCauHoi.setText("");
        this.txtA.setText("");
        this.txtB.setText("");
        this.txtC.setText("");
        this.txtD.setText("");
    }
    
    public void getSuaCauHoi(CauHoi ch){
        
        txtCauHoi.setText(ch.getCauHoi());
        lbMaCauHoi.setText(ch.getMaCauHoi());
        txtA.setText(ch.getMaDapAn().toString());
     
    }

}
