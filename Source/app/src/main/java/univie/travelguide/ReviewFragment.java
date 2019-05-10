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

    static List<String> listUserMean = new ArrayList<>();
    static List<String> listUserName = new ArrayList<>();

    static String username;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_review_fragment,null);



        Button sumbit;
        TextInputEditText result;



        //Array to save User Image


            // Add defaul 4 User name and mean, Add once only
                listUserName.add("John Lennon");
                listUserName.add("Paul McCartney");
                listUserName.add("George Harrison");
                listUserName.add("Ringo Starr");
                listUserName.add("Hugo Smith");

                // text source: http://pun.me/pages/
                listUserMean.add("The elevator to success is out of order. You’ll have to use the stairs");
                listUserMean.add("The more you weight the harder you are to kidnap. Stay safe, eat cake.");
                listUserMean.add("If you’re not supposed to eat at night, why is there a light bulb in the refrigerator?");
                listUserMean.add("Last night at dinner we had some fish, and though I tried, I did not finish. My mother told me while I chewed, brains loved fish over all other food.");
                listUserMean.add("My wallet is like an onion. When I open it, it makes me cry.");


            username = "unknown user";


            // List  to save Foto , name and mean from user
            List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

            // Foto name and mean in Map add and then at the and in List
            for (int i = listUserMean.size()-1; i >= 0; i--) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", listUserName.get(i));
                hm.put("listview_discription", listUserMean.get(i));
                hm.put("listview_image", Integer.toString(R.drawable.ic_user));
                aList.add(hm);
            }


            //text_view_for_eatlist is our Shablon that add in ListView in every singel line Foto , name and mean from User
            SimpleAdapter simpleAdapter = new SimpleAdapter(view.getContext(), aList, R.layout.listview_with_image,
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
