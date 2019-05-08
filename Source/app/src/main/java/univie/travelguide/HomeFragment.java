package univie.travelguide;

import android.content.Context;
import android.content.SyncStatusObserver;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment   {
    SearchView searchView;
    LinearLayout linearLayout;
    ScrollView bigScrollview;
    RelativeLayout relativeLayout;
    List<ImageView> images_museums = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment,null);
        searchView = view.findViewById(R.id.searchView);
        final ArrayList<String> SightseeingTitle = new ArrayList<>();
        SightseeingTitle.add("Albertina");
        SightseeingTitle.add("Belvedere");
        SightseeingTitle.add("Hundertwasser");
        SightseeingTitle.add("Karlsplatz Museum");
        SightseeingTitle.add("Art History Museum");
        SightseeingTitle.add("MAK");
        SightseeingTitle.add("Mumok");
        SightseeingTitle.add("Leopold");


        final String[] SightseeingDescription = new String[]{
                "The Albertina is a museum in the Innere Stadt (First District) of Vienna, Austria. It houses one of the largest and most important print rooms in the world with approximately 65,000 drawings and approximately 1 million old master prints, as well as more modern graphic works, photographs and architectural drawings. Apart from the graphics collection the museum has recently acquired on permanent loan two significant collections of Impressionist and early 20th-century art, some of which will be on permanent display. The museum also houses temporary exhibitions. ",
                "The Belvedere is a historic building complex in Vienna, Austria, consisting of two Baroque palaces (the Upper and Lower Belvedere), the Orangery, and the Palace Stables. The buildings are set in a Baroque park landscape in the third district of the city, on the south-eastern edge of its centre. It houses the Belvedere museum. The grounds are set on a gentle gradient and include decorative tiered fountains and cascades, Baroque sculptures, and majestic wrought iron gates. The Baroque palace complex was built as a summer residence for Prince Eugene of Savoy. ",
                "The Hundertwasserhaus is an apartment house in Vienna, Austria, built after the idea and concept of Austrian artist Friedensreich Hundertwasser with architect Joseph Krawina as a co-creator. ",
                "With its unique collection of high-quality artworks and historic exhibits, the Wien Museum offers insights into the city's history, from the Neolithic to the present day.",
                "The Kunsthistorisches Museum is an art museum in Vienna, Austria. Housed in its festive palatial building on Ringstraße, it is crowned with an octagonal dome. The term Kunsthistorisches Museum applies to both the institution and the main building. It is the largest art museum in the country. ",
                "The MAK – Austrian Museum of Applied Arts / Contemporary Art is an arts and crafts museum located at Stubenring 5 in Vienna’s 1st district Innere Stadt. Besides its traditional orientation towards arts and crafts and design, the museum especially focuses on architecture and contemporary art.",
                "The museum has a collection of 10,000 modern and contemporary art works, including major works from Andy Warhol, Pablo Picasso, Joseph Beuys, Nam June Paik, Wolf Vostell, Gerhard Richter, Jasper Johns and Roy Lichtenstein. Over 230 art works were given to the museum by the German industrialist and art collector Peter Ludwig and his wife Irene in 1981. ",
                "The Leopold Museum, housed in the Museumsquartier in Vienna, Austria, is home to one of the largest collections of modern Austrian art, featuring artists such as Egon Schiele, Gustav Klimt, Oskar Kokoschka and Richard Gerstl.It contains the world's largest Egon Schiele Collection. "
        };
        final int[] SightseeingImage = new int[]{
                R.drawable.albertina,
                R.drawable.belvedere,
                R.drawable.hundertwasser,
                R.drawable.karlsplatz,
                R.drawable.kunsthistorishes,
                R.drawable.mak,
                R.drawable.mumok,
                R.drawable.leopold
        };


        final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < SightseeingTitle.size(); i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", SightseeingTitle.get(i));
            hm.put("listview_discription", SightseeingDescription[i]);
            hm.put("listview_image", Integer.toString(SightseeingImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};

        final SimpleAdapter simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(),
                aList, R.layout.listview_with_image, from, to);
        final ListView listView = (ListView) view.findViewById(R.id.list_view);


        listView.setAdapter(simpleAdapter);
        ////IF search is clicable
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                final List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
                    if(SightseeingTitle.contains(query))
                   /* int id = SightseeingTitle.indexOf(query);
                    listView.removeAllViews();
                    System.out.println("HERE");
                    HashMap<String, String> hmr = new HashMap<String, String>();
                    hmr.put("listview_title", SightseeingTitle.get(id));
                    hmr.put("listview_discription", SightseeingDescription[id]);
                    hmr.put("listview_image", Integer.toString(SightseeingImage[id]));
                    result.add(hmr);
                    String[] from = {"listview_image", "listview_title", "listview_discription"};
                    int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};*/
                    simpleAdapter.getFilter().filter(query);

                    else{
                        Toast.makeText(getActivity(), "No Match found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
                InfoSightseeing.flag_sightseeing =  parent.getItemAtPosition(position).toString();
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
