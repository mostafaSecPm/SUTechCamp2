package evoteam.ir.sutechcamp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        /*  bundle usem  */
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            if(extras.containsKey("key")){
                Toast.makeText(this, extras.getString("key"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
