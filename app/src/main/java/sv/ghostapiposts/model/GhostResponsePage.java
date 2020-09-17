
package sv.ghostapiposts.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GhostResponsePage implements Parcelable
{

    @SerializedName("pages")
    @Expose
    public List<GhostPage> pages = null;
    @SerializedName("meta")
    @Expose
    public Meta meta;
    public final static Parcelable.Creator<GhostResponsePage> CREATOR = new Creator<GhostResponsePage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GhostResponsePage createFromParcel(Parcel in) {
            return new GhostResponsePage(in);
        }

        public GhostResponsePage[] newArray(int size) {
            return (new GhostResponsePage[size]);
        }

    }
    ;

    protected GhostResponsePage(Parcel in) {
        in.readList(this.pages, (GhostPage.class.getClassLoader()));
        this.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
    }

    public GhostResponsePage() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(pages);
        dest.writeValue(meta);
    }

    public int describeContents() {
        return  0;
    }

}
