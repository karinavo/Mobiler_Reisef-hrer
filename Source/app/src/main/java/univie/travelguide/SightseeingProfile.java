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

    Integer smile_number = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_sightseeing_profile,null);
        final SmileRating smileRating = view.findViewById(R.id.smile_rating);


        final TextView tv = view.findViewById(R.id.text_view);
        final ImageView image_sightseeing = view.findViewById(R.id.imageView1);
        final RadioGroup radioGroup = view .findViewById(R.id.radio_group);
        final ImageView im_map = view.findViewById(R.id.map);
        if(Variables.sightseeingMemory.containsKey(Variables.flag_sightseeing)){
            radioGroup.check(Variables.sightseeingMemory.get(Variables.flag_sightseeing));
            Variables.radioButtonClicked = Variables.sightseeingMemory.get(Variables.flag_sightseeing);
        } else {
            Variables.sightseeingMemory.put(Variables.flag_sightseeing, R.id.radio1);
            Variables.radioButtonClicked = Variables.sightseeingMemory.get(Variables.flag_sightseeing);

        }
        final Sightseeing sightseeing = Variables.getSightseeing(Variables.flag_sightseeing);


        if(Variables.radioButtonClicked.equals(R.id.radio1)){
            im_map.setVisibility(View.INVISIBLE);
            Variables.radioButtonClicked = R.id.radio1;
            image_sightseeing.setImageResource(sightseeing.getImageNumber());
            tv.setText(sightseeing.getDescription());
        } else if(Variables.radioButtonClicked.equals(R.id.radio2)){
            im_map.setVisibility(View.VISIBLE);
            Variables.radioButtonClicked = R.id.radio2;
            tv.setText("");
            image_sightseeing.setImageResource(sightseeing.getImageNumber());
            tv.setText(sightseeing.getAdress());
            im_map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new MapFragment()).addToBackStack("tag");
                    fragmentTransaction.commit();
                }
            });
        } else {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new ReviewFragment()).addToBackStack("tag");
            fragmentTransaction.commit();
        }



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        Variables.sightseeingMemory.put(Variables.flag_sightseeing, R.id.radio1);
                        im_map.setVisibility(View.INVISIBLE);
                        Variables.radioButtonClicked = R.id.radio1;
                        image_sightseeing.setImageResource(sightseeing.getImageNumber());
                        tv.setText(sightseeing.getDescription());                        break;
                    case R.id.radio2:
                        Variables.sightseeingMemory.put(Variables.flag_sightseeing, R.id.radio2);
                        im_map.setVisibility(View.VISIBLE);
                        Variables.radioButtonClicked = R.id.radio2;
                        tv.setText("");
                        image_sightseeing.setImageResource(sightseeing.getImageNumber());
                        tv.setText(sightseeing.getAdress());
                        im_map.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragment_container, new MapFragment()).addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        });                        break;
                    case R.id.radio3:
                        Variables.sightseeingMemory.put(Variables.flag_sightseeing, R.id.radio3);
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new ReviewFragment()).addToBackStack(null);

                        fragmentTransaction.commit();                }
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
                        smile_number = R.drawable.ic_dmile_bad;
                        if(isLoggedIn()){
                            showFeedbackDialog();
                        } else {
                            showLoginDialog();
                        }
                        break;
                    case SmileRating.GOOD:
                        smile_number = R.drawable.ic_smile;
                        if(isLoggedIn()){
                            showFeedbackDialog();

                        } else {
                            showLoginDialog();
                        }
                        break;
                    case SmileRating.GREAT:
                        smile_number = R.drawable.ic_smilie_great;
                        if(isLoggedIn()){
                            showFeedbackDialog();

                        } else {
                            showLoginDialog();
                        }
                        break;
                    case SmileRating.OKAY:
                        smile_number = R.drawable.ic_smile_ok;
                        if(isLoggedIn()){
                            showFeedbackDialog();

                        } else {
                            showLoginDialog();
                        }
                        break;
                    case SmileRating.TERRIBLE:
                        smile_number = R.drawable.ic_smile_angry;
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
                for(Sightseeing sightseeing: Variables.sightseeingMap){
                    if(sightseeing.getTitle().equals(Variables.flag_sightseeing)){
                        Map<String,String>hm=new HashMap<>();
                        hm.put("listview_title", Variables.currentUser);
                        hm.put("listview_discription", content);
                        hm.put("listview_image", Integer.toString(R.drawable.ic_user));
                        hm.put("listview_smile", Integer.toString(smile_number));
                        sightseeing.addComment(hm);
                        break;
                    }
                }
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
