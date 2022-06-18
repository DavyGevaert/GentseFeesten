package be.gentsefeesten.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import be.gentsefeesten.interfaces.*
import be.gentsefeesten.model.Event

public class DatabaseSchemaHelper(context: Context) :
    SQLiteOpenHelper(context, "EventBase",
        null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        // aanmaken EventTabel
        db.execSQL(
            "CREATE TABLE "
                    + EventTabel.TABEL_NAAM
                    + " ( " + EventTabel.OFFER_AVAILABLEATFORFROM + " TEXT, "
                    + EventTabel.SUPEREVENT + " TEXT, "
                    + EventTabel.KEYWORDS + " TEXT, "
                    + EventTabel.LOCATION + " TEXT, "
                    + EventTabel.OFFERS_NEW + " TEXT, "
                    + EventTabel.URL + " TEXT, "
                    + EventTabel.ID + " TEXT, "
                    + EventTabel.TYPE + " TEXT, "
                    + EventTabel.IMAGE + " TEXT, "
                    + EventTabel.ISACCESSIBLEFORFREE + " TEXT, "
                    + EventTabel.OFFER_PRICECURRENCY + " TEXT, "
                    + EventTabel.ORGANIZER + " TEXT, "
                    + EventTabel.NAME + " TEXT, "
                    + EventTabel.IMAGE_THUMBNAIL + " TEXT, "
                    + EventTabel.OFFER_DESCRIPTION + " TEXT, "
                    + EventTabel.CONTACTPOINT + " TEXT, "
                    + EventTabel.CREATED + " TEXT, "
                    + EventTabel.THEME + " TEXT, "
                    + EventTabel.IMAGE_CAPTION + " TEXT, "
                    + EventTabel.DESCRIPTION_NL + " TEXT, "
                    + EventTabel.UUID + " TEXT, "
                    + EventTabel.ENDDATE + " TEXT, "
                    + EventTabel.DESCRIPTION + " TEXT, "
                    + EventTabel.ADDRESS + " TEXT, "
                    + EventTabel.ISPARTOF + " TEXT, "
                    + EventTabel.NAME_NL + " TEXT, "
                    + EventTabel.OUTDOORS + " TEXT, "
                    + EventTabel.IMAGE_PATH + " TEXT, "
                    + EventTabel.OFFERS + " TEXT, "
                    + EventTabel.STARTDATE + " TEXT, "
                    + EventTabel.CHANGED + " TEXT, "
                    + EventTabel.ISWHEELCHAIRUNFRIENDLY + " TEXT "
                    + ");"
        );
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + EventTabel.TABEL_NAAM)

        onCreate(db)
    }

    fun insertEventData(event: Event) {
        val database = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(EventTabel.OFFER_AVAILABLEATFORFROM, event.offer_availableatorfrom)
        contentValues.put(EventTabel.SUPEREVENT, event.superevent)
        contentValues.put(EventTabel.KEYWORDS, event.keywords)
        contentValues.put(EventTabel.LOCATION, event.location)
        contentValues.put(EventTabel.OFFERS_NEW, event.offers_new)
        contentValues.put(EventTabel.URL, event.url)
        contentValues.put(EventTabel.ID, event.id)
        contentValues.put(EventTabel.TYPE, event.type)
        contentValues.put(EventTabel.IMAGE, event.image)
        contentValues.put(EventTabel.ISACCESSIBLEFORFREE, event.isaccessibleforfree)
        contentValues.put(EventTabel.OFFER_PRICECURRENCY, event.offer_pricecurrency)
        contentValues.put(EventTabel.ORGANIZER, event.organizer)
        contentValues.put(EventTabel.NAME, event.name)
        contentValues.put(EventTabel.IMAGE_THUMBNAIL, event.image_thumbnail)
        contentValues.put(EventTabel.OFFER_DESCRIPTION, event.offer_description)
        contentValues.put(EventTabel.CONTACTPOINT, event.contactpoint)
        contentValues.put(EventTabel.CREATED, event.created)
        contentValues.put(EventTabel.THEME, event.theme)
        contentValues.put(EventTabel.IMAGE_CAPTION, event.image_caption)
        contentValues.put(EventTabel.DESCRIPTION_NL, event.description_nl)
        contentValues.put(EventTabel.UUID, event.uuid)
        contentValues.put(EventTabel.ENDDATE, event.enddate)
        contentValues.put(EventTabel.DESCRIPTION, event.description)
        contentValues.put(EventTabel.ADDRESS, event.address)
        contentValues.put(EventTabel.ISPARTOF, event.ispartof)
        contentValues.put(EventTabel.NAME_NL, event.name_nl)
        contentValues.put(EventTabel.OUTDOORS, event.outdoors)
        contentValues.put(EventTabel.IMAGE_PATH, event.image_path)
        contentValues.put(EventTabel.OFFERS, event.offers)
        contentValues.put(EventTabel.STARTDATE, event.startdate)
        contentValues.put(EventTabel.CHANGED, event.changed)
        contentValues.put(EventTabel.ISWHEELCHAIRUNFRIENDLY, event.iswheelchairunfriendly)

        database.insert(EventTabel.TABEL_NAAM, null, contentValues)
    }

    fun readEventData(): MutableList<Event> {
        val list: MutableList<Event> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from ${EventTabel.TABEL_NAAM}"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val event = Event()
                event.offer_availableatorfrom = result.getString(0)
                event.superevent = result.getString(1)
                event.keywords = result.getString(2)
                event.location = result.getString(3)
                event.offers_new = result.getString(4)
                event.url = result.getString(5)
                event.id = result.getString(6)
                event.type = result.getString(7)
                event.image = result.getString(8)
                event.isaccessibleforfree = result.getString(9)
                event.offer_pricecurrency = result.getString(10)
                event.organizer = result.getString(11)
                event.name = result.getString(12)
                event.image_thumbnail = result.getString(13)
                event.offer_description = result.getString(14)
                event.contactpoint = result.getString(15)
                event.created = result.getString(16)
                event.theme = result.getString(17)
                event.image_caption = result.getString(18)
                event.description_nl = result.getString(19)
                event.uuid = result.getString(20)
                event.enddate = result.getString(21)
                event.description = result.getString(22)
                event.address = result.getString(23)
                event.ispartof = result.getString(24)
                event.name_nl = result.getString(25)
                event.outdoors = result.getString(26)
                event.image_path = result.getString(27)
                event.offers = result.getString(28)
                event.startdate = result.getString(29)
                event.changed = result.getString(30)
                event.iswheelchairunfriendly = result.getString(31)
                list.add(event)
            }
            while (result.moveToNext())
        }
        return list
    }
}