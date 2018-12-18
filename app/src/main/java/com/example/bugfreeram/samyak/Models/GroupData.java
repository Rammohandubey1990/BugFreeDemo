package com.example.bugfreeram.samyak.Models;

public class GroupData {

    private int groupId;
    private String groupTitle;
    private String groupShortdesc;
    private int groupImage;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getGroupShortdesc() {
        return groupShortdesc;
    }

    public void setGroupShortdesc(String groupShortdesc) {
        this.groupShortdesc = groupShortdesc;
    }

    public int getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(int groupImage) {
        this.groupImage = groupImage;
    }

    public GroupData(int groupId, String groupTitle, String groupShortdesc, int groupImage) {

        this.groupId = groupId;
        this.groupTitle = groupTitle;
        this.groupShortdesc = groupShortdesc;
        this.groupImage = groupImage;
    }
}
