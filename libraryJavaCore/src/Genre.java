public enum Genre {
    FANTASY("Фантастика"),
    SCIENCE_FICTION("Научная Фантастика"),
    DETECTIVE("Детектив"),
    CLASSIC("Классика"),
    ADVENTURE("Приключение"),
    HORROR("Хоррор");

    private final String displayName;

    Genre(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
