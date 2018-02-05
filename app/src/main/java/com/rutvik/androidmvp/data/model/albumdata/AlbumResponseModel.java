
package com.rutvik.androidmvp.data.model.albumdata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumResponseModel implements Parcelable
{

    @SerializedName("albumId")
    @Expose
    private int albumId;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;
    public final static Creator<AlbumResponseModel> CREATOR = new Creator<AlbumResponseModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AlbumResponseModel createFromParcel(Parcel in) {
            return new AlbumResponseModel(in);
        }

        public AlbumResponseModel[] newArray(int size) {
            return (new AlbumResponseModel[size]);
        }

    }
    ;

    protected AlbumResponseModel(Parcel in) {
        this.albumId = ((int) in.readValue((int.class.getClassLoader())));
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnailUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AlbumResponseModel() {
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(albumId);
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(url);
        dest.writeValue(thumbnailUrl);
    }

    public int describeContents() {
        return  0;
    }

}
