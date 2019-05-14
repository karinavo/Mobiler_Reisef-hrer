package univie.travelguide;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SightseeingGeneratedList extends Fragment {

    private ListView listViewSights;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.activity_sightseeing_generated_list, null);


        /*
        List<String> titles = new ArrayList<>(Variables.sightseeingMap);

        ArrayList<String> titles_new = new ArrayList<>();
        ArrayList<Integer> photos_new = new ArrayList<>();
        ArrayList<String> descriptions_new = new ArrayList<>();

    //Pick titles from ArrayList titles defined in this scope
        int numberOfElements = 3;
        List<Integer> randomList = new ArrayList<>();
        while(randomList.size() != 3){
            int randomIndex = new Random().nextInt(titles.size());
            if(!randomList.contains(randomIndex)) randomList.add(randomIndex);
        }

        List<String > tempList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            System.out.println("TOUR = " + Variables.t);
            String randomElementTitle = titles.get(randomList.get(i));
            titles_new.add(randomElementTitle);
            tempList.add(randomElementTitle);

            String randomElementDescription = Variables.sightseeingMap.get(titles.get(randomList.get(i))).getDescription();
            descriptions_new.add(randomElementDescription);

            Integer randomElementPhoto = Variables.sightseeingMap.get(titles.get(randomList.get(i))).getImageNumber();
            photos_new.add(randomElementPhoto);
        }
        Variables.createdTourList.add(tempList);


        descriptions_new.add("Day 1");
        descriptions_new.add("Day 1");
        descriptions_new.add("Day 2");



        CustomAdapterClass adapter = new CustomAdapterClass(getActivity(), titles_new, descriptions_new, photos_new);

        listViewSights = view.findViewById(R.id.list_view_sights_in_tour);

        listViewSights.setAdapter(adapter);



        listViewSights.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile());
                fragmentTransaction.addToBackStack("tag");
                Variables.flag_sightseeing = "";
                //  InfoSightseeing.flag_sightseeing =  parent.getItemAtPosition(position).toString();
                fragmentTransaction.commit();
            }
        });

*/
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
                Variables.toursMap.put("MyTour " + Variables.tourCounter++, new Tour("A Custom Tour", R.drawable.custom_tour));


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
