package evoteam.ir.sutechcamp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity implements TextWatcher, AdapterView.OnItemClickListener {

    EditText editText;
    Spinner spinner;
    ListView listView;

    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        /*  bundle use  */
        getBundleFromIntent();
        //init
        init();
        //spinner
        makingReadyTheSpinner();
        //arrayList for ListView
        creatingTheArrayListForListView();
        //listView
//        makingReadyTheSimpleListView();
        makingReadyTheCustomizedistView();

    }

    private void makingReadyTheCustomizedistView() {
        TaskAdapter customizedTaskAdapter =
                new TaskAdapter(this, tasks);
        listView.setAdapter(customizedTaskAdapter);
    }

    private void creatingTheArrayListForListView() {
        tasks.add(new Task("task1", "day1"));
        tasks.add(new Task("task2", "day2"));
        tasks.add(new Task("task3", "day3"));
        tasks.add(new Task("task4", "day4"));
        tasks.add(new Task("task5", "day5"));
        tasks.add(new Task("task6", "day6"));
        tasks.add(new Task("task7", "day7"));
    }

    private void makingReadyTheSimpleListView() {
        ArrayAdapter listViewAdapter =
                new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, tasks);
        listView.setAdapter(listViewAdapter);
    }

    private void makingReadyTheSpinner() {
        String[] days = getResources().getStringArray(R.array.days);
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        spinner.setAdapter(spinnerAdapter);
    }

    private void init() {
        //editText
        editText = (EditText) findViewById(R.id.editText);
        //listener editText
        editText.addTextChangedListener(this);
        //spinner
        spinner = (Spinner) findViewById(R.id.spinner);

        //listView
        listView = (ListView) findViewById(R.id.listView);
        tasks = new ArrayList<>();
        listView.setOnItemClickListener(this);
    }

    public void getBundleFromIntent(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            if(extras.containsKey("key")){
                Toast.makeText(this, extras.getString("key"), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d("textChangedBefore", s.toString());
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("textChangedOn", s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.d("textChangedAfter", s.toString());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Task clickedTask = tasks.get(position);
        Toast.makeText(this, "Your task is: " + clickedTask.getName(), Toast.LENGTH_SHORT).show();
    }
}
