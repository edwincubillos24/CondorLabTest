package com.edwinacubillos.condorlabtest.model;

public class Movie {
    String id,poster_path, title,vote_average,overview,release_date,video_path;
    boolean video,favorite;

    public Movie(String id, String poster_path, String title, String vote_average, String overview, String release_date, boolean video) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
        this.video = video;
    }

    public Movie(String id, String poster_path, String title, String vote_average, String overview, String release_date, String video_path, boolean video) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
        this.video_path = video_path;
        this.video = video;
    }

    public Movie(String id, String poster_path, String title, String vote_average, String overview, String release_date, String video_path, boolean video, boolean favorite) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
        this.video_path = video_path;
        this.video = video;
        this.favorite = favorite;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }
}
