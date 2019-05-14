package univie.travelguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
                break;
            }
            Map<String, String> temp = new TreeMap<>();
            temp.put("listview_image", Integer.toString(sightseeing.getImageNumber()));
            temp.put("listview_discription", sightseeing.getType());
            temp.put("listview_title", i);
            list_of_sightseeings.add(temp);
        }

        List<Map<String,String>> list_of_sightseeings2 = new ArrayList<>(list_of_sightseeings);
        if(list_of_sightseeings2.isEmpty()){
            TextView textView = view.findViewById(R.id.text_view_id);
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setTextSize(30);
            String str = "There is nothing saved here";
            textView.setText(str);
        }


        final SimpleAdapter simpleAdapter = new SimpleAdapter(
                view.getContext(),
                list_of_sightseeings2,
                R.layout.listview_with_image,
                Variables.from,
                Variables.to);
        ListView listView = view.findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile());
                fragmentTransaction.addToBackStack("tag");
                Variables.flag_sightseeing = "";


                String str = parent.getItemAtPosition(position).toString();
                for(Sightseeing sightseeing: Variables.sightseeingMap){
                    if(str.contains(sightseeing.getTitle())){
                        Variables.flag_sightseeing = sightseeing.getTitle();
                    }
                }
                fragmentTransaction.commit();
            }
        });



        listView.setAdapter(simpleAdapter);



        return view;
    }


}

