package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAccountFragment extends Fragment {

    private TextView tvEmail;
    private TextView tvNameSurname;
    private TextView tvBirtdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_account_fragment, null);

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

    public void setPersonalData(String email) {
        Variables.currentUser = Variables.database.get(email).get(1) + " " + Variables.database.get(email).get(2);
        Variables.currentUserBirthdate = Variables.database.get(email).get(3);
    }
}
