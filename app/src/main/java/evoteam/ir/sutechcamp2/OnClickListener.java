package evoteam.ir.sutechcamp2;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by programmer on 03-Sep-17.
 */

public class OnClickListener implements View.OnClickListener{
    Context context;
    public OnClickListener(Context context){
        this.context = context;
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(context , "text", Toast.LENGTH_SHORT).show();
    }
}
