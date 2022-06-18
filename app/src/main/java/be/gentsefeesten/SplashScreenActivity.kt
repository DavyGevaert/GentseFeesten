package be.gentsefeesten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import be.gentsefeesten.model.Event
import org.json.JSONArray
import org.json.JSONTokener
import kotlin.concurrent.thread

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var iv_note: ImageView
    private lateinit var result: String

    val evenementen = "evenementen.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        iv_note = findViewById(R.id.iv_note)

        iv_note.alpha = 0f;
        iv_note.animate().setDuration(1500).alpha(1f).withEndAction {

            doOperationsOnThread_Create_Events()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

        // check if database sqlite has more then 1 record do nothing
        // else if database length is zero , you can add everything

    }

    fun doOperationsOnThread_Create_Events(){
        thread {
            result = application.assets.open(evenementen).bufferedReader().use{
                it.readText()
            }
            //Log.i("result json_string", result.toString())

            var jsonArray = JSONTokener(result).nextValue() as JSONArray
            //Log.i("jsonArray: ", jsonArray.toString())

            // i kan gelijk zijn aan progress value van progressbar en jsonArray.length is max value
            for (i in 0 until jsonArray.length()){
                //Log.i("object: ", jsonArray.getString(i))

                var fields = jsonArray.getJSONObject(i).getJSONObject("fields")
                Log.i("fields", fields.toString())

                // fields.getJSONObject

                var event = Event()

                if (fields.has("offer_availableatorfrom")){
                    var offer_availableatorfrom = fields.getString("offer_availableatorfrom")
                    Log.i("offer_availableatorfrom", offer_availableatorfrom)
                }

                if (fields.has("superevent")){
                    var superevent = fields.getString("superevent")
                    Log.i("superevent", superevent)
                }

                if (fields.has("keywords")){
                    var keywords = fields.getString("keywords")
                    Log.i("keywords", keywords)
                }

                if (fields.has("location")){
                    var location = fields.getString("location")
                    Log.i("location", location)
                }

                if (fields.has("offers_new")){
                    var offers_new = fields.getString("offers_new")
                    Log.i("offers_new", offers_new)
                }

                if (fields.has("url")){
                    var url = fields.getString("url")
                    Log.i("url", url)
                }

                if (fields.has("id")){
                    var id = fields.getString("id")
                    Log.i("id", id)
                }

                if (fields.has("type")){
                    var type = fields.getString("type")
                    Log.i("type", type)
                }

                if (fields.has("image")){
                    var image = fields.getString("image")
                    Log.i("image", image)
                }

                if (fields.has("isaccessibleforfree")){
                    var isaccessibleforfree = fields.getString("isaccessibleforfree")
                    Log.i("isaccessibleforfree", isaccessibleforfree)
                }

                if (fields.has("offer_pricecurrency")){
                    var offer_pricecurrency = fields.getString("offer_pricecurrency")
                    Log.i("offer_pricecurrency", offer_pricecurrency)
                }

                if (fields.has("organizer")){
                    var organizer = fields.getString("organizer")
                    Log.i("organizer", organizer)
                }

                if (fields.has("name")){
                    var name = fields.getString("name")
                    Log.i("name", name)
                }

                if (fields.has("image_thumbnail")){
                    var image_thumbnail = fields.getString("image_thumbnail")
                    Log.i("image_thumbnail", image_thumbnail)
                }

                if (fields.has("offer_description")){
                    var offer_description = fields.getString("offer_description")
                    Log.i("offer_description", offer_description)
                }

                if (fields.has("contactpoint")){
                    var contactpoint = fields.getString("contactpoint")
                    Log.i("contactpoint", contactpoint)
                }

                if (fields.has("created")){
                    var created = fields.getString("created")
                    Log.i("created", created)
                }

                if (fields.has("theme")){
                    var theme = fields.getString("theme")
                    Log.i("theme", theme)
                }

                if (fields.has("image_caption")){
                    var image_caption = fields.getString("image_caption")
                    Log.i("image_caption", image_caption)
                }

                if (fields.has("description_nl")){
                    var description_nl = fields.getString("description_nl")
                    Log.i("description_nl", description_nl)
                }

                if (fields.has("uuid")){
                    var uuid = fields.getString("uuid")
                    Log.i("uuid", uuid)
                }

                if (fields.has("enddate")){
                    var enddate = fields.getString("enddate")
                    Log.i("enddate", enddate)
                }

                if (fields.has("description")){
                    var description = fields.getString("description")
                    Log.i("description", description)
                }

                if (fields.has("address")){
                    var address = fields.getString("address")
                    Log.i("address", address)
                }

                if (fields.has("ispartof")){
                    var ispartof = fields.getString("ispartof")
                    Log.i("ispartof", ispartof)
                }

                if (fields.has("name_nl")){
                    var name_nl = fields.getString("name_nl")
                    Log.i("name_nl", name_nl)
                }

                if (fields.has("outdoors")){
                    var outdoors = fields.getString("outdoors")
                    Log.i("outdoors", outdoors)
                }

                if (fields.has("image_path")){
                    var image_path = fields.getString("image_path")
                    Log.i("image_path", image_path)
                }

                if (fields.has("offers")){
                    var offers = fields.getString("offers")
                    Log.i("offers", offers)
                }

                if (fields.has("startdate")){
                    var startdate = fields.getString("startdate")
                    Log.i("startdate", startdate)
                }

                if (fields.has("changed")){
                    var changed = fields.getString("changed")
                    Log.i("changed", changed)
                }

                if (fields.has("iswheelchairunfriendly")){
                    var iswheelchairunfriendly = fields.getString("iswheelchairunfriendly")
                    Log.i("iswheelchairunfriendly", iswheelchairunfriendly)
                }
            }
        }
    }
}