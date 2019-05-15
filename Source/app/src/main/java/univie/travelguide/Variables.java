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


    public static List<Sightseeing> sightseeingMap = new ArrayList<Sightseeing>(){
        {
            add(new Sightseeing("Albertina","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.albertina, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            add(new Sightseeing("Belvedere", "The Belvedere is a historic building complex in Vienna, Austria, consisting of two Baroque palaces (the Upper and Lower Belvedere), the Orangery, and the Palace Stables. The buildings are set in a Baroque park landscape in the third district of the city, on the south-eastern edge of its centre.", R.drawable.belvedere, "Palace", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Hundertwasser","The Hundertwasserhaus is an apartment house in Vienna, Austria, built after the idea and concept of Austrian artist Friedensreich Hundertwasser with architect Joseph Krawina as a co-creator.", R.drawable.hundertwasser, "Building", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Karlsplatz Museum","With its unique collection of high-quality artworks and historic exhibits, the Wien Museum offers insights into the city's history, from the Neolithic to the present day.", R.drawable.karlsplatz, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Art History Museum","The Kunsthistorisches Museum is an art museum in Vienna, Austria. Housed in its festive palatial building on Ringstraße, it is crowned with an octagonal dome. The term Kunsthistorisches Museum applies to both the institution and the main building. It is the largest art museum in the country. ", R.drawable.kunsthistorisches, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("MAK","The MAK – Austrian Museum of Applied Arts / Contemporary Art is an arts and crafts museum located at Stubenring 5 in Vienna’s 1st district Innere Stadt. Besides its traditional orientation towards arts and crafts and design, the museum especially focuses on architecture and contemporary art.", R.drawable.mak, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Mumok","The museum has a collection of 10,000 modern and contemporary art works, including major works from Andy Warhol, Pablo Picasso, Joseph Beuys, Nam June Paik, Wolf Vostell, Gerhard Richter, Jasper Johns and Roy Lichtenstein.", R.drawable.mumok, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Leopold","The Leopold Museum, housed in the Museumsquartier in Vienna, Austria, is home to one of the largest collections of modern Austrian art, featuring artists such as Egon Schiele, Gustav Klimt, Oskar Kokoschka and Richard Gerstl.It contains the world's largest Egon Schiele Collection. ", R.drawable.leopold, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Augarten","Der Augarten ist ein 52,2 Hektar großer, größtenteils öffentlicher Park der Bundesgärten mit der ältesten barocken Gartenanlage Wiens und befindet sich in der Leopoldstadt, dem zweiten Wiener Gemeindebezirk. ", R.drawable.augarten_park, "Park", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Burgtheater","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.burgtheater, "Theater", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Gasometer","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.gasometer, "Building", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Heeresgeschichtliches Museum","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.heeresgeschichtliches, "Museum", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Hofburg","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.hofburg, "Palace", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Pfarrkirche","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.pfarrkirche, "Church", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Prater Park","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.prater, "Park", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Schoenbrunn","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.schoenbrunn_park, "Park", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Setaya Park","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.setaya_park, "Park", new ArrayList<Map<String, String>>(), getAddress()));
            add( new Sightseeing("Zentral Friedhof","The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings.", R.drawable.zentralfriedhof, "Park", new ArrayList<Map<String, String>>(), getAddress()));
        }};


    public static void setAdminAccount(){
        ArrayList<String> userData = new ArrayList<>();
        userData.add("a");
        userData.add("Max");
        userData.add("Musterman");
        userData.add("10.11.1994");
        database.put("a", userData);
    }

    static public Map<String, ArrayList<String>> database = new HashMap<>();
    static public String flag_sightseeing = "";
    static public List<Map<String,String>> list_of_sightseeings = new ArrayList<>();
    static public Set<String> favouriteSightseeings = new HashSet<>();
    static public Integer radioButtonClicked = R.id.radio1;
    static public String currentUser = "";
    static public String currentUserBirthdate = "";
    static public String currentProfile;
    static public Integer tourCounter = 0;
    static public String tourClicked = "";
    static public Map<String, Integer> sightseeingMemory = new HashMap<>();


    public static List<Tour> toursMap = new ArrayList<Tour>(){
        {
            add(new Tour("Theaters Tour","Experience Vienna's Theaters", R.drawable.opera_tour_photo, fillTours("Theater")));
            add(new Tour("Museums Tour", "Experience Vienna's Museums", R.drawable.museums_tour_photo, fillTours("Museum")));
            add(new Tour("Parks Tour", "Experience Vienna's Parks", R.drawable.parks_tour_photo, fillTours("Park")));
        }
    };


    public static List<Sightseeing> fillTours(String str){
        List<Sightseeing> tempList = new ArrayList<>();
        for(Sightseeing sightseeing: sightseeingMap){
            if(sightseeing.getType().equals(str)){
                tempList.add(sightseeing);
            }
        }
        return tempList;
    }

    static List<Map<String, String>> commentsList = new ArrayList<Map<String, String>>();
    static List<Map<String, String>> commentsForAccount = new ArrayList<Map<String, String>>();


    static Set<String> commentUserName = new HashSet<String>(){
        {
            add("Karina Volobuieva");
            add("Ruslan Jelbuldin");
            add("Hakob Harutunyan");
        }
    };

    static List<String> commentUserFeedback = new ArrayList<String>(){{
        add("It is a nice place");
        add("The worst place in the world!!");
        add("That was OK");
    }};

    static List<Integer> smiles = new ArrayList<Integer>(){{
        add(R.drawable.ic_smile);
        add(R.drawable.ic_smile_angry);
        add(R.drawable.ic_smile_ok);
    }};


    public static Map<String,String> getMapForAdapter (Sightseeing sightseeing){
        Map<String, String> map_of_sightseeings = new HashMap<>();
        map_of_sightseeings.put("listview_title", sightseeing.getTitle());
        map_of_sightseeings.put("listview_discription", sightseeing.getType());
        map_of_sightseeings.put("listview_image", Integer.toString(sightseeing.getImageNumber()));
        return map_of_sightseeings;
    }

    public static void fillSightseeingMap() {
        for(Sightseeing sightseeing: sightseeingMap){
            list_of_sightseeings.add(getMapForAdapter(sightseeing));
        }
    }



    public static void fillCommentsList() {
        List<String> listOfSet = new ArrayList<>(commentUserName);
        for (int i = 0; i < commentUserName.size(); i++) {
            Map<String, String> hm = new HashMap<>();
            hm.put("listview_title", listOfSet.get(i));
            hm.put("listview_discription", commentUserFeedback.get(i));
            hm.put("listview_image", Integer.toString(R.drawable.ic_user));
            hm.put("listview_smile", Integer.toString(smiles.get(i)));
            commentsList.add(hm);
        }
        for(Sightseeing s: sightseeingMap){
            List<Map<String,String>> l = new ArrayList<>(commentsList);
            s.setUserComments(l);
        }
    }

    public static void fillCommentsForAccount() {
        int i = 0;
        for (Sightseeing sightseeing: sightseeingMap) {
            if(i == 3) break;
            Map<String, String> hm = new HashMap<>();
            hm.put("listview_title", sightseeing.getTitle());
            hm.put("listview_discription", commentUserFeedback.get(i));
            hm.put("listview_image", Integer.toString(sightseeing.getImageNumber()));
            hm.put("listview_smile", Integer.toString(smiles.get(i)));
            commentsForAccount.add(hm);
            i++;
        }
        for(Sightseeing s: sightseeingMap){
            List<Map<String,String>> l = new ArrayList<>(commentsList);
            s.setUserComments(l);
        }
    }


    public static Sightseeing getSightseeing(String sight) {
        for(Sightseeing sightseeing: sightseeingMap){
            if(sightseeing.getTitle().equals(sight)){
                return sightseeing;
            }
        }
        return null;
    }

}






