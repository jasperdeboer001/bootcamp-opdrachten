package exercises;

public class EnumExample {

    public enum BootCampDay {
        DAYONE,
        DAYTWO;
    }

    public static String checkBootCampDaysInfo(BootCampDay bootCampDay) {
        switch(bootCampDay) {
            case DAYONE: default:
                return "Kerst was erg pittig";
            case DAYTWO:
                return "Hotelovernachting was erg pittig";
        }
    }
}
