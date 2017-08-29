package core.ui;

import core.common.InitForm;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class PageController {

    @FXML
    public void initialize() {
        initPage();
    }

    @FXML
    TextField tfPage;

    private void initPage(){
        if (InitForm.page != null){
            tfPage.setText(InitForm.page);
        }

        tfPage.textProperty().addListener((observable, oldValue, newValue) -> InitForm.page = newValue);
    }
}
