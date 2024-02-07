package be.davygevaert.gentsefeesten.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Davy on 12/06/2017.
 */
public class Organisator implements Parcelable {
    private String id;
    private String name;
    private String memberOf;
    private String url;
    private String uuid;

    public Organisator() {
        // empty constructor
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

    public String getMemberOf() {
        return id;
    }

    public void setMemberOf(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }




    public Organisator(Parcel in) {
        id = in.readString();
        name = in.readString();
        memberOf = in.readString();
        url = in.readString();
        uuid = in.readString();
    }

    public static final Creator<Organisator> CREATOR =
            new Creator<Organisator>() {
                @Override
                public Organisator createFromParcel(Parcel pc) {
                    return new Organisator(pc);
                }

                @Override
                public Organisator[] newArray(int size) {
                    return new Organisator[size];
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
        dest.writeString(memberOf);
        dest.writeString(url);
        dest.writeString(uuid);
    }
}
