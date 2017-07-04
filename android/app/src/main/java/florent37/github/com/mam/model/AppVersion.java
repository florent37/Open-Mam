package florent37.github.com.mam.model;

/**
 * Created by florentchampigny on 18/06/2017.
 */

public class AppVersion {
    private String date;
    private String version;
    private String code;
    private String url;
    private String comment;

    public AppVersion() {
    }

    public AppVersion(String version,  String code, String date, String url) {
        this.date = date;
        this.version = version;
        this.code = code;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
