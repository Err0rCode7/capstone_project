package com.example.capsuletime.mainpages.followpage;

public class Follow {
    private String profile;
    private String nick_name;
    private String name;


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Follow(String profile, String nick_name, String name) {
        this.profile = profile;
        this.nick_name = nick_name;
        this.name = name;
    }
}
