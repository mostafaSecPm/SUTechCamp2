package evoteam.ir.sutechcamp2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 9/5/2017.
 */

public class TaskAdapter extends ArrayAdapter {
    private List<Task> tasks;

    //constructor
    public TaskAdapter(Context context, List<Task> tasks){
        super(context, R.layout.task_layout, tasks);
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Task currentTask = tasks.get(position);

        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.task_layout, parent, false);

        TextView taskName = (TextView) view.findViewById(R.id.taskName);
        TextView taskDay = (TextView) view.findViewById(R.id.taskDay);

        taskName.setText(currentTask.getName());
        taskDay.setText(currentTask.getDay());

        return view;
    }
}
