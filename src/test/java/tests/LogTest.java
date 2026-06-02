package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class LogTest {

    @Test
    public void checkLogs() {
        log.fatal("Fatal error");
        log.error("Error");
        log.warn("Warning");
        log.info("Info");
        log.debug("Debug");
        log.trace("Trace");
    }
}
