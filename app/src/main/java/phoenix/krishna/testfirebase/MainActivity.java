package phoenix.krishna.testfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

//    EditText firstName;
//    EditText lastName;
    EditText email;
    EditText password;
    Button getIn;

    //make sure to check email and password not empty and null


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this,"Hello Firebase",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        firstName = findViewById(R.id.editText3);
//        lastName = findViewById(R.id.editText4);
        email = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        getIn = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();


    }


    public void onRegister(View view){
//
//        final String myFirstName = firstName.getText().toString();
//
//        if(myFirstName.matches("")){
//
//            Toast.makeText(MainActivity.this,"First name can't be empty.",Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//
//        final String myLastName = lastName.getText().toString();
//
//        if(myLastName.matches("")){
//
//            Toast.makeText(MainActivity.this,"Last name can't be empty.",Toast.LENGTH_SHORT).show();
//            return;
//        }


        final String myEmail = email.getText().toString();

        if(myEmail.matches("")){

            Toast.makeText(MainActivity.this,"Please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }

        final String myPass = password.getText().toString();

        if(myPass.matches("")){

            Toast.makeText(MainActivity.this,"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(myEmail, myPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this,"Filure",Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });


    }
}
