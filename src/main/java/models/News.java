package models;

import java.util.Objects;

public class News {

private int newsId;
private String depNews;

//    public int getNewsId() {
//        return newsId;
//    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getDepNews() {
        return depNews;
    }

    public void setDepNews(String depNews) {
        this.depNews = depNews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getNewsId() == news.getNewsId() &&
                getDepNews().equals(news.getDepNews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNewsId(), getDepNews());
    }
}
