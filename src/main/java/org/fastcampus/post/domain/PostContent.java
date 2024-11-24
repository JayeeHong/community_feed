package org.fastcampus.post.domain;

import org.fastcampus.post.domain.content.Content;

public class PostContent extends Content {

    private static final int MIN_POST_LENGTH = 5;
    private static final int MAX_POST_LENGTH = 500;

    private PostContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() > MAX_POST_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() < MIN_POST_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
