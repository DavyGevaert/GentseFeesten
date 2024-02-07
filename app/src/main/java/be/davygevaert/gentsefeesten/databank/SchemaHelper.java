package be.davygevaert.gentsefeesten.databank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

import be.davygevaert.gentsefeesten.constanten.CategorieTabel;
import be.davygevaert.gentsefeesten.constanten.EventTabel;

/**
 * Created by Davy on 16/06/2016.
 */
public class SchemaHelper extends SQLiteOpenHelper {

    // database version
    private static final int DATABASE_VERSION = 1;

    // database name
    private static final String DATABASE_NAME = "GentseFeesten";

    public SchemaHelper(Context context) {
        // originele super indien apk wordt gereleased en dan commenteer je de tweede super met /* */
        // super(context, DATABASE_NAME, null, DATABASE_VERSION);

        /* onderstaande voor testdoeleinden mbv programma sqliteadmin
           http://sqliteadmin.orbmu2k.de/
           hier wordt de databank opgeslagen in een mapje GENTSEFEESTENDB op je sd kaart */


        super(context, context.getExternalFilesDir("GENTSEFEESTENDB")
                + File.separator + DATABASE_NAME
                , null,DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /*


        // aanmaken LocatieTabel
        db.execSQL("CREATE TABLE "
                        + LocatieTabel.TABEL_NAAM
                        + " ( " + LocatieTabel.LOCATIE_ID + " TEXT, "
                        + LocatieTabel.LOCATIE_NAAM + " TEXT, "
                        + LocatieTabel.LOCATIE_STRAAT + " TEXT, "
                        + LocatieTabel.LOCATIE_POSTCODE + " TEXT, "
                        + LocatieTabel.LOCATIE_GEMEENTE + " TEXT, "
                        + LocatieTabel.ROLSTOEL_TOEGANKELIJKHEID + " TEXT"
                        + ");"
        );

        // aanmaken OrganisatorTabel
        db.execSQL("CREATE TABLE "
                        + OrganisatorTabel.TABEL_NAAM
                        + " ( " + OrganisatorTabel.ORGANISATIE_ID + " TEXT, "
                        + OrganisatorTabel.ORGANISATIE_NAAM + " TEXT, "
                        + OrganisatorTabel.ORGANISATIE_STRAAT + " TEXT, "
                        + OrganisatorTabel.ORGANISATIE_POSTCODE + " TEXT, "
                        + OrganisatorTabel.ORGANISATIE_GEMEENTE + " TEXT"
                        + ");"
        );

         */

        // aanmaken CategorieTabel
        db.execSQL("CREATE TABLE "
                + CategorieTabel.TABEL_CATEGORIE
                + " ( " + CategorieTabel.ID + " TEXT, "
                + CategorieTabel.NAME + " TEXT, "
                + CategorieTabel.UUID + " TEXT"
                + ");"
        );

        // aanmaken EventTabel
        db.execSQL("CREATE TABLE "
                + EventTabel.TABEL_EVENT

                + " ( " + EventTabel.ID + " TEXT, "
                + EventTabel.TYPE + " TEXT, "
                + EventTabel.CHANGED + " TEXT, "
                + EventTabel.CONTACTPOINT + " TEXT, "
                + EventTabel.CONTRIBUTOR + " TEXT, "
                + EventTabel.CREATED + " TEXT, "
                + EventTabel.DESCRIPTION + " TEXT, "
                + EventTabel.DURATION + " TEXT, "
                + EventTabel.ENDDATE + " TEXT, "
                + EventTabel.FREQUENCY + " TEXT, "

                + EventTabel.IMAGE + " TEXT, "
                + EventTabel.IN_LANGUAGE + " TEXT, "
                + EventTabel.IS_ACCESSIBLE_FOR_FREE + " TEXT, "
                + EventTabel.ISPARTOF + " TEXT, "
                + EventTabel.ISWHEELCHAIRUNFRIENDLY + " TEXT, "
                + EventTabel.KEYWORDS + " TEXT, "
                + EventTabel.LOCATION + " TEXT, "
                + EventTabel.MUSIC_GENRE + " TEXT, "
                + EventTabel.NAME + " TEXT, "
                + EventTabel.OFFERS + " TEXT, "

                + EventTabel.ORGANIZER + " TEXT, "
                + EventTabel.OUTDOORS + " TEXT, "
                + EventTabel.START_DATE + " TEXT, "
                + EventTabel.SUBEVENT + " TEXT, "
                + EventTabel.SUPEREVENT + " TEXT, "
                + EventTabel.THEME + " TEXT, "
                + EventTabel.TYPICAL_AGE_RANGE + " TEXT, "
                + EventTabel.URL + " TEXT, "
                + EventTabel.UUID + " TEXT, "
                + EventTabel.VIDEO + " TEXT, "

                + EventTabel.IMAGE_PATH + " TEXT, "
                + EventTabel.IMAGE_CAPTION + " TEXT, "
                + EventTabel.IMAGE_THUMBNAIL + " TEXT, "
                + EventTabel.DESCRIPTION_NL + " TEXT, "
                + EventTabel.NAME_NL + " TEXT, "
                + EventTabel.OFFERS_NEW + " TEXT, "
                + EventTabel.OFFER_AVAILABLE_AT_OR_FROM + " TEXT, "
                + EventTabel.OFFER_DESCRIPTION + " TEXT, "
                + EventTabel.OFFER_PRICE_VALID_UNTIL + " TEXT, "
                + EventTabel.OFFER_PRICE_CURRENCY + " TEXT, "

                + EventTabel.OFFER_PRICE + " TEXT, "
                + EventTabel.OFFER_ELIGIBLE_FOR_DISCOUNT + " TEXT, "
                + EventTabel.VIDEO_NEW + " TEXT, "
                + EventTabel.VIDEO_CAPTION + " TEXT, "
                + EventTabel.VIDEO_EMBED_URL + " TEXT, "
                + EventTabel.VIDEO_THUMBNAIL + " TEXT, "
                + EventTabel.ADDRESS + " TEXT "

                + ");" );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // ZAL DE BESTAANDE TABEL VERWIJDEREN WANNEER ER EEN UPGRADE IS
        db.execSQL("DROP TABLE IF EXISTS " + EventTabel.TABEL_EVENT);
        db.execSQL("DROP TABLE IF EXISTS " + CategorieTabel.TABEL_CATEGORIE);

        /*
        db.execSQL("DROP TABLE IF EXISTS " + LocatieTabel.TABEL_NAAM);
        db.execSQL("DROP TABLE IF EXISTS " + OrganisatorTabel.TABEL_NAAM);
        */

        // AANMAAK VAN EEN NIEUWE INSTANTIE VAN HET SCHERM
        onCreate(db);
    }
}
