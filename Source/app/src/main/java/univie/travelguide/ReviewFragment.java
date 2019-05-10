package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewFragment extends Fragment {

    static boolean isAdded = false; // check if fesdback add
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
        int[] userImage = new int[]{
                //source user_icon: https://icons8.com/icons/set/user-neutral
                R.drawable.albertina,
        };


            // Add defaul 4 User name and mean, Add once only
            if(!isAdded){
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
                isAdded = true;
            }




            //for message wenn user saved feedback
            final int lengthLong = Toast.LENGTH_LONG;
            final String toast = "Thanks for your Feedback!";


            username = "unknown user";


            // List  to save Foto , name and mean from user
            List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

            // Foto name and mean in Map add and then at the and in List
            for (int i = listUserMean.size()-1; i >= 0; i--) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", listUserName.get(i));
                hm.put("listview_discription", listUserMean.get(i));
                hm.put("listview_image", Integer.toString(userImage[0]));
                aList.add(hm);
            }

            //From where in where add all
            String[] from = {"listview_image", "listview_title", "listview_discription"};
            int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};

            //text_view_for_eatlist is our Shablon that add in ListView in every singel line Foto , name and mean from User
            SimpleAdapter simpleAdapter = new SimpleAdapter(view.getContext(), aList, R.layout.listview_favourites, from, to);
            ListView search = view.findViewById(R.id.listfeedbackid);
            search.setAdapter(simpleAdapter);



        return view;
    }
}
