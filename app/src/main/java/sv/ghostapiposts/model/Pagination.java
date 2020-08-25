
package sv.ghostapiposts.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination implements Parcelable
{

    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("limit")
    @Expose
    public Integer limit;
    @SerializedName("pages")
    @Expose
    public Integer pages;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("next")
    @Expose
    public Object next;
    @SerializedName("prev")
    @Expose
    public Object prev;
    public final static Parcelable.Creator<Pagination> CREATOR = new Creator<Pagination>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pagination createFromParcel(Parcel in) {
            return new Pagination(in);
        }

        public Pagination[] newArray(int size) {
            return (new Pagination[size]);
        }

    }
    ;

    protected Pagination(Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.limit = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.next = ((Object) in.readValue((Object.class.getClassLoader())));
        this.prev = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Pagination() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(limit);
        dest.writeValue(pages);
        dest.writeValue(total);
        dest.writeValue(next);
        dest.writeValue(prev);
    }

    public int describeContents() {
        return  0;
    }

}
