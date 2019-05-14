package univie.travelguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FavouritesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_favourites_fragment,  null);

        Set<Map<String,String>> list_of_sightseeings = new HashSet<>();

        for(String i: Variables.favouriteSightseeings){
            Sightseeing sightseeing = Variables.getSightseeing(i);
            if(sightseeing == null){
                System.out.println("I AM HERE = ");
            }
            Map<String, String> temp = new TreeMap<>();
            temp.put("listview_image", Integer.toString(sightseeing.getImageNumber()));
            temp.put("listview_title", i);
            list_of_sightseeings.add(temp);
        }

        List<Map<String,String>> list_of_sightseeings2 = new ArrayList<>(list_of_sightseeings);


        RadioGroup radioGroup = view .findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        System.out.println("TOURS");
                        break;
                    case R.id.radio2:
                        System.out.println("SIGHTSEEINGS");
                        break;
                }
            }
        });


        final SimpleAdapter simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(),
                list_of_sightseeings2, R.layout.listview_favourites, Variables.from, Variables.to);
        ListView search = view.findViewById(R.id.list_view);

        search.setAdapter(simpleAdapter);



        return view;
    }


}

