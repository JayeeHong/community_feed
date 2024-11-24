package org.fastcampus.user.domain;

import java.util.Objects;
import org.fastcampus.common.domain.PositiveIntegerCounter;

public class User {

    private final Long id;
    private final UserInfo userInfo;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo userInfo) {
        if (userInfo == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.userInfo = userInfo;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCount = new PositiveIntegerCounter();
    }

    public void follow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCount.increase();
        targetUser.increaseFollowerCount();
    }

    public void unfollow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCount.decrease();
        targetUser.decreaseFollowerCount();
    }

    private void increaseFollowerCount() {
        followerCount.increase();
    }

    private void decreaseFollowerCount() {
        followerCount.decrease();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public int followerCount() {
        return followerCount.getCount();
    }

    public int followingCount() {
        return followingCount.getCount();
    }
}
