package evoteam.ir.sutechcamp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity implements TextWatcher {

    Spinner spinner;
    EditText editText;
    ListView listView;
    ArrayList<Task> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        /*  bundle use  */
        intentExteras();
        //initializing the widgets
        init();
        //Adapter for Spinner
        makingReadyTheSpinner();
        //making a resource for ListView
        makingReadyTheTasks();
        //Adapter for listView
        makingReadyTheListView();
    }

    private void intentExteras() {
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            if(extras.containsKey("key")){
                Toast.makeText(this, extras.getString("key"), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void init() {
        editText = (EditText) findViewById(R.id.editText);

        //set listener for editText
        editText.addTextChangedListener(this);

        spinner = (Spinner) findViewById(R.id.spinner);

        listView = (ListView) findViewById(R.id.listView);
        //I had an error here
        tasks = new ArrayList<>();
    }

    private void makingReadyTheSpinner() {
        String [] days = getResources().getStringArray(R.array.days);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
    }

    private void makingReadyTheTasks() {
        tasks.add(new Task("and1", "sat"));
        tasks.add(new Task("and2", "sun"));
        tasks.add(new Task("and3", "mon"));
        tasks.add(new Task("and4", "tues"));
    }

    private void makingReadyTheListView() {
        ArrayAdapter secAdapter =
                new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, tasks);
        listView.setAdapter(secAdapter);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d("see text change before", s.toString());
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("see text change on", s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.d("see text change after", s.toString());
    }
}
