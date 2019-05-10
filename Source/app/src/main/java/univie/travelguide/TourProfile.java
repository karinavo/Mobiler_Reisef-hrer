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
        simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(),
                Variables.list_of_sightseeings, R.layout.listview_with_image, Variables.from, Variables.to);

     /*   switch (Variables.position_of_Tour){
            case 0:
                simpleAdapter.

        }*/

        return view;
    }
}
