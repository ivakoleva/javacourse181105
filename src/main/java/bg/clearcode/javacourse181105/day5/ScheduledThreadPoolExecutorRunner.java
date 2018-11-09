package bg.clearcode.javacourse181105.day5;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
public class ScheduledThreadPoolExecutorRunner {
    public static void main(final String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        final LocalDateTime dateTimeOfStart = LocalDateTime.now();

        final ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(() -> {
            //if(Duration.between(LocalDateTime.now(), dateTimeOfStart).getSeconds() < 10) {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Start...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ConcurrencyRunner.printThreadMessageToOutput.accept("End...");
            //}
        }, 0, 1, TimeUnit.SECONDS);

        // TODO: async
        try {
            scheduledFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        while (Duration.between(LocalDateTime.now(), dateTimeOfStart).getSeconds() < 10) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // TODO: interrupt scheduled future

        ConcurrencyRunner.printThreadMessageToOutput.accept("Exiting...");
    }
}
