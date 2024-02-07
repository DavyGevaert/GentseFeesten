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

import be.davygevaert.gentsefeesten.databank.EventDB;
import be.davygevaert.gentsefeesten.model.Event;

// this asyncTask is made for SDK 23
// but we are using minimum SDK 26 because it will give an error if we set gradle to minimumSDK 23
public class JsonTaskEvenementen extends AsyncTask<String, String, String> {

    private EventDB eventDB;
    private Context context;

    private String TAG;

    private ProgressDialog pd;

    public JsonTaskEvenementen(Context ctx, ProgressDialog progressDialog)
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

        eventDB = new EventDB(context);

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
                Event event = new Event();

                event.setId(root.path("id").asText());
                event.setType(root.path("type").asText());
                event.setChanged(root.path("changed").asText());
                event.setContactPoint(root.path("contactpoint").asText());
                event.setContributor(root.path("contributor").asText());
                event.setCreated(root.path("created").asText());
                event.setDescription(root.path("description").asText());
                event.setDuration(root.path("duration").asText());
                event.setEnddate(root.path("enddate").asText());
                event.setFrequency(root.path("frequency").asText());
                event.setImage(root.path("image").asText());
                event.setInlanguage(root.path("islanguage").asText());
                event.setIspartof(root.path("ispartof").asText());
                event.setIswheelchairunfriendly(root.path("iswheelchairunfriendly").asText());
                event.setKeywords(root.path("keywords").asText());
                event.setLocation(root.path("location").asText());
                event.setMusic_genre(root.path("music_genre").asText());
                event.setName(root.path("name").asText());
                event.setOffers(root.path("offers").asText());
                event.setOrganizer(root.path("organizer").asText());
                event.setOutdoors(root.path("outdoors").asText());
                event.setStartdate(root.path("startdate").asText());
                event.setSubevent(root.path("subevent").asText());
                event.setSuperevent(root.path("superevent").asText());
                event.setTheme(root.path("theme").asText());
                event.setTypicalagerange(root.path("typicalagerange").asText());
                event.setUrl(root.path("url").asText());
                event.setUuid(root.path("uuid").asText());
                event.setVideo(root.path("video").asText());
                event.setImage_path(root.path("image_path").asText());
                event.setImage_caption(root.path("image_caption").asText());
                event.setImage_thumbnail(root.path("image_thumbnail").asText());
                event.setDescription_nl(root.path("description_nl").asText());
                event.setName_nl(root.path("name_nl").asText());
                event.setOffers_new(root.path("offers_new").asText());
                event.setOffer_availableatorfrom(root.path("offer_availableatorfrom").asText());
                event.setOffer_description(root.path("offer_description").asText());
                event.setOffer_pricevaliduntil(root.path("offer_privevaliduntil").asText());
                event.setOffer_pricecurrency(root.path("offer_pricecurrency").asText());
                event.setOffer_price(root.path("offer_price").asText());
                event.setOffer_eligiblefordiscount(root.path("offer_eligiblefordiscount").asText());
                event.setVideo_new(root.path("video_new").asText());
                event.setVideo_caption(root.path("video_caption").asText());
                event.setVideo_embedurl(root.path("video_embedurl").asText());
                event.setVideo_thumbnail(root.path("video_thumbnail").asText());
                event.setAddress(root.path("address").asText());

                // add to database table Event
                eventDB.addEvent(event);

                /*
                    Log.d(TAG, "event " + event.getId());
                    Log.d(TAG, "event " + event.getType());
                    Log.d(TAG, "event " + event.getChanged());
                    Log.d(TAG, "event " + event.getContactPoint());
                    Log.d(TAG, "event " + event.getContributor());
                    Log.d(TAG, "event " + event.getChanged());
                    Log.d(TAG, "event " + event.getDescription());
                    Log.d(TAG, "event " + event.getDuration());
                    Log.d(TAG, "event " + event.getEnddate());
                    Log.d(TAG, "event " + event.getFrequency());
                    Log.d(TAG, "event " + event.getImage());
                    Log.d(TAG, "event " + event.getInlanguage());
                    Log.d(TAG, "event " + event.getIsaccessibleforfree());
                    Log.d(TAG, "event " + event.getIspartof());
                    Log.d(TAG, "event " + event.getIswheelchairunfriendly());
                    Log.d(TAG, "event " + event.getKeywords());
                    Log.d(TAG, "event " + event.getLocation());
                    Log.d(TAG, "event " + event.getMusic_genre());
                    Log.d(TAG, "event " + event.getName());
                    Log.d(TAG, "event " + event.getOffers());
                    Log.d(TAG, "event " + event.getOrganizer());
                    Log.d(TAG, "event " + event.getOutdoors());
                    Log.d(TAG, "event " + event.getStartdate());
                    Log.d(TAG, "event " + event.getSubevent());
                    Log.d(TAG, "event " + event.getSuperevent());
                    Log.d(TAG, "event " + event.getTheme());
                    Log.d(TAG, "event " + event.getTypicalagerange());
                    Log.d(TAG, "event " + event.getUrl());
                    Log.d(TAG, "event " + event.getUuid());
                    Log.d(TAG, "event " + event.getVideo());
                    Log.d(TAG, "event " + event.getImage_path());
                    Log.d(TAG, "event " + event.getImage_caption());
                    Log.d(TAG, "event " + event.getImage_thumbnail());
                    Log.d(TAG, "event " + event.getDescription_nl());
                    Log.d(TAG, "event " + event.getName_nl());
                    Log.d(TAG, "event " + event.getOffers_new());
                    Log.d(TAG, "event " + event.getOffer_availableatorfrom());
                    Log.d(TAG, "event " + event.getOffer_description());
                    Log.d(TAG, "event " + event.getOffer_pricevaliduntil());
                    Log.d(TAG, "event " + event.getOffer_pricecurrency());
                    Log.d(TAG, "event " + event.getOffer_price());
                    Log.d(TAG, "event " + event.getOffer_eligiblefordiscount());
                    Log.d(TAG, "event " + event.getVideo_new());
                    Log.d(TAG, "event " + event.getVideo_caption());
                    Log.d(TAG, "event " + event.getVideo_embedurl());
                    Log.d(TAG, "event " + event.getVideo_thumbnail());
                    Log.d(TAG, "event " + event.getAddress());
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