package univie.travelguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterFragment extends AppCompatActivity {
    private EditText RegisterEmail;
    private EditText RegisterPassword;
    private Button RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_fragment);

        RegisterEmail = (EditText)findViewById(R.id.et_reg_email);
        RegisterPassword = (EditText)findViewById(R.id.et_reg_password);
        RegisterButton = (Button)findViewById(R.id.btn_register);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register(RegisterEmail.getText().toString(), RegisterPassword.getText().toString());
            }
        });
    }

    private void Register(String email, String password) {
        System.out.println("In REgister method");
        Variables.login_password.put(email, password);
    }
}
