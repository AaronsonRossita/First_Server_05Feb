package com.example.first_server_05feb.tv_maze;

public class TvMazeResponse {

    private Integer id;
    private String name;
    private String officialSite;

    public TvMazeResponse(Integer id, String name, String officialSite) {
        this.id = id;
        this.name = name;
        this.officialSite = officialSite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }
}
