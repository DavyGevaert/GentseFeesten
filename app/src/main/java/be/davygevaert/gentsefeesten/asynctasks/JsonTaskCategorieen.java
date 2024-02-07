package be.davygevaert.gentsefeesten.asynctasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import be.davygevaert.gentsefeesten.databank.CategorieDB;
import be.davygevaert.gentsefeesten.model.Categorie;

// this asyncTask is made for SDK 23
// but we are using minimum SDK 26 because it will give an error if we set gradle to minimumSDK 23
public class JsonTaskCategorieen extends AsyncTask<String, String, String> {

    private CategorieDB categorieDB;
    private Context context;

    private String TAG;

    private ProgressDialog pd;

    public JsonTaskCategorieen(Context ctx, ProgressDialog progressDialog)
    {
        context = ctx;
        pd = progressDialog;
        TAG = context.getClass().getSimpleName();
    }

    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(context);
        pd.setMessage("Installing events");
        pd.setCancelable(false);
        pd.show();
    }

    protected String doInBackground(String... params) {

        categorieDB = new CategorieDB(context);

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
                Log.d("Response: ", " - " + line);

            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootArray = mapper.readTree(buffer.toString());

            for (JsonNode root : rootArray) {
                Categorie categorie = new Categorie();

                categorie.setId(root.path("id").asText());
                categorie.setName(root.path("name").asText());
                categorie.setUuid(root.path("uuid").asText());

                // add to database table Event
                categorieDB.addCategorie(categorie);

                /*
                    Log.d(TAG, "event " + event.getId());
                    Log.d(TAG, "event " + event.getType());
                    Log.d(TAG, "event " + event.getChanged());
                */
            }

            return buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (pd.isShowing()) {
            pd.dismiss();
        }

        // Log.d("SplashScreen", "Json resultaat" + result);   //here u ll get whole response...... :-)
    }
}