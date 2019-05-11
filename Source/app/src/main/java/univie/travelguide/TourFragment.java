package univie.travelguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.validation.Validator;

public class TourFragment extends Fragment {

    private ListView listView;
    private Button createPersonalTour;

    public List<Map<String,String>> tours_listview = new ArrayList<Map<String, String>>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tour_fragment, null);
        listView = view.findViewById(R.id.list_view_tours);

        createPersonalTour = view.findViewById(R.id.button_create_personal_tour);


        final ArrayList<String> tour_titles = new ArrayList<>();

        tour_titles.add("Theaters Tour");
        tour_titles.add("Museums Tour");
        tour_titles.add("Parks Tour");

        ArrayList<String> tour_description = new ArrayList<>();

        tour_description.add("Experience Vienna's Theaters");
        tour_description.add("Experience Vienna's Museums");
        tour_description.add("Experience Vienna's Parks");

        ArrayList<Integer> tour_photos = new ArrayList<>();

        tour_photos.add(R.drawable.opera_tour_photo);
        tour_photos.add(R.drawable.museums_tour_photo);
        tour_photos.add(R.drawable.parks_tour_photo);

        for (int i = 0; i < tour_titles.size(); i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", tour_titles.get(i));
            hm.put("listview_description", tour_description.get(i));
            hm.put("listview_image", Integer.toString(tour_photos.get(i)));
            tours_listview.add(hm);
        }


        SimpleAdapter adapter = new SimpleAdapter(view.getContext().getApplicationContext(),tours_listview, R.layout.listview_with_image, Variables.from, Variables.to);

        listView.setAdapter(adapter);



        createPersonalTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new CreateTourFragment()).addToBackStack("tag");
                fragmentTransaction.commit();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("SUUKA");
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TourProfile());
                fragmentTransaction.addToBackStack("tag");
                Variables.position_of_Tour = position;
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}

