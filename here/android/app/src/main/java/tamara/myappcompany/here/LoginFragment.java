package tamara.myappcompany.here;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.tensorflow.lite.examples.detection.R;

/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        final TextInputLayout usernameTextInput = view.findViewById(org.tensorflow.lite.examples.detection.R.id.username_text_input);
        final TextInputEditText usernameEditText = view.findViewById(org.tensorflow.lite.examples.detection.R.id.username_edit_text);
        final TextInputLayout passwordTextInput = view.findViewById(org.tensorflow.lite.examples.detection.R.id.password_text_input);
        final TextInputEditText passwordEditText = view.findViewById(org.tensorflow.lite.examples.detection.R.id.password_edit_text);
        MaterialButton nextButton = view.findViewById(R.id.next_button);

        // Set an error if the password and/or username is wrong
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((usernameEditText.getText().toString().equals("")) && (passwordEditText.getText().toString().equals(""))){
                    usernameTextInput.setError(getString(R.string.error_username2));
                    passwordTextInput.setError(getString(R.string.error_password2));
                }
                else if ((!(isUsernameValid(usernameEditText.getText()))) && (passwordEditText.getText().toString().equals(""))) {
                    usernameTextInput.setError(getString(R.string.error_username));
                    passwordTextInput.setError(getString(R.string.error_password2));
                }
                else if ((!(isPasswordValid(passwordEditText.getText()))) && (usernameEditText.getText().toString().equals(""))) {
                    passwordTextInput.setError(getString(R.string.error_password));
                    usernameTextInput.setError(getString(R.string.error_username2));
                }
                else if ((!(isPasswordValid(passwordEditText.getText()))) && (isUsernameValid(usernameEditText.getText()))) {
                    passwordTextInput.setError(getString(R.string.error_password));
                    usernameTextInput.setError(null); // Clear the error
                }
                else if ((!(isUsernameValid(usernameEditText.getText()))) && (isPasswordValid(passwordEditText.getText()))) {
                    usernameTextInput.setError(getString(R.string.error_username));
                    passwordTextInput.setError(null); // Clear the error
                }
                else if ((!(isUsernameValid(usernameEditText.getText()))) && (!(isPasswordValid(passwordEditText.getText())))){
                    usernameTextInput.setError(getString(R.string.error_username));
                    passwordTextInput.setError(getString(R.string.error_password));
                }
                else{
                    passwordTextInput.setError(null); // Clear the error
                    usernameTextInput.setError(null); // Clear the error
                    Intent i = new Intent(getActivity(), DetectorActivity.class);
                    startActivity(i); // brings up the second activity
                    getActivity().finish(); //stop users from being able to navigate to Login screen using back button

                    //((CameraActivity) getActivity()).FragmentMethod();
                    //((NavigationHost2) getActivity()).navigateTo(new AppCompatActivity() , false); // Navigate to the next Fragment
                }
            }
        });

        // Clear the error once more than 8 characters are typed.
        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (isPasswordValid(passwordEditText.getText())){
                    passwordTextInput.setError(null); //Clear the error
                }
                return false;
            }
        });

        usernameEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (isUsernameValid(usernameEditText.getText())){
                    usernameTextInput.setError(null); // Clear the error
                }
                return false;
            }
        });

        return view;
    }

    // "isUsernameValid" from "Navigate to the next Fragment" section method goes here
    private boolean isUsernameValid(@Nullable Editable text) {
        return (text.toString().equals("admin"));
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private boolean isPasswordValid(@Nullable Editable text) {
        return (text.toString().equals("admin"));
    }

}
