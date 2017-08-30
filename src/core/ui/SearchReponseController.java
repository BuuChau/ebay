package core.ui;

import core.common.InitForm;
import core.model.reponse.ItemCategory;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuoclt on 8/30/17.
 */
public class SearchReponseController {

    @FXML
    private TableView<ItemCategory> tableView;

    @FXML
    private TableColumn<ItemCategory, String> No;
    @FXML
    private TableColumn<ItemCategory, String> Name;
    @FXML
    private TableColumn<ItemCategory, String> Link;
    @FXML
    private TableColumn<ItemCategory, String> Quantity;
    @FXML
    private TableColumn<ItemCategory, String> Feedback;

    public void initialize() {
        No.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Title"));
        Link.setCellValueFactory(new PropertyValueFactory<>("url"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Feedback.setCellValueFactory(new PropertyValueFactory<>("Feedback"));

        tableView.getItems().setAll(InitForm.itemCategories);
        InitForm.itemCategories = new ArrayList<>();
    }
}
