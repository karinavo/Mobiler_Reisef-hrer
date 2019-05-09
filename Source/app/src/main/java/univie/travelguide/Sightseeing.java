package univie.travelguide;

public class Sightseeing {

    private String title = "";
    private String description = "";
    private Integer imageNumber = 0;

    public Sightseeing() {

    }

    public Sightseeing(String title, String description, Integer imageNumber){
        this.description = description;
        this.title = title;
        this.imageNumber = imageNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
