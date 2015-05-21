package net.ibasic.onlinedatenbank;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Max am 21.05.2015.
 */
public class CreateNewArtikel  extends AsyncTask<String, Integer, Integer> {
    private Context mContext;
    public CreateNewArtikel (Context context){
        mContext = context;
    }
    HTTPClient httpClient = new HTTPClient();
    ProgressDialog dialog;

    @Override
    protected void onPreExecute() {
        // Setup Progress Dialog
        dialog = new ProgressDialog(mContext);
        dialog.setMax(100);
        dialog.setMessage("Syncing...");
        dialog.show();
    }

    public Integer doInBackground(String... rows){

        // Parameter für Http-Reqeust erstellen
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("artikel_name", rows[0]));
        params.add(new BasicNameValuePair("menge", rows[1]));
        params.add(new BasicNameValuePair("einheit", rows[2]));

        // Http-POST Request an das PHP-Script
        httpClient.makeHttpRequest("http://ibasic.hol.es/phpscripts/create_artikel.php", "POST", params);
        return 1;
    }


    protected void onProgressUpdate(Integer... values) {
        // Increment Progress Dialog with the Update
        // from the doInBackgroundMethod
        dialog.incrementProgressBy(values[0]);
    }


    protected void onPostExecute(Integer result) {
        System.out.println("postExcecute");
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
