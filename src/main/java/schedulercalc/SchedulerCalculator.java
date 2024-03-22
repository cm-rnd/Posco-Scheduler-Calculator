package schedulercalc;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class SchedulerCalculator {
    private static final int MINUTES_PER_HOUR = 60;
    protected LocalDateTime now = LocalDateTime.now();
    protected abstract void printResult();
    protected abstract long calc();

    protected int calcTotalMinutes(int hour, int minutes){
        return hour * MINUTES_PER_HOUR + minutes;
    }

}
