
public class DateToTime {
    public static void main(String[] args) {
        DateTime time1 = new DateTime(80);
        time1.displayAll();

        DateTime time2 = new DateTime(1, 2, 3, 60);
        time2.displayAll();
    }

    static class DateTime {
        private int minutes;
        private int hours;
        private int days;
        private int weeks;
        private int totalMinutes;

        private static final int MINUTES_IN_HOUR = 60;
        private static final int HOURS_IN_DAY = 24;
        private static final int DAYS_IN_WEEK = 7;
        private static final int MINUTES_IN_DAY = HOURS_IN_DAY * MINUTES_IN_HOUR;
        private static final int MINUTES_IN_WEEK = DAYS_IN_WEEK * MINUTES_IN_DAY;

       
        public DateTime(int totalMinutes) {
            this.totalMinutes = totalMinutes;
            convertMinutesToTimePeriods();
        }

     
        public DateTime(int weeks, int days, int hours, int minutes) {
            this.weeks = weeks;
            this.days = days;
            this.hours = hours;
            this.minutes = minutes;
            this.totalMinutes = convertToTotalMinutes();
        }

     
        private void convertMinutesToTimePeriods() {
            int remaining = totalMinutes;

            weeks = remaining / MINUTES_IN_WEEK;
            remaining %= MINUTES_IN_WEEK;

            days = remaining / MINUTES_IN_DAY;
            remaining %= MINUTES_IN_DAY;

            hours = remaining / MINUTES_IN_HOUR;
            
            minutes = remaining % MINUTES_IN_HOUR;
        }

       
        private int convertToTotalMinutes() {
            return (weeks * MINUTES_IN_WEEK) +
                   (days * MINUTES_IN_DAY) +
                   (hours * MINUTES_IN_HOUR) +
                   minutes;
        }

   
        public void displayAll() {
            System.out.println(  getFullTimeDisplay());
            System.out.println("minutes - " + getTotalMinutes());
            System.out.printf(" hours - %.2f\n", getTotalHours());
            System.out.printf(" days -  %.2f\n", getTotalDays());
        }

        public String getFullTimeDisplay() {
            StringBuilder display = new StringBuilder();
            
            if (weeks > 0) addTimeComponent(display, weeks, "week");
            if (days > 0) addTimeComponent(display, days, "day");
            if (hours > 0) addTimeComponent(display, hours, "hour");
            if (minutes > 0) addTimeComponent(display, minutes, "minute");
            
            return display.length() > 0 ? display.toString().trim() : "0 minutes";
        }

        private void addTimeComponent(StringBuilder builder, int value, String unit) {
            builder.append(value)
                   .append(" ")
                   .append(unit)
                   .append(value > 1 ? "s " : " ");
        }

        private String padWithZero(int number) {
            return number < 10 ? "0" + number : String.valueOf(number);
        }

        public int getTotalMinutes() {
            return totalMinutes;
        }

        public double getTotalHours() {
            return totalMinutes / (double) MINUTES_IN_HOUR;
        }

        public double getTotalDays() {
            return totalMinutes / (double) MINUTES_IN_DAY;
        }
    }
}