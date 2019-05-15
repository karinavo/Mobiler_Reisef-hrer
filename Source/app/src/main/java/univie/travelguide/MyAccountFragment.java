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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toolbar;

public class MyAccountFragment extends Fragment {

    private TextView tvEmail;
    private TextView tvNameSurname;
    private TextView tvBirtdate;

    public static String[] from = {"listview_image", "listview_title", "listview_discription", "listview_smile"};
    public static  int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description, R.id.listview_smile};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_account_fragment, null);
        setHasOptionsMenu(true);
        Variables.fillCommentsForAccount();

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                view.getContext(),
                Variables.commentsForAccount,
                R.layout.listview_favourites,
                from, to);
        ListView search = view.findViewById(R.id.listfeedbackid);
        search.setAdapter(simpleAdapter);


        tvEmail = view.findViewById(R.id.my_acc_email);
        tvNameSurname = view.findViewById(R.id.my_acc_name_surname);
        tvBirtdate = view.findViewById(R.id.my_acc_birthday);
        System.out.println("Email: " + Variables.currentProfile);

        tvEmail.setText(Variables.currentProfile);

        //Build string name and setText for textview NameSurname

        setPersonalData(Variables.currentProfile);
        tvNameSurname.setText(Variables.currentUser);
        tvBirtdate.setText(Variables.currentUserBirthdate);
        return view;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu items for use in the action bar
        inflater.inflate(R.menu.myprofile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_favorite_unchecked){
            Variables.currentUser = "";
            Variables.currentProfile = "";
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new LoginFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        return super.onOptionsItemSelected(item);
    }

//BOOOOOOKMAAARK

//BOOOOOOKMAAARK
//+mymenu.xml in R.menu
//BOOOOOOKMAAARK


    public void setPersonalData(String email) {
        Variables.currentUser = Variables.database.get(email).get(1) + " " + Variables.database.get(email).get(2);
        Variables.currentUserBirthdate = Variables.database.get(email).get(3);
    }
}
