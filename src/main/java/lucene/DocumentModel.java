package lucene;

public class DocumentModel {

    private Integer id;
    private String title;
    private String author;
    private String bibliography;
    private String content;

    public DocumentModel(Integer id) {
        this.id = id;
        this.title = "";
        this.author = "";
        this.bibliography = "";
        this.content = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBibliography() {
        return bibliography;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
