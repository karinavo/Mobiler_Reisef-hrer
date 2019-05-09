package univie.travelguide;

import android.app.DatePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.hardware.TriggerEvent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class RegisterFragment extends Fragment {
    private EditText RegisterEmail;
    private EditText RegisterPassword;
    private EditText RegisterName;
    private EditText RegisterSurname;
    private Button RegisterButton;
    private TextView TextViewBirthDate;
    private FloatingActionButton ButtonSet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register_fragment, null);

        RegisterEmail = view.findViewById(R.id.et_reg_email);
        RegisterPassword = view.findViewById(R.id.et_reg_password);
        RegisterName = view.findViewById(R.id.et_reg_name);
        RegisterSurname = view.findViewById(R.id.et_reg_surname);
        RegisterButton = view.findViewById(R.id.btn_register);
        TextViewBirthDate = view.findViewById(R.id.tv_date_of_birth);
        ButtonSet = view.findViewById(R.id.floatingActionButtonSetBirthDate);


        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        final int currentYear = calendar.get(Calendar.YEAR);
        final int currentMonth = calendar.get(Calendar.MONTH) + 1;
        final int currentDay = calendar.get(Calendar.DAY_OF_MONTH);




        TextViewBirthDate.setText(currentDay + "." + currentMonth + "." + currentYear);


        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> data = new ArrayList<>();

                data.add(RegisterPassword.getText().toString());
                data.add(RegisterName.getText().toString());
                data.add(RegisterSurname.getText().toString());
                data.add(TextViewBirthDate.getText().toString());
                Register(RegisterEmail.getText().toString(), data);
            }
        });

    //Calendar
        ButtonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        TextViewBirthDate.setText(day + "." + month + "." + year);
                    }
                }, currentYear, currentMonth, currentDay);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                dialog.show();
            }
        });


    //Calendar


        return view;
    }

    private void Register(String email, ArrayList<String> data) {
        System.out.println("email: " + email);
        System.out.println("Array: " + data);
        Variables.database.put(email, data);
    }
}
