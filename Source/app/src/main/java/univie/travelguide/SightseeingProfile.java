package univie.travelguide;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import java.util.HashMap;
import java.util.Map;

public class SightseeingProfile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_sightseeing_profile,null);
        SmileRating smileRating = view.findViewById(R.id.smile_rating);


        final TextView tv = view.findViewById(R.id.text_view);
        final ImageView image_sightseeing = view.findViewById(R.id.imageView1);
        final RadioGroup radioGroup = view .findViewById(R.id.radio_group);
        radioGroup.check(Variables.radioButtonClicked);

        image_sightseeing.setImageResource(Variables.sightseeingMap.get(Variables.flag_sightseeing).getImageNumber());
        tv.setText(Variables.sightseeingMap.get(Variables.flag_sightseeing).getDescription());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        Variables.radioButtonClicked = R.id.radio1;
                        image_sightseeing.setImageResource(Variables.sightseeingMap.get(Variables.flag_sightseeing).getImageNumber());
                        tv.setText(Variables.sightseeingMap.get(Variables.flag_sightseeing).getDescription());
                        tv.setCompoundDrawables(null, null,null,null);
                        break;
                    case R.id.radio2:
                        Variables.radioButtonClicked = R.id.radio2;
                        tv.setText("");
                        image_sightseeing.setImageResource(Variables.sightseeingMap.get(Variables.flag_sightseeing).getImageNumber());
                        tv.setText(Variables.sightseeingMap.get(Variables.flag_sightseeing).getAdress());
                        Drawable img = view.getContext().getResources().getDrawable(R.drawable.ic_location_on_black_24dp);
                        img.setBounds(5,6 ,100,100);
                        tv.setCompoundDrawables(img, null,null,null);
                        tv.setMovementMethod(LinkMovementMethod.getInstance());
                        break;
                    case R.id.radio3:
                        Variables.radioButtonClicked = R.id.radio3;
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new ReviewFragment()).addToBackStack("tag");
                        fragmentTransaction.commit();
                }
            }
        });

        final CheckBox checkBox = view.findViewById(R.id.addToFav);

        if(Variables.favouriteSightseeings.contains(Variables.flag_sightseeing)){
            checkBox.setChecked(true);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Variables.favouriteSightseeings.add(Variables.flag_sightseeing);
                }
                if(!isChecked){
                    Variables.favouriteSightseeings.remove(Variables.flag_sightseeing);
                    Toast.makeText(getActivity(), "Added to Saved Sightseeings", Toast.LENGTH_SHORT).show();
                }
            }
        });

        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        if(isLoggedIn()){
                            showFeedbackDialog();
                        } else {
                            showLoginDialog();
                        }
                        break;
                    case SmileRating.GOOD:
                        if(isLoggedIn()){
                            showFeedbackDialog();

                        } else {
                            showLoginDialog();
                        }
                        break;
                    case SmileRating.GREAT:
                        if(isLoggedIn()){
                            showFeedbackDialog();

                        } else {
                            showLoginDialog();
                        }
                        break;
                    case SmileRating.OKAY:
                        if(isLoggedIn()){
                            showFeedbackDialog();

                        } else {
                            showLoginDialog();
                        }
                        break;
                    case SmileRating.TERRIBLE:
                        if(isLoggedIn()){
                            showFeedbackDialog();
                        } else {
                            showLoginDialog();
                        }
                        break;
                }
            }
        });



        return view;
    }

    private boolean isLoggedIn() {
        if(Variables.currentUser.equals("")){
            return false;
        }
            return true;
    }

    private void showFeedbackDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getView().getContext());
        View dialogView = LayoutInflater.from(getView().getContext()).inflate(R.layout.feedback_dialog, null);
        final TextView feedbackContent = (TextView) dialogView.findViewById(R.id.feedback_content);
        builder.setView(dialogView);
        builder.setTitle("Please share your feedback");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String content = feedbackContent.getText().toString();
                Variables.addNewComment(content);
            }
        });
        builder.show();
    }

    private void showLoginDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        View dialogView = LayoutInflater.from(getView().getContext()).inflate(R.layout.login_dialog, null);
        final TextView feedbackName = (TextView) dialogView.findViewById(R.id.feedback_name);
        final TextView feedbackEmail = (TextView) dialogView.findViewById(R.id.feedback_email);

        builder.setView(dialogView);
        builder.setTitle("Login");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String login = feedbackName.getText().toString();
                String password = feedbackEmail.getText().toString();
                if(new LoginFragment().validate(login, password)){
                    new MyAccountFragment().setPersonalData(login);
                    showFeedbackDialog();
                } else {
                    Toast.makeText(getContext(),"Wrong email/password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        builder.show();
    }



}
