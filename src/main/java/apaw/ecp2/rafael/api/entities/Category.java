package apaw.ecp2.rafael.api.entities;

public class Category {
    private long id;

    private int rank;

    private String title;

    public Category(long id, int rank, String title) {
        super();
        this.id = id;
        this.rank = rank;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
