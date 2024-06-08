import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PostTest {
    private Post post;

    @BeforeEach
    public void setUp() {
        // Valid post setup
        List<String> tags = Arrays.asList("java", "programming");
        post = new Post("Valid Title", "This is a valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags, "Difficult", "Highly Needed");
    }

    @Test
    public void testAddPostSuccess() {
        List<String> tags1 = Arrays.asList("java", "tutorial");
        Post validPost1 = new Post("Valid Title", "This is a valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags1, "Difficult", "Highly Needed");

        List<String> tags2 = Arrays.asList("tag1", "tag2");
        Post validPost2 = new Post("Another Valid Title", "This is another valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags2, "Difficult", "Highly Needed");

        assertTrue(validPost1.addPost());
        assertTrue(validPost2.addPost());
    }

    @Test
    public void testAddPostFailureDueToShortTitle() {
        List<String> tags1 = Arrays.asList("java", "programming");
        Post shortTitlePost1 = new Post("Short", "This is a valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags1, "Difficult", "Highly Needed");

        List<String> tags2 = Arrays.asList("tag1", "tag2");
        Post shortTitlePost2 = new Post("Short", "Another valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags2, "Difficult", "Highly Needed");

        assertFalse(shortTitlePost1.addPost());
        assertFalse(shortTitlePost2.addPost());
    }

    @Test
    public void testAddPostFailureDueToShortBody() {
        List<String> tags1 = Arrays.asList("java", "programming");
        Post shortBodyPost1 = new Post("Valid Title", "Short body.", tags1, "Difficult", "Highly Needed");

        List<String> tags2 = Arrays.asList("tag1", "tag2");
        Post shortBodyPost2 = new Post("Another Valid Title", "Another short body.", tags2, "Difficult", "Highly Needed");

        assertFalse(shortBodyPost1.addPost());
        assertFalse(shortBodyPost2.addPost());
    }

    @Test
    public void testAddPostFailureDueToInvalidTags() {
        List<String> invalidTags1 = Arrays.asList("Java", "Programming");
        Post invalidTagsPost1 = new Post("Valid Title", "This is a valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", invalidTags1, "Difficult", "Highly Needed");

        List<String> invalidTags2 = Arrays.asList("TAG1", "TAG2");
        Post invalidTagsPost2 = new Post("Another Valid Title", "This is another valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", invalidTags2, "Difficult", "Highly Needed");

        assertFalse(invalidTagsPost1.addPost());
        assertFalse(invalidTagsPost2.addPost());
    }

    @Test
    public void testAddPostFailureDueToExcessTagsForEasyPost() {
        List<String> tags1 = Arrays.asList("tag1", "tag2", "tag3", "tag4");
        Post easyPost1 = new Post("Easy Post Title", "This is a valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags1, "Easy", "Ordinary");

        List<String> tags2 = Arrays.asList("tag1", "tag2", "tag3", "tag4", "tag5");
        Post easyPost2 = new Post("Another Easy Post", "This is another valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags2, "Easy", "Ordinary");

        assertFalse(easyPost1.addPost());
        assertFalse(easyPost2.addPost());
    }

    @Test
    public void testAddPostFailureDueToInvalidUrgencyForEasyPost() {
        List<String> tags1 = Arrays.asList("tag1", "tag2", "tag3");
        Post easyPost1 = new Post("Easy Post Title", "This is a valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags1, "Easy", "Immediately Needed");

        List<String> tags2 = Arrays.asList("tag1", "tag2", "tag3");
        Post easyPost2 = new Post("Another Easy Post Title", "This is another valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags2, "Easy", "Highly Needed");

        assertFalse(easyPost1.addPost());
        assertFalse(easyPost2.addPost());
    }

    @Test
    public void testAddCommentSuccess() {
        assertTrue(post.addComment("This is a valid comment."));
        assertTrue(post.addComment("This is another valid comment."));
    }

    @Test
    public void testAddCommentFailureDueToShortComment() {
        assertFalse(post.addComment("Short."));
        assertFalse(post.addComment("Another."));
    }

    @Test
    public void testAddCommentFailureDueToFirstLetterNotCapitalized() {
        assertFalse(post.addComment("this is an invalid comment."));
        assertFalse(post.addComment("invalid comment again."));
    }

    @Test
    public void testAddCommentFailureDueToExcessWords() {
        assertFalse(post.addComment("This comment has way too many words to be considered valid."));
        assertFalse(post.addComment("This one also has too many words and should fail test case."));
    }

    @Test
    public void testAddCommentEdgeCase() {
        assertTrue(post.addComment("This comment has exactly ten words in it."));
        assertTrue(post.addComment("Nine words should also be valid, right?"));
    }

    @Test
    public void testAddCommentFailureDueToMaxCommentsReached() {
        List<String> tags = Arrays.asList("tag1", "tag2");
        Post easyPost = new Post("Easy Post Title", "This is a valid body with more than 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur.", tags, "Easy", "Ordinary");

        assertTrue(easyPost.addComment("This is comment one."));
        assertTrue(easyPost.addComment("This is comment two."));
        assertTrue(easyPost.addComment("This is comment three."));
        assertFalse(easyPost.addComment("This comment should fail."));
        assertFalse(easyPost.addComment("Another comment that should fail."));
    }
}
