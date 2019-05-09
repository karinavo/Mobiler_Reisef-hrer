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

        tvEmail.setText("tetr21@gmail.com");

        //Build string name and setText for textview NameSurname

        String name_surname = Variables.database.get(Variables.currentProfile).get(1) + " " + Variables.database.get(Variables.currentProfile).get(2);
        tvNameSurname.setText(name_surname);
        String birthdate = "Date of Birth: " + Variables.database.get(Variables.currentProfile).get(3);
        tvBirtdate.setText(birthdate);
        return view;
    }

}
