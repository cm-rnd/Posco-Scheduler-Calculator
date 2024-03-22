package schedulercalc.impl;

import schedulercalc.SchedulerCalculator;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

import static java.time.DayOfWeek.*;
/**
 * 스케줄러 동작 시간 : 01:30
 */

public class SnackAutoOrderingCalc extends SchedulerCalculator {
    private static final int TARGET_HOUR = 1;
    private static final int TARGET_MINUTES = 30;

    @Override
    public void printResult() {
        System.out.println("SnackAutoOrdering 스케줄러의 등록 시간 : " + calc() + "분");
    }
    @Override
    public long calc() {
        int nowTotalMinutes = calcTotalMinutes(now.getHour(), now.getMinute());
        int targetTotalMinutes = calcTotalMinutes(TARGET_HOUR, TARGET_MINUTES);
        // 월요일 00시 ~ 01시 30분 사이인 경우
        if(now.getDayOfWeek().equals(MONDAY) && nowTotalMinutes <= targetTotalMinutes){
            return targetTotalMinutes - nowTotalMinutes;
        }
        // 그 외의 시
        LocalDate targetLocalDate = now.with(TemporalAdjusters.next(MONDAY)).toLocalDate();
        return Duration.between(now, LocalDateTime.of(targetLocalDate, LocalTime.of(TARGET_HOUR, TARGET_MINUTES))).toMinutes();
    }
}
