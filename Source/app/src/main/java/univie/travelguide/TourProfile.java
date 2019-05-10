package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class TourProfile extends Fragment {
    public static SimpleAdapter simpleAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tour_profile, null);
        ListView lv = view.findViewById(R.id.lview);
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

        switch (Variables.position_of_Tour){
            case 0:
                CustomAdapterClass adapter1 = new CustomAdapterClass(getActivity(), theaters, tour_day_theater, tour_photos_theater);
                lv.setAdapter(adapter1);
                break;
            case 1:
                CustomAdapterClass adapter2 = new CustomAdapterClass(getActivity(), museums, tour_day_museum, tour_photos_museum);
                lv.setAdapter(adapter2);
                break;
            case 2:
                CustomAdapterClass adapter3 = new CustomAdapterClass(getActivity(), parks, tour_day_parks, tour_photos_parks);
                lv.setAdapter(adapter3);
                break;

        }

        return view;
    }
}
