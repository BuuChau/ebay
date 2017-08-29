package core;

import core.common.InitSearchForm;
import core.common.InitSearchUrl;
import core.model.search.*;
import core.model.search.listing.ListHour;
import core.model.search.listing.TypeTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SearchUrlController {

    @FXML
    public void initialize() {
        InitSearchForm.reset();
        initUrl();
    }

    @FXML
    TextField tfUrl;

    private void initUrl(){
        if (InitSearchUrl.url != null){
            tfUrl.setText(InitSearchForm.keywords.getValue());
        }
        tfUrl.textProperty().addListener((observable, oldValue, newValue) -> InitSearchUrl.url = newValue);
    }
}
