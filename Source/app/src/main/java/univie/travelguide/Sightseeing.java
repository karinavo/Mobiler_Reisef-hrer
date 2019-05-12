package univie.travelguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sightseeing {

    private String description = "";
    private Integer imageNumber = 0;
    private String type = "";
    private List<Map<String, String>> userComments = new ArrayList<>();
    private String adress = "";

    public Sightseeing() { }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Map<String, String>> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<Map<String, String>> userComments) {
        this.userComments = userComments;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Sightseeing(String description, Integer imageNumber, String type, List<Map<String, String>> userComment, String adress){
        this.description = description;
        this.imageNumber = imageNumber;
        this.type = type;
        this.adress = adress;
        this.userComments = userComment;
    }

    public void addComment(Map<String,String> map) {
        this.userComments.add(map);
    }


}