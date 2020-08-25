
package sv.ghostapiposts.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GhostPost implements Parcelable
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
    public String featureImage;
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
    public String customExcerpt;
    @SerializedName("codeinjection_head")
    @Expose
    public String codeinjectionHead;
    @SerializedName("codeinjection_foot")
    @Expose
    public String codeinjectionFoot;
    @SerializedName("custom_template")
    @Expose
    public String customTemplate;
    @SerializedName("canonical_url")
    @Expose
    public String canonicalUrl;
    @SerializedName("send_email_when_published")
    @Expose
    public Boolean sendEmailWhenPublished;
    @SerializedName("primary_tag")
    @Expose
    public PrimaryTag primaryTag;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("excerpt")
    @Expose
    public String excerpt;
    @SerializedName("reading_time")
    @Expose
    public Integer readingTime;
    @SerializedName("access")
    @Expose
    public Boolean access;
    @SerializedName("og_image")
    @Expose
    public String ogImage;
    @SerializedName("og_title")
    @Expose
    public String ogTitle;
    @SerializedName("og_description")
    @Expose
    public String ogDescription;
    @SerializedName("twitter_image")
    @Expose
    public String twitterImage;
    @SerializedName("twitter_title")
    @Expose
    public String twitterTitle;
    @SerializedName("twitter_description")
    @Expose
    public String twitterDescription;
    @SerializedName("meta_title")
    @Expose
    public String metaTitle;
    @SerializedName("meta_description")
    @Expose
    public String metaDescription;
    @SerializedName("email_subject")
    @Expose
    public String emailSubject;

    public String getTag(){
        if(primaryTag!=null) return primaryTag.name;
        return null;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.uuid);
        dest.writeString(this.title);
        dest.writeString(this.slug);
        dest.writeString(this.html);
        dest.writeString(this.commentId);
        dest.writeString(this.featureImage);
        dest.writeValue(this.featured);
        dest.writeString(this.visibility);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
        dest.writeString(this.publishedAt);
        dest.writeString(this.customExcerpt);
        dest.writeString(this.codeinjectionHead);
        dest.writeString(this.codeinjectionFoot);
        dest.writeString(this.customTemplate);
        dest.writeString(this.canonicalUrl);
        dest.writeValue(this.sendEmailWhenPublished);
        dest.writeParcelable(this.primaryTag, flags);
        dest.writeString(this.url);
        dest.writeString(this.excerpt);
        dest.writeValue(this.readingTime);
        dest.writeValue(this.access);
        dest.writeString(this.ogImage);
        dest.writeString(this.ogTitle);
        dest.writeString(this.ogDescription);
        dest.writeString(this.twitterImage);
        dest.writeString(this.twitterTitle);
        dest.writeString(this.twitterDescription);
        dest.writeString(this.metaTitle);
        dest.writeString(this.metaDescription);
        dest.writeString(this.emailSubject);
    }

    public GhostPost() {
    }

    protected GhostPost(Parcel in) {
        this.id = in.readString();
        this.uuid = in.readString();
        this.title = in.readString();
        this.slug = in.readString();
        this.html = in.readString();
        this.commentId = in.readString();
        this.featureImage = in.readString();
        this.featured = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.visibility = in.readString();
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
        this.publishedAt = in.readString();
        this.customExcerpt = in.readString();
        this.codeinjectionHead = in.readString();
        this.codeinjectionFoot = in.readString();
        this.customTemplate = in.readString();
        this.canonicalUrl = in.readString();
        this.sendEmailWhenPublished = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.primaryTag = in.readParcelable(PrimaryTag.class.getClassLoader());
        this.url = in.readString();
        this.excerpt = in.readString();
        this.readingTime = (Integer) in.readValue(Integer.class.getClassLoader());
        this.access = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.ogImage = in.readString();
        this.ogTitle = in.readString();
        this.ogDescription = in.readString();
        this.twitterImage = in.readString();
        this.twitterTitle = in.readString();
        this.twitterDescription = in.readString();
        this.metaTitle = in.readString();
        this.metaDescription = in.readString();
        this.emailSubject = in.readString();
    }

    public static final Creator<GhostPost> CREATOR = new Creator<GhostPost>() {
        @Override
        public GhostPost createFromParcel(Parcel source) {
            return new GhostPost(source);
        }

        @Override
        public GhostPost[] newArray(int size) {
            return new GhostPost[size];
        }
    };
}
