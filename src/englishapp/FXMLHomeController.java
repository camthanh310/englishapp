/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp;

import util.TranferForm;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import englishapp.models.ThoiGian;

/**
 * FXML Controller class
 *
 * @author toanten
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private Label lblDate;
    @FXML
    private Label lblTime;
    @FXML
    private ImageView imgGrammar;
    @FXML
    private ImageView imgPicture;
    @FXML
    private ImageView imgAudio;
    @FXML
    private ImageView imgQuestion;
    @FXML
    private ImageView imgSetting;
    @FXML
    private ImageView imgExit;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // show date
        bindToTime();
        //ThoiGian time = new ThoiGian();
        //lblTime.setText(time.tanggal());
    }

    public void start(final Stage stage) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
        Scene homescene = new Scene(home);
        homescene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Home");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(homescene);
        stage.show();
    }
// click show form

    @FXML
    private void handleAction(MouseEvent event) throws IOException {
        if (event.getSource() == imgExit) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận");
            alert.setHeaderText("Thông báo!");
            alert.setContentText("Bạn có muốn thoát khỏi ứng dụng không ?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    exit(0);
                } else {
                    alert.close();
                }
            });
        } else if (event.getSource() == imgSetting) {
            TranferForm.loadWindow(getClass().getResource("FXMLDanhSachNguoiDung.fxml"), "Người dùng", null);
        } else if (event.getSource() == imgQuestion) {
            TranferForm.loadWindow(getClass().getResource("FXMLDanhSachCauHoi.fxml"), "Danh sách câu hỏi", null);
        } else if (event.getSource() == imgGrammar) {
            TranferForm.loadWindow(getClass().getResource(""), "Ngữ pháp", null);
        } else if (event.getSource() == imgPicture) {
            TranferForm.loadWindow(getClass().getResource(""), "Hình ảnh", null);
        }
    }

    // show ThoiGian
    private void bindToTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), (ActionEvent actionEvent) -> {
                    Calendar time = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    lblDate.setText(simpleDateFormat.format(time.getTime()));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}
