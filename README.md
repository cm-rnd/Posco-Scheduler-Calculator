# Posco-Scheduler-Calculator
포스코 도시락 애플리케이션 배포 시, 스케줄러 등록시 입력하는 delay 값을 자동으로 계산해주는 애플리케이션입니다

## Run

```
./gradlew clean shadowJar
java -jar build/libs/schedulerTimeCalculator-all.jar
```

## How to Contribute
- 추후 스케줄러가 추가될 시, SchedulerCalculator 인터페이스를 꼭 상속받아 구현 해주세요
- 구현 클래스는 반드시 schedulercalc.impl 디렉토리 내에 위치시켜주세요. (리플렉션을 사용해서 해당 클래스가 인식되어 printResult 메서드를 호출합니다)
