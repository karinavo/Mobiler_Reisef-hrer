package univie.travelguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends AppCompatActivity {

    private EditText EtLogin;
    private EditText Password;
    private Button BtnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fragment);

        EtLogin = (EditText)findViewById(R.id.et_login);
        Password = (EditText)findViewById(R.id.et_password);
        BtnLogin = (Button)findViewById(R.id.btn_login);
    }



    private void validate(String login, String password) {
        if(Variables.login_password.containsKey(login)) {
            if(Variables.login_password.get(login).matches(password)) {
                Intent intent = new Intent(LoginFragment.this, MyAccountFragment.class);
                startActivity(intent);
            }
        }
    }
}
