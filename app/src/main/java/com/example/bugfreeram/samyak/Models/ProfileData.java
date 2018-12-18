package com.example.bugfreeram.samyak.Models;

public class ProfileData {

    private int profileId;
    private String profileTitle;
    private String profileShortdesc;
    private int profileImage;

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileTitle() {
        return profileTitle;
    }

    public void setProfileTitle(String profileTitle) {
        this.profileTitle = profileTitle;
    }

    public String getProfileShortdesc() {
        return profileShortdesc;
    }

    public void setProfileShortdesc(String profileShortdesc) {
        this.profileShortdesc = profileShortdesc;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }
}
