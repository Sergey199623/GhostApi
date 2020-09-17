package sv.ghost.apiposts.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrimaryTag implements Parcelable {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
//    @SerializedName("slug")
//    @Expose
//    public String slug;
//    @SerializedName("description")
//    @Expose
//    public Object description;
//    @SerializedName("feature_image")
//    @Expose
//    public Object featureImage;
//    @SerializedName("visibility")
//    @Expose
//    public String visibility;
//    @SerializedName("meta_title")
//    @Expose
//    public Object metaTitle;
//    @SerializedName("meta_description")
//    @Expose
//    public Object metaDescription;
//    @SerializedName("og_image")
//    @Expose
//    public Object ogImage;
//    @SerializedName("og_title")
//    @Expose
//    public Object ogTitle;
//    @SerializedName("og_description")
//    @Expose
//    public Object ogDescription;
//    @SerializedName("twitter_image")
//    @Expose
//    public Object twitterImage;
//    @SerializedName("twitter_title")
//    @Expose
//    public Object twitterTitle;
//    @SerializedName("twitter_description")
//    @Expose
//    public Object twitterDescription;
//    @SerializedName("codeinjection_head")
//    @Expose
//    public Object codeinjectionHead;
//    @SerializedName("codeinjection_foot")
//    @Expose
//    public Object codeinjectionFoot;
//    @SerializedName("canonical_url")
//    @Expose
//    public Object canonicalUrl;
//    @SerializedName("accent_color")
//    @Expose
//    public String accentColor;
//    @SerializedName("url")
//    @Expose
//    public String url;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    public PrimaryTag() {
    }

    protected PrimaryTag(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<PrimaryTag> CREATOR = new Parcelable.Creator<PrimaryTag>() {
        @Override
        public PrimaryTag createFromParcel(Parcel source) {
            return new PrimaryTag(source);
        }

        @Override
        public PrimaryTag[] newArray(int size) {
            return new PrimaryTag[size];
        }
    };
}
