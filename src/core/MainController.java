package core;

import core.api.SearchWithForm;
import core.api.SearchWithUrl;
import core.common.CommonMethod;
import core.common.InitForm;
import core.common.InitSearchForm;
import core.common.InitSearchUrl;
import core.model.reponse.ItemCategory;
import core.model.search.Located;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    Button btAddCondition;

    @FXML
    Button btSearchUrlListener;

    @FXML
    Pane pnMain;

    @FXML
    private void btAddConditionListener(ActionEvent event) throws IOException {
        if (btAddCondition.getText().equals("Đóng")) {
            pnMain.getChildren().clear();
            btAddCondition.setText("Search With Form");
        }
        else {
            pnMain.getChildren().clear();
            btSearchUrlListener.setText("Search Url");
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("../view/search-form.fxml"));
            pnMain.getChildren().add(newLoadedPane);
            btAddCondition.setText("Đóng");
        }
    }

    @FXML
    private void btSearchUrlListener(ActionEvent event) throws IOException {
        if (btSearchUrlListener.getText().equals("Đóng")) {
            pnMain.getChildren().clear();
            btSearchUrlListener.setText("Search Url");
        }
        else {
            pnMain.getChildren().clear();
            btAddCondition.setText("Search With Form");
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("../view/search-url.fxml"));
            pnMain.getChildren().add(newLoadedPane);
            btSearchUrlListener.setText("Đóng");
        }
    }

    @FXML
    Button tbSearch;

    @FXML
    private void search(ActionEvent event) throws IOException {
        List<ItemCategory> itemCategories = new ArrayList<>();

        if (btAddCondition.getText().equals("Đóng")){
            SearchWithForm withForm = new SearchWithForm();
            for (Located located : InitForm.locateds) {
                List<ItemCategory> items = withForm.categories(InitSearchForm.searchWithCondition(),located.toString());
                for (ItemCategory category : items) {
                    itemCategories.add(category);
                }
            }
        } else if (btSearchUrlListener.getText().equals("Đóng")){
            SearchWithUrl withUrl = new SearchWithUrl();
            if (InitForm.locateds.size() > 0) {
                for (Located located : InitForm.locateds) {
                    List<ItemCategory> items = withUrl.categories(InitSearchUrl.searchWithUrl(located.toString()));
                    for (ItemCategory category : items) {
                        itemCategories.add(category);
                    }
                }
            } else {
                List<ItemCategory> items = withUrl.categories(InitSearchUrl.searchWithUrl(""));
                for (ItemCategory category : items) {
                    itemCategories.add(category);
                }
            }
        }
    }
}
