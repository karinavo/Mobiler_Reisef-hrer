package univie.travelguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Variables {



    public static Map<String, String> sighseeingWithCategory = new TreeMap<String,String>() {
        {
            put("Albertina", "Museum");
            put("Belvedere", "Museum");
            put("Hundertwasser", "Museum");
            put("Karlsplatz Museum", "Museum");
            put("Art History Museum", "Museum");
            put("MAK", "Museum");
            put("Mumok", "Museum");
            put("Leopold", "Museum");
        }
    };

    public static Map<String, Integer> sightseeingWithFoto = new TreeMap<String,Integer>() {
        {
            put("Albertina", R.drawable.albertina );
            put("Belvedere", R.drawable.belvedere);
            put("Hundertwasser", R.drawable.hundertwasser);
            put("Karlsplatz Museum", R.drawable.karlsplatz);
            put("Art History Museum", R.drawable.kunsthistorishes);
            put("MAK", R.drawable.mak);
            put("Mumok", R.drawable.mumok);
            put("Leopold", R.drawable.leopold);
        }
    };

    public static List<String> list = new ArrayList<String>();



    final static String[] sightseeingDescription = new String[]{
            "The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings. Apart from the graphics collection the museum has recently acquired on permanent loan two significant collections of Impressionist and early 20th-century art, some of which will be on permanent display. The museum also houses temporary exhibitions. ",
            "The Belvedere is a historic building complex in Vienna, Austria, consisting of two Baroque palaces (the Upper and Lower Belvedere), the Orangery, and the Palace Stables. The buildings are set in a Baroque park landscape in the third district of the city, on the south-eastern edge of its centre. It houses the Belvedere museum. The grounds are set on a gentle gradient and include decorative tiered fountains and cascades, Baroque sculptures, and majestic wrought iron gates. The Baroque palace complex was built as a summer residence for Prince Eugene of Savoy. ",
            "The Hundertwasserhaus is an apartment house in Vienna, Austria, built after the idea and concept of Austrian artist Friedensreich Hundertwasser with architect Joseph Krawina as a co-creator. ",
            "With its unique collection of high-quality artworks and historic exhibits, the Wien Museum offers insights into the city's history, from the Neolithic to the present day.",
            "The Kunsthistorisches Museum is an art museum in Vienna, Austria. Housed in its festive palatial building on Ringstraße, it is crowned with an octagonal dome. The term Kunsthistorisches Museum applies to both the institution and the main building. It is the largest art museum in the country. ",
            "The MAK – Austrian Museum of Applied Arts / Contemporary Art is an arts and crafts museum located at Stubenring 5 in Vienna’s 1st district Innere Stadt. Besides its traditional orientation towards arts and crafts and design, the museum especially focuses on architecture and contemporary art.",
            "The museum has a collection of 10,000 modern and contemporary art works, including major works from Andy Warhol, Pablo Picasso, Joseph Beuys, Nam June Paik, Wolf Vostell, Gerhard Richter, Jasper Johns and Roy Lichtenstein. Over 230 art works were given to the museum by the German industrialist and art collector Peter Ludwig and his wife Irene in 1981. ",
            "The Leopold Museum, housed in the Museumsquartier in Vienna, Austria, is home to one of the largest collections of modern Austrian art, featuring artists such as Egon Schiele, Gustav Klimt, Oskar Kokoschka and Richard Gerstl.It contains the world's largest Egon Schiele Collection. "
    };



    final static String[] opening_hours = new String[]{
            "Adresse: Albertinaplatz 1, 1010 Wien"+'\n'+
                    "Öffnungszeiten: Montag	10:00–18:00 Dienstag	10:00–18:00 Mittwoch	10:00–21:00 Donnerstag	10:00–18:00 Freitag	10:00–21:00 Samstag	10:00–18:00 Sonntag	10:00–18:00",
            "Adresse: Prinz-Eugen-Straße 27, 1030 Wien\n" +
                    "Öffnungszeiten:\n" +
                    "Donnerstag\t09:00–18:00\n" +
                    "Freitag\t09:00–21:00\n" +
                    "Samstag\t09:00–18:00\n" +
                    "Sonntag\t09:00–18:00\n" +
                    "Montag\t09:00–18:00\n" +
                    "Dienstag\t09:00–18:00\n" +
                    "Mittwoch\t09:00–18:00",
            "Daily 10:00-18:00",
            "Tuesday to Sunday and public holidays,\n" +
                    "10 a.m. to 6 p.m.\n" +
                    "Closed until further notice! ",
            "Tue – Sun, 10 a.m. – 6 p.m.\n" +
                    "Thu, 10 a.m. – 9 p.m.\n" +
                    "\n" +
                    "June - August and 15.10.2019 - 19.1.2020 open daily",
            "Tue 10 a.m.–10 p.m.\n" +
                    "Wed–Sun 10 a.m.–6 p.m.\n" +
                    "Mon closed",
            "Monday: 14:00–19:00\n" +
                    "Tuesday to Sunday: 10:00–19:00\n" +
                    "Thursday: 10:00–21:00",
            "Daily except Tuesday: 10 am to 6 pm\n" +
                    "Thursdays: 10 am to 9 pm\n" +
                    "June, July, August: Open daily!"
    };

    static public Map<String, ArrayList<String>> database = new HashMap<>();
    static public Map<String, String> login_password = new HashMap<>();
    static public String flag_sightseeing = "";
    static public List<Map<String,String>> list_of_sightseeings = new ArrayList<>();
    static public Integer itemPosition = 0;


    static public List<String>  getSightseeingList() {
        List<String> title = new ArrayList<>(sighseeingWithCategory.keySet());
        return title;
    }

    public static void fillSightseeingMap() {
        List<String> title = new ArrayList<>(sighseeingWithCategory.keySet());
        for(int i = 0; i < sighseeingWithCategory.size(); i++) {
            Map<String, String> map_of_sightseeings = new HashMap<>();
            map_of_sightseeings.put("listview_title", title.get(i));
            map_of_sightseeings.put("listview_discription", sighseeingWithCategory.get(title.get(i)));
            map_of_sightseeings.put("listview_image", Integer.toString(sightseeingWithFoto.get(title.get(i))));
            list_of_sightseeings.add(map_of_sightseeings);

        }
    }



    public static String[] from = {"listview_image", "listview_title", "listview_discription"};
    public static  int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};











}
