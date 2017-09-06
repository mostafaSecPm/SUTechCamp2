package evoteam.ir.sutechcamp2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignInOrSignUpActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    Button signIn;
    Button signUp;
    TextView textView;



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
        textView = (TextView) findViewById(R.id.textView);
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
//                textView.setText("Sign Up is Clicked");
                Request request = new Request(SignInOrSignUpActivity.this);
                request.execute("back");
                break;
            default:
                break;
        }
        return true;
    }

    public void setTextView(String s){
        textView.setText(s);
    }

    private class Request extends AsyncTask<String, String, String>{

        Context context;

        public Request (Context context){
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String param = params[0];
            Log.d("***do in" , param);
            boolean isOnline = HttpConnectionManager.isOnline(context);
            Log.d("***isOnline", String.valueOf(isOnline));
            return param;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setTextView(s);
        }
    }

}

