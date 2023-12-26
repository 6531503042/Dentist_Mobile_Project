package app.appointment.model;

public enum TimeSlot {
    SLOT_ONE("08:30", "09:00"),
    SLOT_TWO("09:30", "10:00"),
    SLOT_THREE("10:30", "11:00"),
    SLOT_FOUR("11:30", "12:00"),
    SLOT_FIVE("13:00", "13:30"),
    SLOT_SIX("13:30", "14:00"),
    SLOT_SEVEN("14:00", "14:30"),
    SLOT_EIGHT("14:30", "15:00"),
    SLOT_NINE("15:30", "16:00"),
    SLOT_TEN("16:00", "16:30"),
    SLOT_ELEVEN("16:30", "17:00"),
    SLOT_TWELVE("17:00", "17:30"),
    SLOT_THIRTEEN("17:30", "18:00");


    private final String startTime;
    private final String endTime;

    //Constructor
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
