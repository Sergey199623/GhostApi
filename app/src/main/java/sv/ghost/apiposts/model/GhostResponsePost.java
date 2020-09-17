
package sv.ghost.apiposts.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GhostResponsePost implements Parcelable
{

    @SerializedName("posts")
    @Expose
    public ArrayList<GhostPost> posts = null;
    @SerializedName("meta")
    @Expose
    public Meta meta;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.posts);
        dest.writeParcelable(this.meta, flags);
    }

    public GhostResponsePost() {
    }

    protected GhostResponsePost(Parcel in) {
        this.posts = in.createTypedArrayList(GhostPost.CREATOR);
        this.meta = in.readParcelable(Meta.class.getClassLoader());
    }

    public static final Creator<GhostResponsePost> CREATOR = new Creator<GhostResponsePost>() {
        @Override
        public GhostResponsePost createFromParcel(Parcel source) {
            return new GhostResponsePost(source);
        }

        @Override
        public GhostResponsePost[] newArray(int size) {
            return new GhostResponsePost[size];
        }
    };
}
