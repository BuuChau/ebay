package core.ui;

import core.common.InitForm;
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
        if (InitForm.sortBy.getValue() == null){
            cbbSortBy.getSelectionModel().selectFirst();
            InitForm.sortBy = new SortBy(cbbSortBy.getValue().toString());
        } else {
            cbbSortBy.getSelectionModel().select(InitForm.sortBy.getValue());
        }
    }

    @FXML
    private void sortBySelect(){
        InitForm.sortBy = new SortBy(cbbSortBy.getSelectionModel().getSelectedItem().toString());
    }

    /**
     * Sold
     */
    @FXML
    TextField tfSold;

    private void initSold(){
        if (InitForm.sold.getValue() != null)
            tfSold.setText(InitForm.sold.getValue().toString());

        tfSold.textProperty().addListener((observable, oldValue, newValue) -> InitForm.sold = new Sold(newValue));
    }

    /**
     * Feedbank
     */
    @FXML
    TextField tfFeedbackFrom;
    @FXML
    TextField tfFeedbackTo;

    private void initFeedback(){
        if (InitForm.feedBack.getFrom() != null)
            tfFeedbackFrom.setText(InitForm.feedBack.getFrom().toString());
        if (InitForm.feedBack.getTo() != null)
            tfFeedbackTo.setText(InitForm.feedBack.getTo().toString());

        tfFeedbackFrom.textProperty().addListener((observable, oldValue, newValue) -> InitForm.feedBack = new FeedBack(newValue,tfFeedbackTo.getText()));
        tfFeedbackTo.textProperty().addListener((observable, oldValue, newValue) -> InitForm.feedBack = new FeedBack(tfFeedbackFrom.getText(),newValue));
    }

    /**
     * Date filt
     */
    @FXML
    ComboBox cbbTypeTime;

    private void initTypeTime(){
        if (InitForm.listing.getTypeTime() == null){
            cbbTypeTime.getSelectionModel().selectFirst();
            InitForm.listing.setTypeTime(new TypeTime(cbbTypeTime.getValue().toString()));
        } else {
            cbbTypeTime.getSelectionModel().select(InitForm.listing.getTypeTime().getValue());
        }
    }

    @FXML
    private void TimeTypeSelect(){
        InitForm.listing.setTypeTime(new TypeTime(cbbTypeTime.getSelectionModel().getSelectedItem().toString()));
    }

    @FXML
    ComboBox cbbListHour;

    private void initTypeHour(){
        if (InitForm.listing.getListHour() == null){
            cbbListHour.getSelectionModel().selectFirst();
            InitForm.listing.setListHour(new ListHour(cbbListHour.getValue().toString()));
        } else {
            cbbListHour.getSelectionModel().select(InitForm.listing.getListHour().getValue());
        }
    }

    @FXML
    private void TimeHourSelect(){
        InitForm.listing.setListHour(new ListHour(cbbListHour.getValue().toString()));
    }
}
