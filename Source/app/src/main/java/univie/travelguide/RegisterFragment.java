package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterFragment extends Fragment {
    private EditText RegisterEmail;
    private EditText RegisterPassword;
    private EditText RegisterName;
    private EditText RegisterSurname;
    private Spinner SpinnerAge;
    private Button RegisterButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register_fragment, null);

        RegisterEmail = view.findViewById(R.id.et_reg_email);
        RegisterPassword = view.findViewById(R.id.et_reg_password);
        RegisterName = view.findViewById(R.id.et_reg_name);
        RegisterSurname = view.findViewById(R.id.et_reg_surname);
        SpinnerAge = view.findViewById(R.id.spinner_age);
        RegisterButton = view.findViewById(R.id.btn_register);

        List age = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            age.add(Integer.toString(i));
        }
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<Integer>(Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_item, age);
        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        SpinnerAge.setAdapter(spinnerArrayAdapter);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> data = new ArrayList<>();

                data.add(RegisterPassword.getText().toString());
                data.add(RegisterName.getText().toString());
                data.add(RegisterSurname.getText().toString());
                data.add(SpinnerAge.getSelectedItem().toString());


                Register(RegisterEmail.getText().toString(), data);


            }
        });

        return view;
    }

    private void Register(String email, ArrayList<String> data) {
        System.out.println("email: " + email);
        System.out.println("Array: " + data);
        Variables.database.put(email, data);
    }
}
