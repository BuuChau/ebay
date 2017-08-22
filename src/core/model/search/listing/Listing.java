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

    public Listing(TypeTime typeTime, ListHour listHour) {

        this.typeTime = typeTime;
        this.listHour = listHour;
    }
}
