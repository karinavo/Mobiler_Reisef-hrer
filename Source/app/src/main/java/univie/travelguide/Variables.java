package univie.travelguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Variables {


    private static String getAddress() {
        return "Adresse: Prinz-Eugen-Straße 27, 1030 Wien\n" +
                "Öffnungszeiten:\n" +
                "Mon-Sun\t09:00–18:00\n" ;
    }


    public static String[] from = {"listview_image", "listview_title", "listview_discription"};
    public static  int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};


    public static Map<String, Sightseeing> sightseeingMap = new TreeMap<String, Sightseeing>(){
        {
            put("Albertina", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.albertina, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            put("Belvedere", new Sightseeing("The Belvedere is a historic building complex in Vienna, Austria, consisting of two Baroque palaces (the Upper and Lower Belvedere), the Orangery, and the Palace Stables. The buildings are set in a Baroque park landscape in the third district of the city, on the south-eastern edge of its centre.", R.drawable.belvedere, "Palace", new ArrayList<Map<String, String>>(), getAddress()));
            put("Hundertwasser", new Sightseeing("The Hundertwasserhaus is an apartment house in Vienna, Austria, built after the idea and concept of Austrian artist Friedensreich Hundertwasser with architect Joseph Krawina as a co-creator.", R.drawable.hundertwasser, "Building", new ArrayList<Map<String, String>>(), getAddress()));
            put("Karlsplatz Museum", new Sightseeing("With its unique collection of high-quality artworks and historic exhibits, the Wien Museum offers insights into the city's history, from the Neolithic to the present day.", R.drawable.karlsplatz, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            put("Art History Museum", new Sightseeing("The Kunsthistorisches Museum is an art museum in Vienna, Austria. Housed in its festive palatial building on Ringstraße, it is crowned with an octagonal dome. The term Kunsthistorisches Museum applies to both the institution and the main building. It is the largest art museum in the country. ", R.drawable.kunsthistorisches, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            put("MAK", new Sightseeing("The MAK – Austrian Museum of Applied Arts / Contemporary Art is an arts and crafts museum located at Stubenring 5 in Vienna’s 1st district Innere Stadt. Besides its traditional orientation towards arts and crafts and design, the museum especially focuses on architecture and contemporary art.", R.drawable.mak, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            put("Mumok", new Sightseeing("The museum has a collection of 10,000 modern and contemporary art works, including major works from Andy Warhol, Pablo Picasso, Joseph Beuys, Nam June Paik, Wolf Vostell, Gerhard Richter, Jasper Johns and Roy Lichtenstein.", R.drawable.mumok, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            put("Leopold", new Sightseeing("The Leopold Museum, housed in the Museumsquartier in Vienna, Austria, is home to one of the largest collections of modern Austrian art, featuring artists such as Egon Schiele, Gustav Klimt, Oskar Kokoschka and Richard Gerstl.It contains the world's largest Egon Schiele Collection. ", R.drawable.leopold, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            put("Augarten", new Sightseeing("Der Augarten ist ein 52,2 Hektar großer, größtenteils öffentlicher Park der Bundesgärten mit der ältesten barocken Gartenanlage Wiens und befindet sich in der Leopoldstadt, dem zweiten Wiener Gemeindebezirk. ", R.drawable.augarten_park, "Park", new ArrayList<Map<String, String>>(), getAddress()));
            put("Burgtheater", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.burgtheater, "Theater", new ArrayList<Map<String, String>>(), getAddress()));
            put("Gasometer", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.gasometer, "Building", new ArrayList<Map<String, String>>(), getAddress()));
            put("Heeresgeschichtliches Museum", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.heeresgeschichtliches, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            put("Hofburg", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.hofburg, "Palace", new ArrayList<Map<String, String>>(), getAddress()));
            put("Pfarrkirche", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.pfarrkirche, "Church", new ArrayList<Map<String, String>>(), getAddress()));
            put("Prater Park", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.prater, "Park", new ArrayList<Map<String, String>>(), getAddress()));
            put("Schoenbrunn", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.schoenbrunn_park, "Park", new ArrayList<Map<String, String>>(), getAddress()));
            put("Setaya Park", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.setaya_park, "Park", new ArrayList<Map<String, String>>(), getAddress()));
            put("Zentral Friedhof", new Sightseeing("The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.zentralfriedhof, "Park", new ArrayList<Map<String, String>>(), getAddress()));
        }};


    static public Map<String, ArrayList<String>> database = new HashMap<>();
    static public String flag_sightseeing = "";
    static public List<Map<String,String>> list_of_sightseeings = new ArrayList<>();
    static public Set<String> favouriteSightseeings = new HashSet<>();
    static public Integer radioButtonClicked = R.id.radio1;
    static public String currentUser = "";
    static public String currentUserBirthdate = "";
    static public String currentProfile;


    static List<Map<String, String>> commentsList = new ArrayList<Map<String, String>>();

    static List<String> commentUserName = new ArrayList<String>(){
        {
            add("Karina Volobuieva");
            add("Ruslan Jelbuldin");
            add("Hakob Harutunyan");
        }
    };

    static List<String> commentUserFeedback = new ArrayList<String>(){{
        add("It is a nice place");
    }};


    static public Integer position_of_Tour =0;

    static public List<String>  getSightseeingList() {
        List<String> title = new ArrayList<>(sightseeingMap.keySet());
        return title;
    }

    static public List<String>  getDesription() {
        List<String> desc = new ArrayList<>();
        for(String sightseeing: sightseeingMap.keySet()){
            desc.add(sightseeingMap.get(sightseeing).getType());
        }
        return desc;
    }

    static public List<Integer> getFotos() {
        List<Integer> fotos = new ArrayList<>();
        for(String sightseeing: sightseeingMap.keySet()){
            fotos.add(sightseeingMap.get(sightseeing).getImageNumber());
        }
        return fotos;
    }



    public static void fillSightseeingMap() {
        List<String> title = new ArrayList<>(sightseeingMap.keySet());
        for(int i = 0; i < sightseeingMap.size(); i++) {
            Map<String, String> map_of_sightseeings = new HashMap<>();
            map_of_sightseeings.put("listview_title", title.get(i));
            map_of_sightseeings.put("listview_discription", getDesription().get(i));
            map_of_sightseeings.put("listview_image", Integer.toString(getFotos().get(i)));
            list_of_sightseeings.add(map_of_sightseeings);
        }
    }

    public static void fillCommentsList() {
        for (int i = 0; i < commentUserName.size(); i++) {
            Map<String, String> hm = new HashMap<>();
            hm.put("listview_title", commentUserName.get(i));
            hm.put("listview_discription", commentUserFeedback.get(0));
            hm.put("listview_image", Integer.toString(R.drawable.ic_user));
            commentsList.add(hm);
        }

        for(String s: sightseeingMap.keySet()){
            sightseeingMap.get(s).setUserComments(commentsList);
        }
    }

    public static void addNewComment(String message) {
        Map<String, String> hm = new HashMap<>();
        hm.put("listview_title", currentUser);
        hm.put("listview_discription", message);
        hm.put("listview_image", Integer.toString(R.drawable.ic_user));
        sightseeingMap.get(flag_sightseeing).addComment(hm);
    }

}






