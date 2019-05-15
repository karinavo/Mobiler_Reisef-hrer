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
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment   {
    SimpleAdapter simpleAdapter;
   private  List<Map<String,String>> list_of_sightseeings = Variables.list_of_sightseeings;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment,null);
        SearchView searchView = view.findViewById(R.id.searchView);
        final Spinner cat = view.findViewById(R.id.category);




        simpleAdapter = new SimpleAdapter(
                view.getContext(),
                list_of_sightseeings,
                R.layout.listview_with_image,
                Variables.from,
                Variables.to);
        final ListView listView = view.findViewById(R.id.list_view);


        listView.setAdapter(simpleAdapter);
        ////IF search is clickable
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                final List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
                boolean containsKey = false;
                for(Sightseeing sightseeing: Variables.sightseeingMap) {
                    String key = sightseeing.getTitle();
                    if(key.toUpperCase().contains(query.toUpperCase())){
                        containsKey = true;
                        break;
                    }
                }
                    if(containsKey) {
                        simpleAdapter.getFilter().filter(query);
                    }
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
        //CATEGORY SPINNER
        cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //list_of_sightseeings.clear();
                switch(position){
                    case 0:
                       setAdapter(listView, simpleAdapter);
                        break;
                    case 1:
                        setAdapter(listView, getAdapter(view, "Museum"));
                        break;
                    case 2:
                        setAdapter(listView, getAdapter(view, "Building"));
                        break;
                    case 3:
                        setAdapter(listView, getAdapter(view, "Park"));
                        break;
                    case 4:
                        setAdapter(listView, getAdapter(view, "Church"));
                        break;
                    case 5:
                        setAdapter(listView, getAdapter(view, "Palace"));
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile());
                fragmentTransaction.addToBackStack(null);
                Variables.flag_sightseeing = "";

                String str = parent.getItemAtPosition(position).toString();
                for(Sightseeing sightseeing: Variables.sightseeingMap){
                    if(str.contains(sightseeing.getTitle())){
                        Variables.flag_sightseeing = sightseeing.getTitle();
                    }
                }
                fragmentTransaction.commit();

        }});

        return view;
    }


    SimpleAdapter getAdapter(View view,String type){
        List<Map<String,String>> sights = new ArrayList<>();
        for(Sightseeing sightseeing: Variables.sightseeingMap){
            if(sightseeing.getType().equals(type)){
                sights.add(Variables.getMapForAdapter(sightseeing));
            }
        }
          return new SimpleAdapter(
                view.getContext(),
                sights,
                R.layout.listview_with_image,
                Variables.from,
                Variables.to);
    }

    public void setAdapter(ListView lv, SimpleAdapter sa){
        lv.setAdapter(sa);
    }

}
