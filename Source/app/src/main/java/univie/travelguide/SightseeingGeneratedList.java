package univie.travelguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SightseeingGeneratedList extends Fragment {

    private List<Sightseeing> listOfSights = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.activity_sightseeing_generated_list, null);


        List<Map<String,String>> list_of_sightseeings = new ArrayList<>();
        for(Sightseeing sightseeing: Variables.sightseeingMap){
            if(new Random().nextInt(3) == 1) {
                list_of_sightseeings.add(Variables.getMapForAdapter(sightseeing));
                listOfSights.add(sightseeing);
            }
        }


        final SimpleAdapter simpleAdapter = new SimpleAdapter(
                view.getContext(),
                list_of_sightseeings,
                R.layout.listview_with_image,
                Variables.from,
                Variables.to);
        ListView search = view.findViewById(R.id.list_view);

        search.setAdapter(simpleAdapter);




        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu items for use in the action bar
        inflater.inflate(R.menu.mymenu1, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_save_unchecked){
            item.setChecked(!item.isChecked());
            if(item.isChecked()) {
                Tour tour = new Tour(
                        "MyTour " + Variables.tourCounter++,
                        "A Custom Tour",
                        R.drawable.custom_tour);
                for(Sightseeing sightseeing: listOfSights){
                    tour.addSightseeing(sightseeing);
                }
                Variables.toursMap.add( tour);
                item.setIcon(R.drawable.ic_save_black_24dp);
                Variables.favouriteSightseeings.add(Variables.flag_sightseeing);

                Toast.makeText(getActivity(), "Tour saved!", Toast.LENGTH_LONG).show();


                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TourFragment()).addToBackStack("tag");
                fragmentTransaction.commit();
            }
            else {
                item.setIcon(R.drawable.ic_save_black_24dp);
                Variables.favouriteSightseeings.remove(Variables.flag_sightseeing);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
