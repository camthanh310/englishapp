/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp;



import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import englishapp.models.NguoiDung;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import util.AlertDialog;
import util.KiemTraTextField;

/**
 * FXML Controller class
 *
 * @author thanhtieu
 */
public class FXMLDanhSachNguoiDungController implements Initializable {
    @FXML
    private JFXTextField txtTenDangNhap;
    @FXML
    private JFXPasswordField txtMatKhau;
    @FXML
    private JFXTextField txtHo;
    @FXML
    private JFXTextField txtTen;
    @FXML
    private TableView<NguoiDung> tbNguoiDung;
    @FXML
    private Label lbNguoiDung;
    @FXML
    private Label loiTenDangNhap;
    @FXML
    private Label loiMatKhau;
    @FXML
    private Label loiHo;
    @FXML
    private Label loiTen;
    
    private SessionFactory factory;
    private ObservableList<NguoiDung> nguoiDung = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.factory = HibernateUtil.getSessionFactory();
        this.danhSachNguoiDung();
        this.layNguoiDung();
    }
    
    private void layNguoiDung(){
        this.tbNguoiDung.setRowFactory(tv -> {
            TableRow<NguoiDung> row = new TableRow<>();
            row.setOnMouseClicked((MouseEvent e) ->{
                if(e.getClickCount() == 2 && !row.isEmpty()){
                    NguoiDung nd = row.getItem();
                    lbNguoiDung.setText(nd.getMaNguoiDung());
                    txtTenDangNhap.setText(nd.getTenDangNhap());
                    txtMatKhau.setText(nd.getMatKhau());
                    txtHo.setText(nd.getHo());
                    txtTen.setText(nd.getTen());
                }
            });
            return row;
        });
    }
    
    private void danhSachNguoiDung(){
        TableColumn cTenDangNhap = new TableColumn("Tên đăng nhập");
        cTenDangNhap.setCellValueFactory(new PropertyValueFactory("tenDangNhap"));     
        TableColumn cHo = new TableColumn("Họ");
        cHo.setCellValueFactory(new PropertyValueFactory("ho"));    
        TableColumn cTen = new TableColumn("Tên");
        cTen.setCellValueFactory(new PropertyValueFactory("ten"));   
        this.tbNguoiDung.getColumns().addAll(cTenDangNhap,cHo,cTen);     
        this.getNguoiDung();
        this.tbNguoiDung.setItems(nguoiDung);
    }
    
    private void getNguoiDung(){
        Session session = this.factory.openSession();
        Criteria cr = session.createCriteria(NguoiDung.class);
        cr.addOrder(Order.asc("ten"));
        List<NguoiDung> nguoiDung = cr.list();
        session.close();
        this.nguoiDung.clear();
        nguoiDung.stream().forEach(e -> {
            this.nguoiDung.add(e);
        });
    }
    
     public void themNguoiDung(ActionEvent e){
        boolean ktTenDangNhap = KiemTraTextField.kiemTraTextFieldEmpty(
                txtTenDangNhap, loiTenDangNhap, "Nhập tên đăng nhập");
        boolean ktMatKhau = KiemTraTextField.kiemTraPasswordFieldEmpty(
                txtMatKhau, loiMatKhau, "Nhập mật khẩu");
        boolean ktHo = KiemTraTextField.kiemTraTextFieldEmpty(
                txtHo, loiHo, "Nhập họ");
        boolean ktTen = KiemTraTextField.kiemTraTextFieldEmpty(
                txtTen, loiTen, "Nhập tên");
        
        if (ktTenDangNhap && ktMatKhau && ktHo && ktTen ) {
            
            Session session = this.factory.openSession();
            String maNguoiDung = UUID.randomUUID().toString();
            String tenDangNhap = this.txtTenDangNhap.getText().trim();
            String matKhau = this.txtMatKhau.getText().trim();
            String ho = this.txtHo.getText().trim();
            String ten = this.txtTen.getText().trim();
            boolean loaiQuyen = true;
            NguoiDung ngDung = 
                    new NguoiDung(maNguoiDung, tenDangNhap, 
                            matKhau, ho, ten, loaiQuyen);
            Transaction trans = session.beginTransaction();

            try {
                session.save(ngDung);
                trans.commit();
                
                AlertDialog.infoBox(Alert.AlertType.INFORMATION,
                            "Thêm thành công một người dùng!", "Thông báo!", "Thêm!");
                lamMoi();
                
            }catch(HibernateException ex){
                trans.rollback();
            }

            session.close();
            this.getNguoiDung();
        }
    }
     
    public void suaNguoiDung(ActionEvent e){
        boolean ktTenDangNhap = KiemTraTextField.kiemTraTextFieldEmpty(
                txtTenDangNhap, loiTenDangNhap, "Nhập tên đăng nhập");
        boolean ktMatKhau = KiemTraTextField.kiemTraPasswordFieldEmpty(
                txtMatKhau, loiMatKhau, "Nhập mật khẩu");
        boolean ktHo = KiemTraTextField.kiemTraTextFieldEmpty(
                txtHo, loiHo, "Nhập họ");
        boolean ktTen = KiemTraTextField.kiemTraTextFieldEmpty(
                txtTen, loiTen, "Nhập tên");
        
        if (ktTenDangNhap && ktMatKhau && ktHo && ktTen ) {
            Session session = this.factory.openSession();

            String maNguoiDung = this.lbNguoiDung.getText();
            String tenDangNhap = this.txtTenDangNhap.getText().trim();
            String matKhau = this.txtMatKhau.getText().trim();
            String ho = this.txtHo.getText().trim();
            String ten = this.txtTen.getText().trim();
            boolean loaiQuyen = false;
            NguoiDung ngDung = 
                    new NguoiDung(maNguoiDung, tenDangNhap, 
                            matKhau, ho, ten, loaiQuyen);
            Transaction trans = session.beginTransaction();
            try {
                session.update(ngDung);
                trans.commit();
                AlertDialog.infoBox(Alert.AlertType.INFORMATION,
                        "Sửa thành công một người dùng!", "Thông báo!", "Sửa!");
                lamMoi();
            }catch(HibernateException ex){
                trans.rollback();
            }
            session.close();
            this.getNguoiDung();
        }
    }

    public void lamMoiNguoiDung(ActionEvent e){
        this.lamMoi();
    }
    
    public void lamMoi(){
        this.txtTen.setText("");
        this.txtHo.setText("");
        this.txtMatKhau.setText("");
        this.txtTenDangNhap.setText("");
    }
    
}
