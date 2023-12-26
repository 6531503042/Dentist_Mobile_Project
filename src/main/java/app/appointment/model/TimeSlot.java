package app.appointment.model;

public enum TimeSlot {
    NINE_TO_TEN("09:00", "10:00"),
    TEN_TO_ELEVEN("10:00", "11:00"),
    ELEVEN_TO_TWELVE("11:00", "12:00"),
    TWELVE_TO_ONE("12:00", "13:00"),
    ONE_TO_TWO("13:00", "14:00"),
    TWO_TO_THREE("14:00", "15:00"),
    THREE_TO_FOUR("15:00", "16:00"),
    FOUR_TO_FIVE("16:00", "17:00"),
    FIVE_TO_SIX("17:00", "18:00");

    private final String startTime;
    private final String endTime;

    TimeSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
