package core;

import core.api.SearchAction;
import core.common.InitForm;
import core.common.InitSearchForm;
import core.common.InitSearchUrl;
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
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("view/search-form.fxml"));
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
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("view/search-url.fxml"));
            pnMain.getChildren().add(newLoadedPane);
            btSearchUrlListener.setText("Đóng");
        }
    }

    @FXML
    Button tbSearch;

    @FXML
    private void search(ActionEvent event) throws IOException {
        if (btAddCondition.getText().equals("Đóng")){
            InitForm.itemCategories = new SearchAction().categories(searchWithForm(InitForm.locateds),InitForm.page);
        } else if (btSearchUrlListener.getText().equals("Đóng")){
            InitForm.itemCategories = new SearchAction().categories(searchWithUrl(InitForm.locateds),InitForm.page);
        }
        pnMain.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("view/search-reponse.fxml"));
        pnMain.getChildren().add(newLoadedPane);
    }

    private List<String> searchWithForm(List<Located> locateds){
        List<String> lstUrl = new ArrayList<>();

        StringBuffer buffer = new StringBuffer();
        buffer.append("https://www.ebay.com/sch/i.html?_from=R40");
        buffer.append(InitSearchForm.keywords.toString());
        if (InitSearchForm.category.getValue() != null)
            buffer.append(InitSearchForm.category.toString());
        if (InitSearchForm.priceFrom.getValue() != null)
            buffer.append(InitSearchForm.priceFrom.toString());
        if (InitSearchForm.priceTo.getValue() != null)
            buffer.append(InitSearchForm.priceTo.toString());
        if (InitSearchForm.auction.getValue() != null)
            buffer.append(InitSearchForm.auction.toString());
        if (InitSearchForm.buyItNow.getValue() != null)
            buffer.append(InitSearchForm.buyItNow.toString());
        if (InitSearchForm.condition.getValue() != null)
            buffer.append(InitSearchForm.condition.toString());
        if (InitForm.sortBy.getValue() != null)
            buffer.append(InitForm.sortBy.toString());
        if (InitForm.listing.getTypeTime().getValue() != null)
            buffer.append(InitForm.listing.getTypeTime().toString());
        if (InitForm.listing.getListHour().getValue() != null)
            buffer.append(InitForm.listing.getListHour().toString());
        buffer.append("&_skc=200");
        String url = buffer.toString();
        if (locateds.size() > 0){
            locateds.forEach(locate -> {
                buffer.append(locate.toString());
                lstUrl.add(buffer.toString());
                buffer.replace(0,buffer.toString().length() -1 , url);
            });
        } else {
            lstUrl.add(buffer.toString());
        }

        return lstUrl;
    }

    private List<String> searchWithUrl(List<Located> located){
        List<String> listUrl = new ArrayList<>();
        String[] strings = InitSearchUrl.url.split("&");
        StringBuffer buffer = new StringBuffer();

        if (!(located.size() > 0)){
            for (String str : strings) {
                if (str.contains("_ipg="))
                    buffer.append("&_ipg=200");
                else if (str.equals(strings[0]))
                    buffer.append(str);
                else
                    buffer.append("&" + str);
            }
            listUrl.add(buffer.toString());
            return listUrl;
        }
        located.forEach(locale -> {
            for (String str : strings) {
                if (str.contains("_salic="))
                    buffer.append(located);
                if (str.contains("_ipg="))
                    buffer.append("&_ipg=200");
                else if (str.equals(strings[0]))
                    buffer.append(str);
                else
                    buffer.append("&" + str);
            }
            listUrl.add(buffer.toString());
        });
        return listUrl;
    }

}
