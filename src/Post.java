import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Post {
    private final String title;
    private final String body;
    private final List<String> tags;
    private final String difficulty;
    private final String urgency;
    private final List<String> comments;

    // Constructor
    public Post(String title, String body, List<String> tags, String difficulty, String urgency) {
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.difficulty = difficulty;
        this.urgency = urgency;
        this.comments = new ArrayList<>();
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getUrgency() {
        return urgency;
    }

    public List<String> getComments() {
        return comments;
    }

    public boolean addPost() {
        if (!isValidPost()) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("post.txt", true))) {
            writer.write(this.toString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isValidPost() {
        if (title == null || body == null || tags == null || difficulty == null || urgency == null) {
            return false;
        }

        if (title.length() < 10 || title.length() > 250 || !Pattern.matches("^[A-Za-z]{5}.*", title)) {
            return false;
        }

        if (body.length() < 250 ||
                ("Very Difficult".equals(difficulty) && body.length() < 300) ||
                ("Difficult".equals(difficulty) && body.length() < 300)) {
            return false;
        }

        if (tags.size() < 2 || tags.size() > 5 || tags.stream().anyMatch(tag ->
                tag.length() < 2 || tag.length() > 10 || !tag.equals(tag.toLowerCase()))) {
            return false;
        }

        if ("Easy".equals(difficulty) && tags.size() > 3) {
            return false;
        }

        if ("Easy".equals(difficulty) && ("Immediately Needed".equals(urgency) || "Highly Needed".equals(urgency))) {
            return false;
        }

        if (("Very Difficult".equals(difficulty) || "Difficult".equals(difficulty)) && "Ordinary".equals(urgency)) {
            return false;
        }

        return true;
    }

    public boolean addComment(String comment) {
        comments.add(comment);

        if (comments.size() > 5 ||
                ("Easy".equals(difficulty) && comments.size() > 3) ||
                ("Ordinary".equals(urgency) && comments.size() > 3)) {
            return false;
        }

        if (comment == null || !isValidComment(comment)) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("comment.txt", true))) {
            writer.write(comment);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isValidComment(String comment) {
        String[] words = comment.split("\\s+");
        return words.length >= 4 && words.length <= 10 && Character.isUpperCase(words[0].charAt(0));
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nBody: " + body + "\nTags: " + tags.toString() +
                "\nDifficulty: " + difficulty + "\nUrgency: " + urgency + "\n";
    }
}
