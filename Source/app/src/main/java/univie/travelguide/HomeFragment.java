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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment   {
    SearchView searchView;
    LinearLayout linearLayout;
    ScrollView bigScrollview;
    RelativeLayout relativeLayout;
    List<ImageView> images_museums = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment,null);
        searchView = view.findViewById(R.id.searchView);



        final SimpleAdapter simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(),
                Variables.list_of_sightseeings, R.layout.listview_with_image, Variables.from, Variables.to);
        final ListView listView = (ListView) view.findViewById(R.id.list_view);


        listView.setAdapter(simpleAdapter);
        ////IF search is clicable
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                final List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
                    if(Variables.sighseeingWithCategory.keySet().contains(query))
                   /* int id = SightseeingTitle.indexOf(query);
                    listView.removeAllViews();
                    System.out.println("HERE");
                    HashMap<String, String> hmr = new HashMap<String, String>();
                    hmr.put("listview_title", SightseeingTitle.get(id));
                    hmr.put("listview_discription", SightseeingDescription[id]);
                    hmr.put("listview_image", Integer.toString(SightseeingImage[id]));
                    result.add(hmr);
                    String[] from = {"listview_image", "listview_title", "listview_discription"};
                    int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};*/
                    simpleAdapter.getFilter().filter(query);
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile());
              //  InfoSightseeing.flag_sightseeing =  parent.getItemAtPosition(position).toString();
                Variables.itemPosition = position;
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
