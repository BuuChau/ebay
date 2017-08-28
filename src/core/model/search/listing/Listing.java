package core.model.search.listing;

import java.io.Serializable;

public class Listing implements Serializable {

    TypeTime typeTime;
    ListHour listHour;

    public TypeTime getTypeTime() {
        return typeTime;
    }

    public ListHour getListHour() {
        return listHour;
    }

    public Listing() {

    }

    public void setTypeTime(TypeTime typeTime) {
        this.typeTime = typeTime;
    }

    public void setListHour(ListHour listHour) {
        this.listHour = listHour;
    }

    public Listing(TypeTime typeTime, ListHour listHour) {

        this.typeTime = typeTime;
        this.listHour = listHour;
    }
}
