package univie.travelguide;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewFragment extends Fragment {


    static String username;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_review_fragment,null);


            Sightseeing sightseeing = Variables.getSightseeing(Variables.flag_sightseeing);
            SimpleAdapter simpleAdapter = new SimpleAdapter(
                    view.getContext(),
                    sightseeing.getUserComments(),
                    R.layout.listview_with_image,
                    Variables.from, Variables.to);
            ListView search = view.findViewById(R.id.listfeedbackid);
            search.setAdapter(simpleAdapter);


        RadioGroup radioGroup = view .findViewById(R.id.radio_group);
        radioGroup.check(Variables.radioButtonClicked);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        Variables.radioButtonClicked = R.id.radio1;
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile()).addToBackStack("tag");
                        fragmentTransaction.commit();
                        break;
                    case R.id.radio2:
                        Variables.radioButtonClicked = R.id.radio2;
                        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new SightseeingProfile()).addToBackStack("tag");
                        fragmentTransaction.commit();
                        break;
                }
            }
        });

        return view;
    }


}
