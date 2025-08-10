package notepad.org;

public class Note {
    private int id;
    private String title;
    private String content;
    private String category;
    private String tags;
    private String createdAt;
 
    public Note() {}

    public Note(String title, String content, String category, String tags) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = tags;
    }

    public Note(int id, String title, String content, String category, String tags, String createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = tags;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}