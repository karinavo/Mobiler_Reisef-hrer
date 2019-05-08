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
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FavouritesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_favourites_fragment, null);


        RadioGroup radioGroup = view .findViewById(R.id.radio_group);




        String[] restourantTitle = new String[]{
                "Albertina",
                "Belvedere",
                "Hundertwasser"
        };


        String[] restourantDescription = new String[]{
                "Albertina ауцзщауща лцуащлцущащлзцуащл щлцуащлуукцпукцпшщукпцшщцукпшщупщкц шщоупкц опшщукц шощпукцшощпку цошщупкцшощпку цшощупкц ошщ пукцшощ пукцошщупкошщц ",
                "Belvedereцуйайуацулйца лщайцущ йцущлаз",
                "Hundertwasserй цуацайуйуц уйца айуц"
        };
        int[] restourantImage = new int[]{
                R.drawable.albertina
        };




        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", restourantTitle[i]);
            hm.put("listview_discription", restourantDescription[i]);
            hm.put("listview_image", Integer.toString(restourantImage[0]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(view.getContext().getApplicationContext(),
                aList, R.layout.listview_with_image, from, to);
        ListView search = (ListView) view.findViewById(R.id.list_view);


        search.setAdapter(simpleAdapter);



        return view;
    }


}

