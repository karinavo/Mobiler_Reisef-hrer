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


        for(Tour tour: Variables.toursMap){
            Map<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", tour.getTitle());
            hm.put("listview_discription", tour.getDescription());
            hm.put("listview_image", Integer.toString(tour.getImageNumber()));
            tours_listview.add(hm);
        }


        SimpleAdapter adapter = new SimpleAdapter(view.getContext(),
                tours_listview,
                R.layout.listview_with_image,
                Variables.from,
                Variables.to);

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
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TourProfile());
                fragmentTransaction.addToBackStack("tag");
                String str = parent.getItemAtPosition(position).toString();
                for(Tour tour: Variables.toursMap){
                    if(str.contains(tour.getTitle())){
                        Variables.tourClicked = tour.getTitle();
                        break;
                    }
                }
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}

