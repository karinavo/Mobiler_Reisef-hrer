package univie.travelguide;

import android.app.DatePickerDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class RegisterFragment extends Fragment {
    private EditText RegisterEmail;
    private EditText RegisterPassword;
    private EditText RegisterName;
    private EditText RegisterSurname;
    private Button RegisterButton;
    private ImageButton ButtonSet;
    private Button ButtonCancel;
    private EditText Birthday;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register_fragment, null);

        RegisterEmail = view.findViewById(R.id.et_reg_email);
        RegisterPassword = view.findViewById(R.id.et_reg_password);
        RegisterName = view.findViewById(R.id.et_reg_name);
        RegisterSurname = view.findViewById(R.id.et_reg_surname);
        RegisterButton = view.findViewById(R.id.btn_register);
        ButtonCancel = view.findViewById(R.id.btn_cancel);

        //Calrendar new

//        final EditText Birthday;
        final DatePickerDialog[] picker = new DatePickerDialog[1];

        Birthday = view.findViewById(R.id.et_date_of_birth);
        Birthday.setInputType(InputType.TYPE_NULL);
        Birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker[0] = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Dialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Birthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker[0].show();
            }
        });

        //calendar new end

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RegisterPassword.getText().toString().isEmpty() || RegisterName.getText().toString().isEmpty()
                        || RegisterSurname.getText().toString().isEmpty() || Birthday.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(), "You left some field(s) empty!", Toast.LENGTH_LONG).show();
                }
                if(2019 - parseInt(Birthday.getText().toString().substring(Birthday.getText().toString().length()-4)) < 18)
                {
                    Toast.makeText(getActivity(), "You must be older 18!", Toast.LENGTH_LONG).show();
                }
                else {
                    ArrayList<String> data = new ArrayList<>();

                    data.add(RegisterPassword.getText().toString());
                    data.add(RegisterName.getText().toString());
                    data.add(RegisterSurname.getText().toString());
                    data.add(Birthday.getText().toString());
                    Register(RegisterEmail.getText().toString(), data);
                }
            }
        });

        ButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new LoginFragment()).addToBackStack("tag");
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    private void Register(String email, ArrayList<String> data) {
        System.out.println("email: " + email);
        System.out.println("Array: " + data);
        Variables.database.put(email, data);

        Toast.makeText(getActivity(), "Successfully Signed Up!", Toast.LENGTH_SHORT).show();

        if(new LoginFragment().validate(email,data.get(0))) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new MyAccountFragment()).addToBackStack("tag");
            fragmentTransaction.commit();
        }
    }
}
