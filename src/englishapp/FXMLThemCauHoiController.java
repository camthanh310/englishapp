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
public class FXMLThemCauHoiController implements Initializable {

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
    
    private SessionFactory factory;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.factory = HibernateUtil.getSessionFactory();
    }    
    
    public void themCauHoi(ActionEvent e){
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        
        try{   
        //Cau hoi
            String maCauHoi = UUID.randomUUID().toString();
            String cauHoi = this.txtCauHoi.getText().trim();
            CauHoi ch = new CauHoi(maCauHoi, cauHoi, null);
            session.save(ch);
            //Dap an

            String dapAnA = this.txtA.getText();
            String dapAnB = this.txtB.getText();
            String dapAnC = this.txtC.getText();
            String dapAnD = this.txtD.getText();

            CauHoi mCauHoi = (CauHoi) session.get(CauHoi.class, maCauHoi);

            String  daAID = UUID.randomUUID().toString();
            DapAn da = new DapAn(daAID, dapAnA, mCauHoi);
            System.out.println("Ma dap an :" + daAID);

            String  daBID = UUID.randomUUID().toString();
            DapAn da1 = new DapAn(daBID, dapAnB, mCauHoi);
            System.out.println("Ma dap an :" + daBID);

            String  daCID = UUID.randomUUID().toString();
            DapAn da2 = new DapAn(daCID, dapAnC, mCauHoi);
            System.out.println("Ma dap an :" + daCID);

            String  daDID = UUID.randomUUID().toString();
            DapAn da3 = new DapAn(daDID, dapAnD, mCauHoi);
            System.out.println("Ma dap an :" + daDID);

            String dapAnDung = daAID;
            if(rdB.isSelected())
                dapAnDung = daBID;
            else if (rdC.isSelected())
                dapAnDung = daCID;
            else if (rdD.isSelected())
                dapAnDung = daDID;

            session.save(da);
            session.save(da1);
            session.save(da2);
            session.save(da3);

            DapAn mDapAn = (DapAn) session.get(DapAn.class, dapAnDung);
            System.out.println("Dap an dung: " + mDapAn);
            ch.setMaDapAn(mDapAn);

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

}
