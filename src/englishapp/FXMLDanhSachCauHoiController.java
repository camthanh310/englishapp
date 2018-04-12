/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp;


import englishapp.models.CauHoi;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.SessionFactory;

/**
 * FXML Controller class
 *
 * @author thanhtieu
 */
public class FXMLDanhSachCauHoiController implements Initializable {
    @FXML
    private TableView<CauHoi> tbCauHoi;
    
    
    
    private SessionFactory factory;
    private ObservableList<CauHoi> cauHoi = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.factory = HibernateUtil.getSessionFactory();
        this.danhSachCauHoi();
    }    
    
    private void danhSachCauHoi(){
        TableColumn cCauHoi = new TableColumn("Câu hỏi");
        cCauHoi.setCellValueFactory(new PropertyValueFactory("cauHoi"));
        
        TableColumn cDapAn = new TableColumn("Đáp án");
        cDapAn.setCellValueFactory(new PropertyValueFactory("maDapAn"));
        
        this.tbCauHoi.getColumns().addAll(cCauHoi, cDapAn);
        
        
        this.getCauHoi();
        
        
        this.tbCauHoi.setItems(cauHoi);
    }
    
    public void getCauHoi(){
        Session session = this.factory.openSession();
        Criteria cr = session.createCriteria(CauHoi.class);
        List<CauHoi> cauHoi = cr.list();
        session.close();
        
        cauHoi.stream().forEach(e -> {
            this.cauHoi.add(e);
        });
    }
    
    public void getSuaCauHoi(ActionEvent e) throws IOException{
        CauHoi chonCauHoi = tbCauHoi.getSelectionModel().getSelectedItem();
        if(chonCauHoi == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Không có câu hỏi được chọn");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSuaCauHoi.fxml"));
        Parent root = loader.load();  
        FXMLSuaCauHoiController controller = (FXMLSuaCauHoiController)loader.getController();
        controller.getSuaCauHoi(chonCauHoi);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    public void themCauHoi(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLThemCauHoi.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
