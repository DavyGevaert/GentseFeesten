package be.davygevaert.gentsefeesten.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Categorie implements Parcelable {
    private String id;
    private String name;
    private String uuid;

    public Categorie() {
        // empty constructor
    }

    public Categorie(Parcel in) {
        id = in.readString();
        name = in.readString();
        uuid = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public static final Creator<Categorie> CREATOR =
            new Creator<Categorie>() {
                @Override
                public Categorie createFromParcel(Parcel pc) {
                    return new Categorie(pc);
                }

                @Override
                public Categorie[] newArray(int size) {
                    return new Categorie[size];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(uuid);
    }
}
