package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class SightseeingGeneratedList extends Fragment {

    private ListView listViewSights;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_sightseeing_generated_list, null);

        ArrayList<String> titles = new ArrayList<>(Variables.sightseeingWithFoto.keySet());
        ArrayList<Integer> photos = new ArrayList<>(Variables.sightseeingWithFoto.values());
        ArrayList<String> descriptions = new ArrayList<>(Variables.sightseeingDescription.values());

        ArrayList<String> titles_new = new ArrayList<>();
        ArrayList<Integer> photos_new = new ArrayList<>();
        ArrayList<String> descriptions_new = new ArrayList<>();

    //Pick titles from ArrayList titles defined in this scope
        int numberOfElements = 3;
        Random random = new Random();

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = random.nextInt(titles.size());

            String randomElementTitle = titles.get(randomIndex);
            titles_new.add(randomElementTitle);

            String randomElementDescription = descriptions.get(randomIndex);
            descriptions_new.add(randomElementDescription);

            Integer randomElementPhoto = photos.get(randomIndex);
            photos_new.add(randomElementPhoto);

            titles.remove(randomIndex);
        }



        CustomAdapterClass adapter = new CustomAdapterClass(getActivity(), titles_new, descriptions_new, photos_new);

        listViewSights = view.findViewById(R.id.list_view_sights_in_tour);

        listViewSights.setAdapter(adapter);

        System.out.println("List 1 size: " + titles_new.size());
        System.out.println("List 2 size: " + descriptions_new.size());
        System.out.println("List 3 size: " + photos_new.size());


        listViewSights.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile());
                fragmentTransaction.addToBackStack("tag");
                Variables.flag_sightseeing = "";
                //  InfoSightseeing.flag_sightseeing =  parent.getItemAtPosition(position).toString();
                Variables.itemPosition = position;
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}
