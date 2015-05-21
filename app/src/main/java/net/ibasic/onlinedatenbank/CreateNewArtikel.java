package net.ibasic.onlinedatenbank;

import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Max am 21.05.2015.
 */
public class CreateNewArtikel  extends AsyncTask<String, String, String> {
    String artikel_name, menge, einheit;
    HTTPClient httpClient = new HTTPClient();

    public void setArtikel_name(String artikel_name_input){
        artikel_name = artikel_name_input;
    }

    public void setmenge(String menge_input){
        menge = menge_input;
    }

    public void seteinheit(String einheit_input){
        einheit = einheit_input;
    }

    protected String doInBackground(String...args){

        // Parameter für Http-Reqeust erstellen
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("artikel_name", artikel_name));
        params.add(new BasicNameValuePair("menge", menge));
        params.add(new BasicNameValuePair("einheit", einheit));

        // Http-POST Request an das PHP-Script
        httpClient.makeHttpRequest("http://itubegamer.bplaced.net/artikel/create_artikel.php","POST", params);
        return null;
    }
}
