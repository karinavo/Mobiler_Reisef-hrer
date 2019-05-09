package univie.travelguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    final static int[] sightseeingImage = new int[]{
            R.drawable.albertina,
            R.drawable.belvedere,
            R.drawable.hundertwasser,
            R.drawable.karlsplatz,
            R.drawable.kunsthistorishes,
            R.drawable.mak,
            R.drawable.mumok,
            R.drawable.leopold
    };


    static public Map<String, ArrayList<String>> database = new HashMap<>();
    static public Map<String, String> login_password = new HashMap<>();
    static public String flag_sightseeing = "";
    static public List<Map<String,String>> list_of_sightseeings = new ArrayList<>();


    public static void fillSightseeingMap() {
        List<String> title = new ArrayList<>(sighseeingWithCategory.keySet());
        for(int i = 0; i < sighseeingWithCategory.size(); i++) {
            Map<String, String> map_of_sightseeings = new HashMap<>();
            map_of_sightseeings.put("listview_title", title.get(i));
            map_of_sightseeings.put("listview_discription", sighseeingWithCategory.get(title.get(i)));
            map_of_sightseeings.put("listview_image", Integer.toString(sightseeingImage[i]));
            list_of_sightseeings.add(map_of_sightseeings);

        }
    }


    public static String[] from = {"listview_image", "listview_title", "listview_discription"};
    public static  int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};











}
