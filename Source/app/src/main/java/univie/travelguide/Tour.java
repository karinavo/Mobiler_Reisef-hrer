package univie.travelguide;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    private String description;
    private Integer imageNumber;
    private String title;

    public List<Sightseeing> getListOfSightseeings() {
        return listOfSightseeings;
    }

    public void setListOfSightseeings(List<Sightseeing> listOfSightseeings) {
        this.listOfSightseeings = listOfSightseeings;
    }

    private List<Sightseeing> listOfSightseeings = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tour(String title, String description, Integer imageNumber) {
        this.title = title;
        this.description = description;
        this.imageNumber = imageNumber;
    }

    public Tour(String title, String description, Integer imageNumber, List<Sightseeing> sightseeings) {
        this.title = title;
        this.listOfSightseeings = sightseeings;
        this.description = description;
        this.imageNumber = imageNumber;
    }

    public void addSightseeing(Sightseeing sightseeing){
        listOfSightseeings.add(sightseeing);
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(Integer imageNumber) {
        this.imageNumber = imageNumber;
    }
}
