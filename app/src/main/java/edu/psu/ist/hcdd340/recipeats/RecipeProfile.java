package edu.psu.ist.hcdd340.recipeats;

final class RecipeProfile {

    //Attributes for Recipe Profile
    private final int profileName;
    private final int profileDesc;
    private boolean isLiked;
    private final int profileImageID;

    //Recipe constructor
    RecipeProfile(int profileName, int profileDesc, boolean isLiked, int profileImageID) {
        this.profileName = profileName;
        this.profileDesc = profileDesc;
        this.isLiked = isLiked;
        this.profileImageID = profileImageID;
    }


    //Returns in recipe profile's imageID
    public int getProfileImageID() {
        return profileImageID;
    }

    //Returns the recipe profile's name
    public int getProfileName() {
        return profileName;
    }

    //Returns a boolean that stores whether that recipe has been liked by the user
    public boolean getProfileLikeStatus() {
        return isLiked;
    }

    //Sets the like status of each recipe
    public void setProfileLikeStatus(boolean status) {
        this.isLiked = status;
    }

    //Returns the recipe profile's description
    public int getProfileDesc() {
        return profileDesc;
    }

}

