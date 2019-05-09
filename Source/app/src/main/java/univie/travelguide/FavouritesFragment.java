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
        for(Integer i: Variables.favouriteSightseeings){
            final String tempSight = Variables.getSightseeingList().get(i);
            Map<String, String> temp = new TreeMap<>();
            temp.put("listview_image", Integer.toString(Variables.sightseeingWithFoto.get(tempSight)));
            temp.put("listview_title", tempSight);
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


        SimpleAdapter simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(),
                list_of_sightseeings2, R.layout.listview_favourites, Variables.from, Variables.to);
        ListView search = (ListView) view.findViewById(R.id.list_view);


        search.setAdapter(simpleAdapter);



        return view;
    }

    /*
    // get current list of keys
    private ArrayAdapter<String> getAdapter() {
        List<String> keys;
        return new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                keys
        );
    }
*/

}

