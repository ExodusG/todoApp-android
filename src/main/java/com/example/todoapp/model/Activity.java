package com.example.todoapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *  This class allow you to create an activity with a name, a place, a time and a hour
 * @author Quentin Le Lan
 */
public class Activity implements Parcelable {

    /**
    *the name of the activity
     */
    private String intitule;

    /**
     * the place
     */
    private String lieu;

    /**
     * the descripition
     */
    private String description;

    /**
     * the date of begin
     */
    private String dateDebut;

    /**
     * the date of the end
     */
    private String dateFin;

    /**
     * the hour of begin
     */
    private String heureDebut;

    /**
     * the hour of end
     */
    private String heureFin;

    /**
     * the url to a website
     */
    private String url;


    /**
     * the constructor of Activity
     * @param intitule the name
     * @param lieu the place
     * @param description the description
     * @param dateDebut the date of the begin
     * @param dateFin the date of the end
     * @param heureDebut the hour of the begin
     * @param heureFin the hour of the end
     */
    public Activity(String intitule, String lieu, String description, String dateDebut, String dateFin, String heureDebut, String heureFin) {
        this.intitule = intitule;
        this.lieu = lieu;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    /**
     * the simple constructor
     */
    public Activity() {
    }

    protected Activity(Parcel in) {
        intitule = in.readString();
        lieu = in.readString();
        description = in.readString();
        dateDebut = in.readString();
        dateFin = in.readString();
        heureDebut = in.readString();
        heureFin = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(intitule);
        dest.writeString(lieu);
        dest.writeString(description);
        dest.writeString(dateDebut);
        dest.writeString(dateFin);
        dest.writeString(heureDebut);
        dest.writeString(heureFin);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Activity> CREATOR = new Creator<Activity>() {
        @Override
        public Activity createFromParcel(Parcel in) {
            return new Activity(in);
        }

        @Override
        public Activity[] newArray(int size) {
            return new Activity[size];
        }
    };

    /**
     * getteur of the name
     * @return the name
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * the getter of the place
     * @return the place
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * the setter of the name
     * @param intitule the name
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     * setter of the place
     * @param lieu the place
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * the getter of the description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * the setter of the description
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter of date of begin
     * @return the date of the begin
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * setteur of the date of begin
     * @param dateDebut the date of the begin
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * getter of the date of the end
     * @return the date of the end
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * setter of date of end
     * @param dateFin date of end
     */
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * getter of hour of begin
     * @return the hour of begin
     */
    public String getHeureDebut() {
        return heureDebut;
    }

    /**
     * the setter of hour of begin
     * @param heureDebut the setter of hour of begin
     */
    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    /**
     * getter if hour of end
     * @return hour of end
     */
    public String getHeureFin() {
        return heureFin;
    }

    /**
     * setter of hour of end
     * @param heureFin hour of end
     */
    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    /**
     * getteur of URL
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * setteur of url
     * @param url new URL
     */
    public void setUrl(String url) {
        this.url = url;
    }


}
