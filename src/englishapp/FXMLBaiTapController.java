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
import englishapp.models.NguoiDung;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * FXML Controller class
 *
 * @author thanhtieu
 */
public class FXMLBaiTapController implements Initializable {

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
        this.loadCauHoi();
    }    
    
    private void loadCauHoi(){
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(CauHoi.class);
        //System.out.println(cr);
        Criteria crDA = session.createCriteria(DapAn.class);
        CauHoi ch = new CauHoi();
        DapAn da = new DapAn();
        
        List results = cr.list();
        List dapAn = crDA.list();
        System.out.println(results);
        System.out.print("////////");
        System.out.println(dapAn);
        
        Iterator iterator = results.iterator();
        Iterator iteratorDA = dapAn.iterator();
        while (iterator.hasNext()) {    
            CauHoi a = (CauHoi) iterator.next();
            System.out.println(a);
            while (iteratorDA.hasNext()){
                DapAn d = (DapAn) iteratorDA.next();
                System.out.println(d);
            }
            
        }
        txtCauHoi.setText(ch.getCauHoi());
        txtCauHoi.setText(ch.getCauHoi());
        txtA.setText(da.getMaDapAn());
        txtB.setText(da.getMaDapAn());
        txtC.setText(da.getMaDapAn());
        txtD.setText(da.getMaDapAn());
        
        session.close();
    }

}
