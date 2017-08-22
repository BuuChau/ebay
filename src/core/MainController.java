package core;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class MainController {

    @FXML
    Button btAddCondition;

    @FXML
    Pane pnMain;

    @FXML
    private void btAddConditionListener(ActionEvent event) throws IOException {
        if (btAddCondition.getText().equals("Đóng")) {
            pnMain.getChildren().clear();
            btAddCondition.setText("Thêm Điều Kiện");
        }
        else {
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("../view/search.fxml"));
            pnMain.getChildren().add(newLoadedPane);
            btAddCondition.setText("Đóng");
        }
    }
}
