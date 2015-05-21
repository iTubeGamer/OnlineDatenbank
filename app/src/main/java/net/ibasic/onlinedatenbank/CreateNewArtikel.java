package net.ibasic.onlinedatenbank;

import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Max am 21.05.2015.
 */
public class CreateNewArtikel  extends AsyncTask<String, String, String> {

    HTTPClient httpClient = new HTTPClient();


    public String doInBackground(String...rows){

        // Parameter für Http-Reqeust erstellen
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("artikel_name", rows[0]));
        params.add(new BasicNameValuePair("menge", rows[1]));
        params.add(new BasicNameValuePair("einheit", rows[2]));

        // Http-POST Request an das PHP-Script
        httpClient.makeHttpRequest("http://www.itubegamer.bplaced.net/artikel/create_artikel.php", "POST", params);
        return null;
    }
}
