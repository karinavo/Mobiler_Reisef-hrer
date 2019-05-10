package univie.travelguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.validation.Validator;

public class TourFragment extends Fragment {

    private ListView listView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tour_fragment, null);

        ArrayList<Integer> photos = new ArrayList<>(Variables.sightseeingWithFoto.values());

        ArrayList<String> titles = new ArrayList<>(Variables.sightseeingWithFoto.keySet());

        ArrayList<String> descriptions = new ArrayList<>(Variables.sightseeingDescription.values());


        CustomAdapterClass adapter = new CustomAdapterClass(getActivity(), titles, descriptions, photos);

        listView = view.findViewById(R.id.list_view_tours);

        listView.setAdapter(adapter);



        return view;
    }
}

