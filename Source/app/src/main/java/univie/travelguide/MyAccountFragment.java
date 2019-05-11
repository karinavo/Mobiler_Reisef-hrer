package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

public class MyAccountFragment extends Fragment {

    private TextView tvEmail;
    private TextView tvNameSurname;
    private TextView tvBirtdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_account_fragment, null);
        setHasOptionsMenu(true);

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


//BOOOOOOKMAAARK
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
            item.setIcon(item.isChecked() ? R.drawable.ic_bookmark_white_24dp : R.drawable.ic_bookmark_border_white_24dp);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//BOOOOOOKMAAARK
//+mymenu.xml in R.menu
//BOOOOOOKMAAARK


    public void setPersonalData(String email) {
        Variables.currentUser = Variables.database.get(email).get(1) + " " + Variables.database.get(email).get(2);
        Variables.currentUserBirthdate = Variables.database.get(email).get(3);
    }
}
