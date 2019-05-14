package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TourProfile extends Fragment {
    public static SimpleAdapter simpleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tour_profile, null);
        ListView lv = view.findViewById(R.id.lview);
        final TextView tv = view.findViewById(R.id.textView22);


        setHasOptionsMenu(true);
        List<Map<String,String>> list_of_sightseeing = new ArrayList<>();
        int dayCount = 1;
        int gesamtCount = 0;

        for(Tour tour: Variables.toursMap){
            if(tour.getTitle().equals(Variables.tourClicked)){
                for(Sightseeing sightseeing: tour.getListOfSightseeings()){
                    HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", sightseeing.getTitle());
                hm.put("listview_discription", "Day " + (new Random().nextInt(2) == 1 ? dayCount++ : dayCount));
                hm.put("listview_image", Integer.toString(sightseeing.getImageNumber()));
                    list_of_sightseeing.add(hm);

                    gesamtCount++;
            }
            }
        }

        String text = "Duration: " + gesamtCount * 2 + " hours.";
        tv.setText(text);



        simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(),
                list_of_sightseeing,
                R.layout.listview_with_image,
                Variables.from,
                Variables.to);
        lv.setAdapter(simpleAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile());
                fragmentTransaction.addToBackStack("tag");
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu items for use in the action bar
        inflater.inflate(R.menu.mymenu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_favorite_unchecked){
            item.setChecked(!item.isChecked());
            if(item.isChecked()) {
                item.setIcon(R.drawable.ic_bookmark_white_24dp);
                Variables.favouriteSightseeings.add(Variables.flag_sightseeing);
            }
            else {
                item.setIcon(R.drawable.ic_bookmark_border_white_24dp);
                Variables.favouriteSightseeings.remove(Variables.flag_sightseeing);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
