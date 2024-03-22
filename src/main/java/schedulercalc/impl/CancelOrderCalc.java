package schedulercalc.impl;

import schedulercalc.SchedulerCalculator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 스케줄러 동작 시간 : 01:10
 */
public class CancelOrderCalc extends SchedulerCalculator {
    private static final int TARGET_HOUR = 1;
    private static final int TARGET_MINUTES = 10;

    @Override
    public void printResult() {
        System.out.println("CancelOrder 스케줄러의 등록 시간 : " + calc() + "분");
    }
    @Override
    public long calc() {
        int nowTotalMinutes = calcTotalMinutes(now.getHour(), now.getMinute());
        int targetTotalMinutes = calcTotalMinutes(TARGET_HOUR, TARGET_MINUTES);
        // 자정 ~ 01시 10분인 경우
        if(nowTotalMinutes <= targetTotalMinutes){
            return targetTotalMinutes - nowTotalMinutes;
        }
        return Duration.between(now, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(TARGET_HOUR, TARGET_MINUTES))).toMinutes();
    }

}
