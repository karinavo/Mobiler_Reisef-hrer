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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TourProfile extends Fragment {
    public static SimpleAdapter simpleAdapter;
    public static String[] from = {"listview_image", "listview_title", "listview_day"};
    public static  int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tour_profile, null);
        ListView lv = view.findViewById(R.id.lview);
        List<Map<String,String>> list_of_sightseeing_museum=new ArrayList<Map<String, String>>();
        List<Map<String,String>> list_of_sightseeing_theater=new ArrayList<Map<String, String>>();
        List<Map<String,String>> list_of_sightseeing_parks=new ArrayList<Map<String, String>>();

        setHasOptionsMenu(true);

        final ArrayList<String> museums = new ArrayList<>();
        final ArrayList<String> theaters = new ArrayList<>();
        final ArrayList<String> parks = new ArrayList<>();




        museums.add("Albertina");
        museums.add("Karlsplatz Museum");

        theaters.add("Burgheater");

        parks.add("Prater Park");
        parks.add("Setaya Park");
        parks.add("Augarten");


        ArrayList<String> tour_day_museum = new ArrayList<>();
        ArrayList<String> tour_day_theater = new ArrayList<>();
        ArrayList<String> tour_day_parks = new ArrayList<>();

        tour_day_museum.add("Day 1");
        tour_day_museum.add("Day 2");

        tour_day_theater.add("Day 1");

        tour_day_parks.add("Day 1");
        tour_day_parks.add("Day 2");
        tour_day_parks.add("Day 3");

        ArrayList<Integer> tour_photos_museum= new ArrayList<>();

        tour_photos_museum.add(R.drawable.albertina);
        tour_photos_museum.add(R.drawable.karlsplatz);

        ArrayList<Integer> tour_photos_theater = new ArrayList<>();

        tour_photos_theater.add(R.drawable.burgtheater);

        ArrayList<Integer> tour_photos_parks= new ArrayList<>();

        tour_photos_parks.add(R.drawable.prater);
        tour_photos_parks.add(R.drawable.setaya_park);
        tour_photos_parks.add(R.drawable.augarten_park);
        ////FOR THE LISTVIEW
        for (int i = 0; i < museums.size(); i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", museums.get(i));
            hm.put("listview_day", tour_day_museum.get(i));
            hm.put("listview_image", Integer.toString(tour_photos_museum.get(i)));
            list_of_sightseeing_museum.add(hm);
        }
        for (int i = 0; i < theaters.size(); i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", theaters.get(i));
            hm.put("listview_day", tour_day_theater.get(i));
            hm.put("listview_image", Integer.toString(tour_photos_theater.get(i)));
            list_of_sightseeing_theater.add(hm);
        }

        for (int i = 0; i < parks.size(); i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", parks.get(i));
            hm.put("listview_day", tour_day_parks.get(i));
            hm.put("listview_image", Integer.toString(tour_photos_parks.get(i)));
            list_of_sightseeing_parks.add(hm);
        }




        switch (Variables.position_of_Tour){
            case 0:
                simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(),list_of_sightseeing_theater, R.layout.listview_with_image, from, to);
                lv.setAdapter(simpleAdapter);
                break;
            case 1:
                simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(), list_of_sightseeing_museum, R.layout.listview_with_image, from, to);
                lv.setAdapter(simpleAdapter);
                break;
            case 2:
                simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(), list_of_sightseeing_parks, R.layout.listview_with_image, from, to);
                lv.setAdapter(simpleAdapter);
                break;

        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile());
                fragmentTransaction.addToBackStack("tag");
                Variables.flag_sightseeing = "";
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
            item.setIcon(item.isChecked() ? R.drawable.ic_bookmark_white_24dp : R.drawable.ic_bookmark_border_white_24dp);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        // Inflate the menu items for use in the action bar
//        inflater.inflate(R.menu.mymenu, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.action_favorite_unchecked){
//            item.setChecked(!item.isChecked());
//            item.setIcon(item.isChecked() ? R.drawable.ic_bookmark_white_24dp : R.drawable.ic_bookmark_border_white_24dp);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
