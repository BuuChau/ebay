package core;

import core.common.InitSearchForm;
import core.common.InitSearchUrl;
import core.model.search.*;
import core.model.search.listing.ListHour;
import core.model.search.listing.TypeTime;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SearchFormController {

    @FXML
    public void initialize() {
        InitSearchUrl.reset();
        initKeyword();
        initCategory();
        initPrice();
        initBuyFormat();
        initCondition();
    }

    @FXML
    TextField tfKeyword;

    private void initKeyword(){
        if (InitSearchForm.keywords.getValue() != null){
            tfKeyword.setText(InitSearchForm.keywords.getValue());
        }

        tfKeyword.textProperty().addListener((observable, oldValue, newValue) -> InitSearchForm.keywords = new Keywords(newValue));
    }

    /**
     * Category
     */
    @FXML
    ComboBox cbbCategory;

    private void initCategory(){
        if (InitSearchForm.category.getValue() == null){
            cbbCategory.getSelectionModel().selectFirst();
            InitSearchForm.category.setValue(cbbCategory.getValue().toString());
        } else {
            cbbCategory.getSelectionModel().select(InitSearchForm.category.getValue());
        }
    }

    @FXML
    private void categorySelected(){
        InitSearchForm.category.setValue(cbbCategory.getSelectionModel().getSelectedItem().toString());
    }

    /**
     * Price
     */

    @FXML
    TextField tfPriceFrom;
    @FXML
    TextField tfPriceTo;

    private void initPrice(){
        if (InitSearchForm.priceFrom.getValue() != null && InitSearchForm.priceTo.getValue() != null){
            tfPriceFrom.setText(InitSearchForm.priceFrom.getValue());
            tfPriceTo.setText(InitSearchForm.priceTo.getValue());
        }

        tfPriceFrom.textProperty().addListener((observable, oldValue, newValue) -> InitSearchForm.priceFrom = new PriceFrom(newValue));
        tfPriceTo.textProperty().addListener((observable, oldValue, newValue) -> InitSearchForm.priceTo = new PriceTo(newValue));
    }

    /**
     * Fotmat
     */
    @FXML
    CheckBox cbAuction;
    @FXML
    CheckBox cbBuyItNow;

    private void initBuyFormat() {
        if (InitSearchForm.auction.getValue() != null)
            cbAuction.setSelected(true);
        if (InitSearchForm.buyItNow.getValue() != null)
            cbBuyItNow.setSelected(true);
    }

    @FXML
    private void cbAuctionChecked(ActionEvent event){
        configureCheckBoxFormat(cbAuction);
    }

    @FXML
    private void cbBuyItNowChecked(ActionEvent event){
        configureCheckBoxFormat(cbBuyItNow);
    }

    private void configureCheckBoxFormat(CheckBox checkBox) {

        if (checkBox.isSelected()) {
            if (checkBox.getText().equals("Auction"))
                InitSearchForm.auction = new Auction(checkBox.getText(),"1");
            if (checkBox.getText().equals("Buy It Now"))
                InitSearchForm.buyItNow = new BuyItNow(checkBox.getText(),"1");
        } else {
            if (checkBox.getText().equals("Auction"))
                InitSearchForm.auction = new Auction();
            if (checkBox.getText().equals("Buy It Now"))
                InitSearchForm.buyItNow = new BuyItNow();
        }
    }

    /**
     * Condition
     */
    @FXML
    CheckBox cbNew;
    @FXML
    CheckBox cbUser;
    @FXML
    CheckBox cbNotSpecified;
    private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();
    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);

    private final int maxNumSelected =  1;

    public void initCondition() {
        configureCheckBox(cbNew);
        configureCheckBox(cbUser);
        configureCheckBox(cbNotSpecified);
        if (InitSearchForm.condition.getValue() != null) {
            if (InitSearchForm.condition.getValue().equals("New")) {
                cbNew.setSelected(true);
                cbUser.setDisable(false);
                cbNotSpecified.setDisable(true);
            }
            else if (InitSearchForm.condition.getValue().equals("Used")) {
                cbNew.setDisable(true);
                cbUser.setSelected(true);
                cbNotSpecified.setDisable(true);
            }
            else if (InitSearchForm.condition.getValue().equals("Not Specified")) {
                cbNew.setDisable(true);
                cbNotSpecified.setSelected(true);
                cbUser.setDisable(true);
            }
        }
        numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {
            if (newSelectedCount.intValue() >= maxNumSelected) {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(true));
            } else {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(false));
            }
        });
    }

    @FXML
    private void cbConditionChecked(ActionEvent event){
        if (cbNew.isSelected())
            InitSearchForm.condition = new Condition("3",cbNew.getText());
        else if (cbUser.isSelected())
            InitSearchForm.condition = new Condition("4",cbUser.getText());
        else if (cbNotSpecified.isSelected())
            InitSearchForm.condition = new Condition("10",cbNotSpecified.getText());
        else
            InitSearchForm.condition = new Condition();
    }

    private void configureCheckBox(CheckBox checkBox) {

        if (checkBox.isSelected()) {
            selectedCheckBoxes.add(checkBox);
        } else {
            unselectedCheckBoxes.add(checkBox);
        }

        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            } else {
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }
        });
    }
}
