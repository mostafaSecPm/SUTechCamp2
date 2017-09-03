package evoteam.ir.sutechcamp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignInOrSignUpActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    Button signIn;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_or_sign_up);
        init();

        signIn.setOnClickListener(this);
        signUp.setOnClickListener(this);
        signIn.setOnLongClickListener(this);
        signUp.setOnLongClickListener(this);
    }

    private void init(){
        signIn = (Button) findViewById(R.id.SignInButton);
        signUp = (Button) findViewById(R.id.SignUpButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SignInButton:
                //public static Toast makeText(Context context , int id , int length)
                Toast.makeText(SignInOrSignUpActivity.this, "sign In is just clicked", Toast.LENGTH_SHORT).show();

                break;
            case R.id.SignUpButton:
                Toast.makeText(SignInOrSignUpActivity.this, "sign Up is just clicked", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.SignInButton:
                //public static Toast makeText(Context context , int id , int length)
                Intent intent = new Intent(SignInOrSignUpActivity.this, SignInActivity.class);
                intent.putExtra("key", "value");
                startActivity(intent);
                break;
            case R.id.SignUpButton:
                Toast.makeText(SignInOrSignUpActivity.this, "sign Up is Long clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
