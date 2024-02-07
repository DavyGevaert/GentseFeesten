package be.davygevaert.gentsefeesten.databank;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import be.davygevaert.gentsefeesten.constanten.OrganisatorTabel;
import be.davygevaert.gentsefeesten.model.Organisator;


public class OrganisatorDB extends SchemaHelper {


    private SQLiteDatabase sd;
    private ArrayList<Organisator> themasArrayLijst;

    public OrganisatorDB(Context context) {
        super(context);
    }

    public long addCategorie(Organisator organisator) {
        // AANMAAK VAN EEN CONTENTVALUE OBJECT
        ContentValues cv = new ContentValues();

        cv.put(OrganisatorTabel.ID, organisator.getId());
        cv.put(OrganisatorTabel.NAME, organisator.getName());
        cv.put(OrganisatorTabel.MEMBEROF, organisator.getMemberOf());
        cv.put(OrganisatorTabel.URL, organisator.getUrl());
        cv.put(OrganisatorTabel.UUID, organisator.getUuid());

        // BEKOMEN VAN EEN SCHRIJFBARE DATABANK EN VERVOLGENS DE RECORD TOEVOEGEN
        sd = this.getWritableDatabase();

        long result = sd.insert(OrganisatorTabel.TABEL_ORGANISATOR, OrganisatorTabel.NAME, cv);
        return result;
    }
}