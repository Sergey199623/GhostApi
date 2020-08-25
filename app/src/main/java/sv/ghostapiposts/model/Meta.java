
package sv.ghostapiposts.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta implements Parcelable
{

    @SerializedName("pagination")
    @Expose
    public Pagination pagination;
    public final static Parcelable.Creator<Meta> CREATOR = new Creator<Meta>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Meta createFromParcel(Parcel in) {
            return new Meta(in);
        }

        public Meta[] newArray(int size) {
            return (new Meta[size]);
        }

    }
    ;

    protected Meta(Parcel in) {
        this.pagination = ((Pagination) in.readValue((Pagination.class.getClassLoader())));
    }

    public Meta() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pagination);
    }

    public int describeContents() {
        return  0;
    }

}
