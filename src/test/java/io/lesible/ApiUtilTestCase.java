package io.lesible;

import io.lesible.util.UniqueIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <p> @date: 2021-04-20 19:07</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class ApiUtilTestCase {

    @Test
    public void uniqueIdTest() {
        String uniqueId = UniqueIdUtil.nextUniqueId();
        log.info("uniqueId: {}", uniqueId);
    }

}
