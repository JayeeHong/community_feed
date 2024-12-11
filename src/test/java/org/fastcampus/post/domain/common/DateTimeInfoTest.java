package org.fastcampus.post.domain.common;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class DateTimeInfoTest {

    @Test
    void givenCreated_whenUpdated_thenTimeAndStateAreUpdated() throws InterruptedException {
        // given
        DatetimeInfo datetimeInfo = new DatetimeInfo();
        LocalDateTime localDateTime = datetimeInfo.getDateTime();

        // when
        Thread.sleep(1L);
        datetimeInfo.updateEditDatetime();

        // then
        assertTrue(datetimeInfo.isEdited());
        assertNotEquals(localDateTime, datetimeInfo.getDateTime());
    }

}
