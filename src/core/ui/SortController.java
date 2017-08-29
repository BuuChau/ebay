package core.ui;

import core.common.InitSearchForm;
import core.model.search.FeedBack;
import core.model.search.Sold;
import core.model.search.SortBy;
import core.model.search.listing.ListHour;
import core.model.search.listing.TypeTime;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SortController {

    @FXML
    public void initialize() {
        initSortBy();
        initSold();
        initFeedback();
        initTypeTime();
        initTypeHour();
    }

    /**
     * Sort by
     */
    @FXML
    ComboBox cbbSortBy;

    private void initSortBy(){
        if (InitSearchForm.sortBy.getValue() == null){
            cbbSortBy.getSelectionModel().selectFirst();
            InitSearchForm.sortBy = new SortBy(cbbSortBy.getValue().toString());
        } else {
            cbbSortBy.getSelectionModel().select(InitSearchForm.sortBy.getValue());
        }
    }

    @FXML
    private void sortBySelect(){
        InitSearchForm.sortBy = new SortBy(cbbSortBy.getSelectionModel().getSelectedItem().toString());
    }

    /**
     * Sold
     */
    @FXML
    TextField tfSold;

    private void initSold(){
        if (InitSearchForm.sold.getValue() != null)
            tfSold.setText(InitSearchForm.sold.getValue().toString());

        tfSold.textProperty().addListener((observable, oldValue, newValue) -> InitSearchForm.sold = new Sold(newValue));
    }

    /**
     * Feedbank
     */
    @FXML
    TextField tfFeedbackFrom;
    @FXML
    TextField tfFeedbackTo;

    private void initFeedback(){
        if (InitSearchForm.feedBack.getFrom() != null)
            tfFeedbackFrom.setText(InitSearchForm.feedBack.getFrom().toString());
        if (InitSearchForm.feedBack.getTo() != null)
            tfFeedbackTo.setText(InitSearchForm.feedBack.getTo().toString());

        tfFeedbackFrom.textProperty().addListener((observable, oldValue, newValue) -> InitSearchForm.feedBack = new FeedBack(newValue,tfFeedbackTo.getText()));
        tfFeedbackTo.textProperty().addListener((observable, oldValue, newValue) -> InitSearchForm.feedBack = new FeedBack(tfFeedbackFrom.getText(),newValue));
    }

    /**
     * Date filt
     */
    @FXML
    ComboBox cbbTypeTime;

    private void initTypeTime(){
        if (InitSearchForm.listing.getTypeTime() == null){
            cbbTypeTime.getSelectionModel().selectFirst();
            InitSearchForm.listing.setTypeTime(new TypeTime(cbbTypeTime.getValue().toString()));
        } else {
            cbbTypeTime.getSelectionModel().select(InitSearchForm.listing.getTypeTime().getValue());
        }
    }

    @FXML
    private void TimeTypeSelect(){
        InitSearchForm.listing.setTypeTime(new TypeTime(cbbTypeTime.getSelectionModel().getSelectedItem().toString()));
    }

    @FXML
    ComboBox cbbListHour;

    private void initTypeHour(){
        if (InitSearchForm.listing.getListHour() == null){
            cbbListHour.getSelectionModel().selectFirst();
            InitSearchForm.listing.setListHour(new ListHour(cbbListHour.getValue().toString()));
        } else {
            cbbListHour.getSelectionModel().select(InitSearchForm.listing.getListHour().getValue());
        }
    }

    @FXML
    private void TimeHourSelect(){
        InitSearchForm.listing.setListHour(new ListHour(cbbListHour.getValue().toString()));
    }
}
