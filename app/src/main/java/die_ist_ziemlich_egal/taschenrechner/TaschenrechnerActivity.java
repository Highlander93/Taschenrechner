package die_ist_ziemlich_egal.taschenrechner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class TaschenrechnerActivity extends Activity {

    private TextView textView;
    private boolean stateError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taschenrechner);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void calculate(View view){
        if(stateError){
            return;
        }
        String txt = textView.getText().toString();
        try {
        Expression expression = new ExpressionBuilder(txt).build();
            double result = expression.evaluate();
            textView.setText(Double.toString(result));
        } catch (Exception ex) {
            textView.setText("Error");
            stateError = true;
        }
    }

    public void buttons(View view){
        if(stateError){
            clear(null);
        }
        Button b = (Button)view;
        textView.append(b.getText());
    }

    public void clear(View view){
        textView.setText("");
        stateError = false;
    }
}
