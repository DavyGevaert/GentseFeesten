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
import be.davygevaert.gentsefeesten.databank.OrganisatorDB;
import be.davygevaert.gentsefeesten.model.Categorie;
import be.davygevaert.gentsefeesten.model.Organisator;

// this asyncTask is made for SDK 23
// but we are using minimum SDK 26 because it will give an error if we set gradle to minimumSDK 23
public class JsonTaskOrganisatoren extends AsyncTask<String, String, String> {

    private OrganisatorDB organisatorDB;
    private Context context;

    private String TAG;

    private ProgressDialog pd;

    public JsonTaskOrganisatoren(Context ctx, ProgressDialog progressDialog)
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

        organisatorDB = new OrganisatorDB(context);

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
                Organisator organisator = new Organisator();

                organisator.setId(root.path("id").asText());
                organisator.setName(root.path("name").asText());
                organisator.setMemberOf(root.path("memberof").asText());
                organisator.setUrl(root.path("url").asText());
                organisator.setUuid(root.path("uuid").asText());

                // add to database table Event
                organisatorDB.addOrganisator(organisator);
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