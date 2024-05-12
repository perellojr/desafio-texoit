package texoit.enums;

public enum EndPoint {
    COMMENTS("/comments"),
    USERS("/users");

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
