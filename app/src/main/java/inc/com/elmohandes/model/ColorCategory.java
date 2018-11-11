package inc.com.elmohandes.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ColorCategory implements Parcelable
{
    String categoryName;
    String numebrOfPic ;
    String image ;

    public ColorCategory(String categoryName, String numebrOfPic, String image) {
        this.categoryName = categoryName;
        this.numebrOfPic = numebrOfPic;
        this.image = image;
    }

    protected ColorCategory(Parcel in) {
        categoryName = in.readString();
        numebrOfPic = in.readString();
        image = in.readString();
    }

    public static final Creator<ColorCategory> CREATOR = new Creator<ColorCategory>() {
        @Override
        public ColorCategory createFromParcel(Parcel in) {
            return new ColorCategory(in);
        }

        @Override
        public ColorCategory[] newArray(int size) {
            return new ColorCategory[size];
        }
    };

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getNumebrOfPic() {
        return numebrOfPic;
    }

    public void setNumebrOfPic(String numebrOfPic) {
        this.numebrOfPic = numebrOfPic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(categoryName);
        dest.writeString(numebrOfPic);
        dest.writeString(image);
    }
}
