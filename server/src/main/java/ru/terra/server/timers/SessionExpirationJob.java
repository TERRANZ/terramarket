package ru.terra.server.timers;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import ru.terra.server.security.SessionsHolder;

/**
 * User: Vadim Korostelev
 * Date: 09.09.13
 * Time: 16:29
 */
public class SessionExpirationJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LoggerFactory.getLogger(this.getClass()).debug("Triggered removing expired sessions...");
        SessionsHolder.getInstance().checkExpirations();
    }
}
