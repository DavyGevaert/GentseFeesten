package be.davygevaert.gentsefeesten.databank;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import be.davygevaert.gentsefeesten.constanten.CategorieTabel;
import be.davygevaert.gentsefeesten.model.Categorie;

/** @noinspection UnresolvedClassReferenceRepair*/
public class CategorieDB extends SchemaHelper {

    
    private SQLiteDatabase sd;
    private ArrayList<Categorie> themasArrayLijst;

    public CategorieDB(Context context) {
        super(context);
    }

    public long addCategorie(Categorie categorie) {
        // AANMAAK VAN EEN CONTENTVALUE OBJECT
        ContentValues cv = new ContentValues();

        cv.put(CategorieTabel.ID, categorie.getId());
        cv.put(CategorieTabel.NAME, categorie.getName());
        cv.put(CategorieTabel.UUID, categorie.getUuid());

        // BEKOMEN VAN EEN SCHRIJFBARE DATABANK EN VERVOLGENS DE RECORD TOEVOEGEN
        sd = this.getWritableDatabase();

        long result = sd.insert(CategorieTabel.TABEL_CATEGORIE, CategorieTabel.NAME, cv);
        return result;
    }
}
