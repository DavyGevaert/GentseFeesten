package be.gentsefeesten

import android.net.UrlQuerySanitizer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import be.gentsefeesten.database.DatabaseSchemaHelper
import be.gentsefeesten.model.Event
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var List : MutableList<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // aanroepen database en aan variabele toewijzen
        var db = DatabaseSchemaHelper(this)

        // sla Event object op in database
        List = db.readEventData()

        //for (i in 0 until List.size) {
            Log.i("list", List.toString())
        //}
    }
}

