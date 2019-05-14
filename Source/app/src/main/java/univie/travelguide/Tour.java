package univie.travelguide;

public class Tour {
    private String description;
    private Integer imageNumber;

    public Tour(String description, Integer imageNumber) {
        this.description = description;
        this.imageNumber = imageNumber;
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
