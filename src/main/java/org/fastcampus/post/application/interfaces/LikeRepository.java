package org.fastcampus.post.application.interfaces;

import org.fastcampus.post.domain.Post;
import org.fastcampus.user.domain.User;

public interface LikeRepository {

    boolean checkLike(Post post, User user);

    void like(Post post, User user);

    void unlike(Post post, User user);
}
