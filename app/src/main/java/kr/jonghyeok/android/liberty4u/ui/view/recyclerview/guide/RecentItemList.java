package kr.jonghyeok.android.liberty4u.ui.view.recyclerview.guide;

public class RecentItemList {
    private String imageUrl;
    private String title;
    private String description;

    public RecentItemList(String imageUrl, String title, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
