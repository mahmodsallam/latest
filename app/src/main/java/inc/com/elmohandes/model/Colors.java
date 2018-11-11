package inc.com.elmohandes.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;


@Entity
public class Colors implements Parcelable {

    //fields
    @PrimaryKey(autoGenerate = true)
    private int id ;
    @ColumnInfo(name = "code")
    private String code;
    @ColumnInfo(name = "name")
    private String name;

    //constructor
    protected Colors(Parcel in) {
        name = in.readString();
        code = in.readString();
    }

    public Colors(String name, String code) {

        this.name = name;
        this.code = code;
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public static final Creator<Colors> CREATOR = new Creator<Colors>() {
        @Override
        public Colors createFromParcel(Parcel in) {
            return new Colors(in);
        }

        @Override
        public Colors[] newArray(int size) {
            return new Colors[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(code);
    }
}
