package inc.com.elmohandes.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    String name;
    String address;
    String pBox;
    String phone;
    String website;

    protected Contact(Parcel in) {
        name = in.readString();
        address = in.readString();
        pBox = in.readString();
        phone = in.readString();
        website = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getpBox() {
        return pBox;
    }

    public void setpBox(String pBox) {
        this.pBox = pBox;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Contact(String name, String address, String pBox, String phone, String website) {

        this.name = name;
        this.address = address;
        this.pBox = pBox;
        this.phone = phone;
        this.website = website;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(pBox);
        dest.writeString(phone);
        dest.writeString(website);
    }
}
