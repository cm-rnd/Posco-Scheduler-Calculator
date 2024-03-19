package schedulercalc;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================================================================");
        printSchedulerTime();
        System.out.println("================================================================================");
    }

    public static void printSchedulerTime() {
        try {
            Reflections reflections = new Reflections("schedulercalc.impl");
            Set<Class<? extends SchedulerCalculator>> schedulerCalculatorClasses = reflections.getSubTypesOf(SchedulerCalculator.class);
            for (Class<? extends SchedulerCalculator> clazz : schedulerCalculatorClasses) {
                SchedulerCalculator schedulerCalculator = clazz.getDeclaredConstructor().newInstance();
                schedulerCalculator.printResult();
            }
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
