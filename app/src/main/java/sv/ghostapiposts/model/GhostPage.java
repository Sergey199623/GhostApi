
package sv.ghostapiposts.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GhostPage implements Parcelable
{

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("uuid")
    @Expose
    public String uuid;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("html")
    @Expose
    public String html;
    @SerializedName("comment_id")
    @Expose
    public String commentId;
    @SerializedName("feature_image")
    @Expose
    public Object featureImage;
    @SerializedName("featured")
    @Expose
    public Boolean featured;
    @SerializedName("visibility")
    @Expose
    public String visibility;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("published_at")
    @Expose
    public String publishedAt;
    @SerializedName("custom_excerpt")
    @Expose
    public Object customExcerpt;
    @SerializedName("codeinjection_head")
    @Expose
    public Object codeinjectionHead;
    @SerializedName("codeinjection_foot")
    @Expose
    public Object codeinjectionFoot;
    @SerializedName("custom_template")
    @Expose
    public Object customTemplate;
    @SerializedName("canonical_url")
    @Expose
    public Object canonicalUrl;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("excerpt")
    @Expose
    public String excerpt;
    @SerializedName("reading_time")
    @Expose
    public Integer readingTime;
    @SerializedName("page")
    @Expose
    public Boolean page;
    @SerializedName("access")
    @Expose
    public Boolean access;
    @SerializedName("og_image")
    @Expose
    public Object ogImage;
    @SerializedName("og_title")
    @Expose
    public Object ogTitle;
    @SerializedName("og_description")
    @Expose
    public Object ogDescription;
    @SerializedName("twitter_image")
    @Expose
    public Object twitterImage;
    @SerializedName("twitter_title")
    @Expose
    public Object twitterTitle;
    @SerializedName("twitter_description")
    @Expose
    public Object twitterDescription;
    @SerializedName("meta_title")
    @Expose
    public Object metaTitle;
    @SerializedName("meta_description")
    @Expose
    public Object metaDescription;
    public final static Parcelable.Creator<GhostPage> CREATOR = new Creator<GhostPage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GhostPage createFromParcel(Parcel in) {
            return new GhostPage(in);
        }

        public GhostPage[] newArray(int size) {
            return (new GhostPage[size]);
        }

    }
    ;

    protected GhostPage(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.uuid = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.html = ((String) in.readValue((String.class.getClassLoader())));
        this.commentId = ((String) in.readValue((String.class.getClassLoader())));
        this.featureImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.featured = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.visibility = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.publishedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.customExcerpt = ((Object) in.readValue((Object.class.getClassLoader())));
        this.codeinjectionHead = ((Object) in.readValue((Object.class.getClassLoader())));
        this.codeinjectionFoot = ((Object) in.readValue((Object.class.getClassLoader())));
        this.customTemplate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.canonicalUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.excerpt = ((String) in.readValue((String.class.getClassLoader())));
        this.readingTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.page = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.access = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.ogImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.ogTitle = ((Object) in.readValue((Object.class.getClassLoader())));
        this.ogDescription = ((Object) in.readValue((Object.class.getClassLoader())));
        this.twitterImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.twitterTitle = ((Object) in.readValue((Object.class.getClassLoader())));
        this.twitterDescription = ((Object) in.readValue((Object.class.getClassLoader())));
        this.metaTitle = ((Object) in.readValue((Object.class.getClassLoader())));
        this.metaDescription = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public GhostPage() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(uuid);
        dest.writeValue(title);
        dest.writeValue(slug);
        dest.writeValue(html);
        dest.writeValue(commentId);
        dest.writeValue(featureImage);
        dest.writeValue(featured);
        dest.writeValue(visibility);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(publishedAt);
        dest.writeValue(customExcerpt);
        dest.writeValue(codeinjectionHead);
        dest.writeValue(codeinjectionFoot);
        dest.writeValue(customTemplate);
        dest.writeValue(canonicalUrl);
        dest.writeValue(url);
        dest.writeValue(excerpt);
        dest.writeValue(readingTime);
        dest.writeValue(page);
        dest.writeValue(access);
        dest.writeValue(ogImage);
        dest.writeValue(ogTitle);
        dest.writeValue(ogDescription);
        dest.writeValue(twitterImage);
        dest.writeValue(twitterTitle);
        dest.writeValue(twitterDescription);
        dest.writeValue(metaTitle);
        dest.writeValue(metaDescription);
    }

    public int describeContents() {
        return  0;
    }

}
