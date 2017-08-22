package core;

import core.common.InitCommon;
import core.model.search.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SearchController {

    @FXML
    public void initialize() {
        initCategory();
        initPrice();
        initBuyFormat();
        initCondition();
        /*initCheckBoxLocation();
        initSortBy();
        initResultPerPage();
        initSold();
        initFeedback();
        initDateFilt();*/
    }

    /**
     * Category
     */
    @FXML
    ComboBox cbbCategory;

    private void initCategory(){
        if (InitCommon.search.getCategory() == null){
            cbbCategory.getSelectionModel().selectFirst();
            InitCommon.search.setCategory(new Category(cbbCategory.getValue().toString()));
        } else {
            cbbCategory.getSelectionModel().select(InitCommon.search.getCategory().getValue());
        }
    }

    @FXML
    private void categorySelected(){
        InitCommon.search.setCategory(new Category(cbbCategory.getSelectionModel().getSelectedItem().toString()));
    }

    /**
     * Price
     */

    @FXML
    ComboBox cbbTypePrice;
    @FXML
    TextField tfPriceFrom;
    @FXML
    TextField tfPriceTo;

    private void initPrice(){
        String type = null;
        if (InitCommon.search.getPriceFrom() != null && InitCommon.search.getPriceTo() != null){
            cbbTypePrice.getSelectionModel().select(InitCommon.search.getPriceFrom().getValue());
            tfPriceFrom.setText(InitCommon.search.getPriceFrom().getValue());
            tfPriceTo.setText(InitCommon.search.getPriceTo().getValue());
        } else {
            cbbTypePrice.getSelectionModel().selectFirst();
            type = cbbTypePrice.getValue().toString();
        }

        String finalType1 = type;
        tfPriceFrom.textProperty().addListener((observable, oldValue, newValue) -> InitCommon.search.setPriceFrom(new PriceFrom(newValue)));
        String finalType = type;
        tfPriceTo.textProperty().addListener((observable, oldValue, newValue) -> InitCommon.search.setPriceTo(new PriceTo(newValue)));
    }

    /**
     * Fotmat
     */
    @FXML
    CheckBox cbAuction;
    @FXML
    CheckBox cbBuyItNow;

    private void initBuyFormat() {
        if (InitCommon.search.getAuction() != null)
            cbAuction.setSelected(true);
        if (InitCommon.search.getBuyItNow() != null)
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
                InitCommon.search.setAuction(new Auction(checkBox.getId(),checkBox.getText()));
            if (checkBox.getText().equals("BuyItNow"))
                InitCommon.search.setBuyItNow(new BuyItNow(checkBox.getId(),checkBox.getText()));
        } else {
            if (checkBox.getText().equals("Auction"))
                InitCommon.search.setAuction(new Auction(null,null));
            if (checkBox.getText().equals("BuyItNow"))
                InitCommon.search.setBuyItNow(new BuyItNow(null,null));
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

    public void initCondition() {
        if (InitCommon.search.getCondition().getValue().equals("New"))
            cbNew.setSelected(true);
        else if (InitCommon.search.getCondition().getValue().equals("Used"))
            cbUser.setSelected(true);
        else if (InitCommon.search.getCondition().getValue().equals("Not Specified"))
            cbNotSpecified.setSelected(true);
    }

    @FXML
    private void cbNewChecked(ActionEvent event){
        configureCheckBoxCondition(cbNew);
    }

    @FXML
    private void cbUserChecked(ActionEvent event){
        configureCheckBoxCondition(cbUser);
    }

    @FXML
    private void cbNotSpecifiedChecked(ActionEvent event){
        configureCheckBoxCondition(cbNotSpecified);
    }

    private void configureCheckBoxCondition(CheckBox checkBox) {

        if (checkBox.isSelected()) {
            InitCommon.search.setCondition(new Condition(checkBox.getId(),checkBox.getText()));
        } else {
            InitCommon.search.setCondition(new Condition(null,null));
        }
    }

    /**
     * Location
     */

    @FXML CheckBox US;
    @FXML CheckBox AU;
    @FXML CheckBox CA;
    @FXML CheckBox GB;
    @FXML CheckBox AF;
    @FXML CheckBox AL;
    @FXML CheckBox DZ;
    @FXML CheckBox AS;
    @FXML CheckBox AD;
    @FXML CheckBox AO;
    @FXML CheckBox AI;
    @FXML CheckBox AG;
    @FXML CheckBox AR;
    @FXML CheckBox AM;
    @FXML CheckBox AW;
    @FXML CheckBox AZ;
    @FXML CheckBox BS;
    @FXML CheckBox BH;
    @FXML CheckBox BD;
    @FXML CheckBox BB;
    @FXML CheckBox BY;
    @FXML CheckBox BE;
    @FXML CheckBox BZ;
    @FXML CheckBox BJ;
    @FXML CheckBox BM;
    @FXML CheckBox BT;
    @FXML CheckBox BO;
    @FXML CheckBox BA;
    @FXML CheckBox BW;
    @FXML CheckBox BR;
    @FXML CheckBox IO;
    @FXML CheckBox BN;
    @FXML CheckBox BG;
    @FXML CheckBox BF;
    @FXML CheckBox BI;
    @FXML CheckBox KH;
    @FXML CheckBox CM;
    @FXML CheckBox CV;
    @FXML CheckBox KY;
    @FXML CheckBox CF;
    @FXML CheckBox TD;
    @FXML CheckBox CL;
    @FXML CheckBox CN;
    @FXML CheckBox CO;
    @FXML CheckBox KM;
    @FXML CheckBox CD;
    @FXML CheckBox CG;
    @FXML CheckBox CK;
    @FXML CheckBox CR;
    @FXML CheckBox CI;
    @FXML CheckBox HR;
    @FXML CheckBox CY;
    @FXML CheckBox CZ;
    @FXML CheckBox DK;
    @FXML CheckBox DJ;
    @FXML CheckBox DM;
    @FXML CheckBox DO;
    @FXML CheckBox EC;
    @FXML CheckBox EG;
    @FXML CheckBox SV;
    @FXML CheckBox GQ;
    @FXML CheckBox ER;
    @FXML CheckBox EE;
    @FXML CheckBox ET;
    @FXML CheckBox FK;
    @FXML CheckBox FJ;
    @FXML CheckBox FI;
    @FXML CheckBox FR;
    @FXML CheckBox GF;
    @FXML CheckBox PF;
    @FXML CheckBox GA;
    @FXML CheckBox GM;
    @FXML CheckBox GE;
    @FXML CheckBox DE;
    @FXML CheckBox GH;
    @FXML CheckBox GI;
    @FXML CheckBox GR;
    @FXML CheckBox GL;
    @FXML CheckBox GD;
    @FXML CheckBox GP;
    @FXML CheckBox GU;
    @FXML CheckBox GT;
    @FXML CheckBox GG;
    @FXML CheckBox GN;
    @FXML CheckBox GW;
    @FXML CheckBox GY;
    @FXML CheckBox HT;
    @FXML CheckBox HN;
    @FXML CheckBox HK;
    @FXML CheckBox HU;
    @FXML CheckBox IS;
    @FXML CheckBox IN;
    @FXML CheckBox ID;
    @FXML CheckBox IE;
    @FXML CheckBox IL;
    @FXML CheckBox IT;
    @FXML CheckBox JM;
    @FXML CheckBox JP;
    @FXML CheckBox JE;
    @FXML CheckBox JO;
    @FXML CheckBox KZ;
    @FXML CheckBox KE;
    @FXML CheckBox KI;
    @FXML CheckBox KP;
    @FXML CheckBox KR;
    @FXML CheckBox KG;
    @FXML CheckBox LA;
    @FXML CheckBox LV;
    @FXML CheckBox LB;
    @FXML CheckBox LI;
    @FXML CheckBox LT;
    @FXML CheckBox LU;
    @FXML CheckBox MO;
    @FXML CheckBox MK;
    @FXML CheckBox MG;
    @FXML CheckBox MW;
    @FXML CheckBox MY;
    @FXML CheckBox MV;
    @FXML CheckBox ML;
    @FXML CheckBox MT;
    @FXML CheckBox MH;
    @FXML CheckBox MQ;
    @FXML CheckBox MR;
    @FXML CheckBox MU;
    @FXML CheckBox YT;
    @FXML CheckBox MX;
    @FXML CheckBox FM;
    @FXML CheckBox MD;
    @FXML CheckBox MC;
    @FXML CheckBox MN;
    @FXML CheckBox ME;
    @FXML CheckBox MS;
    @FXML CheckBox MA;
    @FXML CheckBox MZ;
    @FXML CheckBox NA;
    @FXML CheckBox NR;
    @FXML CheckBox NP;
    @FXML CheckBox NL;
    @FXML CheckBox NC;
    @FXML CheckBox NZ;
    @FXML CheckBox NI;
    @FXML CheckBox NE;
    @FXML CheckBox NG;
    @FXML CheckBox NU;
    @FXML CheckBox NO;
    @FXML CheckBox OM;
    @FXML CheckBox PK;
    @FXML CheckBox PQ;
    @FXML CheckBox PA;
    @FXML CheckBox PG;
    @FXML CheckBox PY;
    @FXML CheckBox PE;
    @FXML CheckBox PH;
    @FXML CheckBox PL;
    @FXML CheckBox PT;
    @FXML CheckBox PR;
    @FXML CheckBox QA;
    @FXML CheckBox RE;
    @FXML CheckBox RO;
    @FXML CheckBox RU;
    @FXML CheckBox RW;
    @FXML CheckBox SH;
    @FXML CheckBox KN;
    @FXML CheckBox LC;
    @FXML CheckBox PM;
    @FXML CheckBox VC;
    @FXML CheckBox SM;
    @FXML CheckBox SA;
    @FXML CheckBox SN;
    @FXML CheckBox RS;
    @FXML CheckBox SC;
    @FXML CheckBox SL;
    @FXML CheckBox SG;
    @FXML CheckBox SK;
    @FXML CheckBox SI;
    @FXML CheckBox SB;
    @FXML CheckBox SO;
    @FXML CheckBox ZA;
    @FXML CheckBox ES;
    @FXML CheckBox LK;
    @FXML CheckBox SR;
    @FXML CheckBox SZ;
    @FXML CheckBox SE;
    @FXML CheckBox CH;
    @FXML CheckBox TW;
    @FXML CheckBox TJ;
    @FXML CheckBox TZ;
    @FXML CheckBox TH;
    @FXML CheckBox TG;
    @FXML CheckBox TO;
    @FXML CheckBox TT;
    @FXML CheckBox TN;
    @FXML CheckBox TR;
    @FXML CheckBox TM;
    @FXML CheckBox TC;
    @FXML CheckBox TV;
    @FXML CheckBox UG;
    @FXML CheckBox UA;
    @FXML CheckBox AE;
    @FXML CheckBox UY;
    @FXML CheckBox UZ;
    @FXML CheckBox VU;
    @FXML CheckBox VE;
    @FXML CheckBox VN;
    @FXML CheckBox VG;
    @FXML CheckBox WF;
    @FXML CheckBox EH;
    @FXML CheckBox YE;
    @FXML CheckBox ZM;
    @FXML CheckBox ZW;
    /*@FXML
    private void handleButtonAction(ActionEvent e) {
        CheckBox[] checkBoxes = {US,AU,CA,GB,AF,AL,DZ,AS,AD,AO,AI,AG,AR,AM,AW,AZ,BS,BH,BD,BB,BY,BE,BZ,BJ,BM,BT,BO,BA,BW,BR,IO,BN,BG,BF,BI,KH,CM,CV,KY,CF,TD,CL,CN,CO,KM,CD,CG,CK,CR,CI,HR,CY,CZ,DK,DJ,DM,DO,EC,EG,SV,GQ,ER,EE,ET,FK,FJ,FI,FR,GF,PF,GA,GM,GE,DE,GH,GI,GR,GL,GD,GP,GU,GT,GG,GN,GW,GY,HT,HN,HK,HU,IS,IN,ID,IE,IL,IT,JM,JP,JE,JO,KZ,KE,KI,KP,KR,KG,LA,LV,LB,LI,LT,LU,MO,MK,MG,MW,MY,MV,ML,MT,MH,MQ,MR,MU,YT,MX,FM,MD,MC,MN,ME,MS,MA,MZ,NA,NR,NP,NL,NC,NZ,NI,NE,NG,NU,NO,OM,PK,PQ,PA,PG,PY,PE,PH,PL,PT,PR,QA,RE,RO,RU,RW,SH,KN,LC,PM,VC,SM,SA,SN,RS,SC,SL,SG,SK,SI,SB,SO,ZA,ES,LK,SR,SZ,SE,CH,TW,TJ,TZ,TH,TG,TO,TT,TN,TR,TM,TC,TV,UG,UA,AE,UY,UZ,VU,VE,VN,VG,WF,EH,YE,ZM,ZW};
        for (CheckBox checkBox : checkBoxes){
            getValueToMap(checkBox);
        }
    }*/

    /*private void initCheckBoxLocation(){
        CheckBox[] checkBoxes = {US,AU,CA,GB,AF,AL,DZ,AS,AD,AO,AI,AG,AR,AM,AW,AZ,BS,BH,BD,BB,BY,BE,BZ,BJ,BM,BT,BO,BA,BW,BR,IO,BN,BG,BF,BI,KH,CM,CV,KY,CF,TD,CL,CN,CO,KM,CD,CG,CK,CR,CI,HR,CY,CZ,DK,DJ,DM,DO,EC,EG,SV,GQ,ER,EE,ET,FK,FJ,FI,FR,GF,PF,GA,GM,GE,DE,GH,GI,GR,GL,GD,GP,GU,GT,GG,GN,GW,GY,HT,HN,HK,HU,IS,IN,ID,IE,IL,IT,JM,JP,JE,JO,KZ,KE,KI,KP,KR,KG,LA,LV,LB,LI,LT,LU,MO,MK,MG,MW,MY,MV,ML,MT,MH,MQ,MR,MU,YT,MX,FM,MD,MC,MN,ME,MS,MA,MZ,NA,NR,NP,NL,NC,NZ,NI,NE,NG,NU,NO,OM,PK,PQ,PA,PG,PY,PE,PH,PL,PT,PR,QA,RE,RO,RU,RW,SH,KN,LC,PM,VC,SM,SA,SN,RS,SC,SL,SG,SK,SI,SB,SO,ZA,ES,LK,SR,SZ,SE,CH,TW,TJ,TZ,TH,TG,TO,TT,TN,TR,TM,TC,TV,UG,UA,AE,UY,UZ,VU,VE,VN,VG,WF,EH,YE,ZM,ZW};
        if (InitCommon.locations.size() > 0){
            for (Location location : InitCommon.locations) {
                for (CheckBox checkBox : checkBoxes) {
                    if (location.getKey().equals(checkBox.getId()))
                        checkBox.setSelected(true);
                }
            }
        }
    }

    private void getValueToMap(CheckBox checkBox){
        if (checkBox != null) {
            if (checkBox.isSelected()) {
                InitCommon.locations.add(new Location(checkBox.getId(), checkBox.getText()));
            } else {
                InitCommon.locations.remove(new Location(checkBox.getId(), checkBox.getText()));
            }
        }
    }

    *//**
     * Sort by
     *//*
    @FXML
    ComboBox cbbSortBy;

    private void initSortBy(){
        if (InitCommon.sortBy == null){
            cbbSortBy.getSelectionModel().selectFirst();
            InitCommon.sortBy = new SortBy(cbbSortBy.getValue().toString());
        } else {
            cbbSortBy.getSelectionModel().select(InitCommon.sortBy.getValue());
        }
    }

    @FXML
    private void sortBySelect(){
        InitCommon.sortBy = new SortBy(cbbSortBy.getSelectionModel().getSelectedItem().toString());
    }

    *//**
     * Result Per Page
     *//*
    @FXML
    ComboBox cbbResultPerPage;

    private void initResultPerPage(){
        if (InitCommon.resultPage == null){
            cbbResultPerPage.getSelectionModel().selectFirst();
            InitCommon.resultPage = new ResultPage(cbbResultPerPage.getValue().toString());
        } else {
            cbbResultPerPage.getSelectionModel().select(InitCommon.resultPage.getValue());
        }
    }

    @FXML
    private void resultPerPageSelect(){
        InitCommon.resultPage = new ResultPage(cbbResultPerPage.getSelectionModel().getSelectedItem().toString());
    }

    *//**
     * Sold
     *//*
    @FXML
    TextField tfSold;

    private void initSold(){
        if (InitCommon.sold != null)
            tfSold.setText(InitCommon.sold.getValue().toString());

        tfSold.textProperty().addListener((observable, oldValue, newValue) -> InitCommon.sold = new Sold(newValue));
    }

    *//**
     * Feedbank
     *//*
    @FXML
    TextField tfFeedbackFrom;
    @FXML
    TextField tfFeedbackTo;

    private void initFeedback(){
        if (InitCommon.feedback.getFrom() != null)
            tfFeedbackFrom.setText(InitCommon.feedback.getFrom().toString());
        if (InitCommon.feedback.getTo() != null)
            tfFeedbackTo.setText(InitCommon.feedback.getTo().toString());

        tfFeedbackFrom.textProperty().addListener((observable, oldValue, newValue) -> InitCommon.feedback = new Feedback(newValue,tfPriceTo.getText()));
        tfFeedbackTo.textProperty().addListener((observable, oldValue, newValue) -> InitCommon.feedback = new Feedback(tfPriceFrom.getText(),newValue));
    }

    *//**
     * Date filt
     *//*
    @FXML
    TextField tfDateFilt;

    private void initDateFilt(){
        if (InitCommon.dateFilt != null)
            tfDateFilt.setText(InitCommon.dateFilt.getValue().toString());

        tfDateFilt.textProperty().addListener((observable, oldValue, newValue) -> InitCommon.dateFilt = new DateFilt(newValue));
    }*/
}
