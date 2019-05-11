package univie.travelguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    private EditText EtLoginEmail;
    private EditText Password;
    private Button BtnLogin;
    private Button BtnRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login_fragment, null);

        EtLoginEmail = view.findViewById(R.id.et_login_email);
        Password = view.findViewById(R.id.et_password);
        BtnLogin = view.findViewById(R.id.btn_login);
        BtnRegister = view.findViewById(R.id.btn_register);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(EtLoginEmail.getText().toString(), Password.getText().toString())) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new MyAccountFragment()).addToBackStack("tag");
                    fragmentTransaction.commit();
                }
                else {
                    Context context = getContext();
                    Toast toast = Toast.makeText(context, "Wrong login/password!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new RegisterFragment()).addToBackStack("tag");
                fragmentTransaction.commit();
            }
        });

        return view;
    }


    public boolean validate(String login, String password) {
        if(Variables.database.containsKey(login)) {
            if(Variables.database.get(login).get(0).equals(password)){
                Variables.currentProfile = login;
                return true;
            }
        }

        return false;
    }

}
