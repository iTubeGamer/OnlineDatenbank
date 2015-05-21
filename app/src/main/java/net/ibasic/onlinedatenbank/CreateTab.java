package net.ibasic.onlinedatenbank;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Erstellt von Max am 21.05.2015.
 */
public class CreateTab extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_tab);

        final Button button = (Button) findViewById(R.id.button_post);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText et_article_name = (EditText) findViewById(R.id.editText);
                EditText et_value = (EditText) findViewById(R.id.editText2);
                EditText et_unit = (EditText) findViewById(R.id.editText3);


                try {
                    new CreateNewArtikel().execute(
                            et_article_name.getText().toString(),
                            et_value.getText().toString(),
                            et_unit.getText().toString()
                    );
                    Toast.makeText(getApplicationContext(), "New entry created!", Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                    System.out.println("Unable to write to online database. Exception: " + ex.toString());

                }
            }
        });
    }
}
