package be.davygevaert.gentsefeesten.model;

import android.os.Parcel;
import android.os.Parcelable;

import kotlin.ranges.OpenEndRange;

/**
 * Created by Davy on 05/02/2024.
 */
public class Event implements Parcelable {
    private String id;
    private String type;
    private String changed;
    private String contactPoint;
    private String contributor;
    private String created;
    private String description;
    private String duration;
    private String enddate;
    private String frequency;
    private String image;
    private String inlanguage;
    private String isaccessibleforfree;
    private String ispartof;
    private String iswheelchairunfriendly;
    private String keywords;
    private String location;
    private String music_genre;
    private String name;
    private String offers;
    private String organizer;
    private String outdoors;
    private String startdate;
    private String subevent;
    private String superevent;
    private String theme;
    private String typicalagerange;
    private String url;
    private String uuid;
    private String video;
    private String image_path;
    private String image_caption;
    private String image_thumbnail;
    private String description_nl;
    private String name_nl;
    private String offers_new;
    private String offer_availableatorfrom;
    private String offer_description;
    private String offer_pricevaliduntil;
    private String offer_pricecurrency;
    private String offer_price;
    private String offer_eligiblefordiscount;
    private String video_new;
    private String video_caption;
    private String video_embedurl;
    private String video_thumbnail;
    private String address;
    private Categorie categorie;
    private Locatie locatie;
    private Organisator organisator;

    public Event() {
        // empty constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public String getContactPoint() {
        return contactPoint;
    }

    public void setContactPoint(String contactPoint) {
        this.contactPoint = contactPoint;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInlanguage() {
        return inlanguage;
    }

    public void setInlanguage(String inlanguage) {
        this.inlanguage = inlanguage;
    }

    public String getIsaccessibleforfree() {
        return isaccessibleforfree;
    }

    public void setIsaccessibleforfree(String isaccessibleforfree) {  this.isaccessibleforfree = isaccessibleforfree; }

    public String getIspartof() {
        return ispartof;
    }

    public void setIspartof(String ispartof) {
        this.ispartof = ispartof;
    }

    public String getIswheelchairunfriendly() {
        return iswheelchairunfriendly;
    }

    public void setIswheelchairunfriendly(String iswheelchairunfriendly) {
        this.iswheelchairunfriendly = iswheelchairunfriendly;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMusic_genre() {
        return music_genre;
    }

    public void setMusic_genre(String music_genre) {
        this.music_genre = music_genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getOutdoors() {
        return outdoors;
    }

    public void setOutdoors(String outdoors) {
        this.outdoors = outdoors;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getSubevent() {
        return subevent;
    }

    public void setSubevent(String subevent) {
        this.subevent = subevent;
    }

    public String getSuperevent() {
        return superevent;
    }

    public void setSuperevent(String superevent) {
        this.superevent = superevent;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTypicalagerange() {
        return typicalagerange;
    }

    public void setTypicalagerange(String typicalagerange) {
        this.typicalagerange = typicalagerange;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }


    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String imagePath) {
        this.image_path = imagePath;
    }


    public String getImage_caption() {
        return image_caption;
    }

    public void setImage_caption(String image_caption) {
        this.image_caption = image_caption;
    }


    public String getImage_thumbnail() {
        return image_thumbnail;
    }

    public void setImage_thumbnail(String image_thumbnail) {
        this.image_thumbnail = image_thumbnail;
    }


    public String getDescription_nl() {
        return description_nl;
    }

    public void setDescription_nl(String description_nl) {
        this.description_nl = description_nl;
    }


    public String getName_nl() {
        return name_nl;
    }

    public void setName_nl(String name_nl) {
        this.name_nl = name_nl;
    }


    public String getOffers_new() {
        return offers_new;
    }

    public void setOffers_new(String offers_new) {
        this.offers_new = offers_new;
    }


    public String getOffer_availableatorfrom() {
        return offer_availableatorfrom;
    }

    public void setOffer_availableatorfrom(String offer_availableatorfrom) {
        this.offer_availableatorfrom = offer_availableatorfrom;
    }


    public String getOffer_description() {
        return offer_description;
    }

    public void setOffer_description(String offer_description) {
        this.offer_description = offer_description;
    }


    public String getOffer_pricevaliduntil() {
        return offer_pricevaliduntil;
    }

    public void setOffer_pricevaliduntil(String offer_pricevaliduntil) {
        this.offer_pricevaliduntil = offer_pricevaliduntil;
    }


    public String getOffer_pricecurrency() {
        return offer_pricecurrency;
    }

    public void setOffer_pricecurrency(String offer_pricecurrency) {
        this.offer_pricecurrency = offer_pricecurrency;
    }


    public String getOffer_price() {
        return offer_price;
    }

    public void setOffer_price(String offer_price) {
        this.offer_price = offer_price;
    }


    public String getOffer_eligiblefordiscount() {
        return offer_eligiblefordiscount;
    }

    public void setOffer_eligiblefordiscount(String offer_eligiblefordiscount) {
        this.offer_eligiblefordiscount = offer_eligiblefordiscount;
    }


    public String getVideo_new() {
        return video_new;
    }

    public void setVideo_new(String video_new) {
        this.video_new = video_new;
    }


    public String getVideo_caption() {
        return video_caption;
    }

    public void setVideo_caption(String video_caption) {
        this.video_caption = video_caption;
    }


    public String getVideo_embedurl() {
        return video_embedurl;
    }

    public void setVideo_embedurl(String video_embedurl) {
        this.video_embedurl = video_embedurl;
    }


    public String getVideo_thumbnail() {
        return video_thumbnail;
    }

    public void setVideo_thumbnail(String video_thumbnail) {
        this.video_thumbnail = video_thumbnail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    public Organisator getOrganisator() {
        return organisator;
    }

    public void setOrganisator(Organisator organisator) {
        this.organisator = organisator;
    }



    public Event(Parcel in) {
        id = in.readString();
        type = in.readString();
        changed = in.readString();
        contactPoint = in.readString();
        contributor = in.readString();
        created = in.readString();
        description = in.readString();
        duration = in.readString();
        enddate = in.readString();
        frequency = in.readString();
        image = in.readString();
        inlanguage = in.readString();
        isaccessibleforfree = in.readString();
        ispartof = in.readString();
        iswheelchairunfriendly = in.readString();
        keywords = in.readString();
        location = in.readString();
        music_genre = in.readString();
        name = in.readString();
        offers = in.readString();
        organizer = in.readString();
        outdoors = in.readString();
        startdate = in.readString();
        subevent = in.readString();
        superevent = in.readString();
        theme = in.readString();
        typicalagerange = in.readString();
        url = in.readString();
        uuid = in.readString();
        video = in.readString();
        image_path = in.readString();
        image_caption = in.readString();
        image_thumbnail = in.readString();
        description_nl = in.readString();
        name_nl = in.readString();
        offers_new = in.readString();
        offer_availableatorfrom = in.readString();
        offer_description = in.readString();
        offer_pricevaliduntil = in.readString();
        offer_pricecurrency = in.readString();
        offer_price = in.readString();
        offer_eligiblefordiscount = in.readString();
        video_new = in.readString();
        video_caption = in.readString();
        video_embedurl = in.readString();
        video_thumbnail = in.readString();
        address = in.readString();
        categorie = in.readParcelable(Categorie.class.getClassLoader());
        locatie = in.readParcelable(Locatie.class.getClassLoader());
        organisator = in.readParcelable(Organisator.class.getClassLoader());
    }

    public static final Creator<Event> CREATOR =
            new Creator<Event>() {
                @Override
                public Event createFromParcel(Parcel pc) {
                    return new Event(pc);
                }

                @Override
                public Event[] newArray(int size) {
                    return new Event[size];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(type);
        dest.writeString(changed);
        dest.writeString(contactPoint);
        dest.writeString(contributor);
        dest.writeString(created);
        dest.writeString(description);
        dest.writeString(duration);
        dest.writeString(enddate);
        dest.writeString(frequency);
        dest.writeString(image);
        dest.writeString(inlanguage);
        dest.writeString(isaccessibleforfree);
        dest.writeString(ispartof);
        dest.writeString(iswheelchairunfriendly);
        dest.writeString(keywords);
        dest.writeString(location);
        dest.writeString(music_genre);
        dest.writeString(name);
        dest.writeString(offers);
        dest.writeString(organizer);
        dest.writeString(outdoors);
        dest.writeString(startdate);
        dest.writeString(subevent);
        dest.writeString(superevent);
        dest.writeString(theme);
        dest.writeString(typicalagerange);
        dest.writeString(url);
        dest.writeString(uuid);
        dest.writeString(video);
        dest.writeString(image_path);
        dest.writeString(image_caption);
        dest.writeString(image_thumbnail);
        dest.writeString(description_nl);
        dest.writeString(name_nl);
        dest.writeString(offers_new);
        dest.writeString(offer_availableatorfrom);
        dest.writeString(offer_description);
        dest.writeString(offer_pricevaliduntil);
        dest.writeString(offer_pricecurrency);
        dest.writeString(offer_price);
        dest.writeString(offer_eligiblefordiscount);
        dest.writeString(video_new);
        dest.writeString(video_caption);
        dest.writeString(video_embedurl);
        dest.writeString(video_thumbnail);
        dest.writeString(address);
        dest.writeParcelable(categorie, flags);
        dest.writeParcelable(locatie, flags);
        dest.writeParcelable(organisator, flags);
    }
}
