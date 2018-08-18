package lesson15;

public enum Details {

    HEAD("Голова"),
    BODY("Тeло"),
    LEFT_HAND("Левая рука"),
    RIGHT_HAND("Правая рука"),
    LEFT_LEG("Левая нога"),
    RIGHT_LEG("Правая нога"),
    CPU("Процессор"),
    RAM("ОЗУ"),
    HDD("Жесткий диск");

    private String description;

    private Details(String description) {
        this.description = description;
    }

    public static Details getRandomDetail() {
        Details[] detail = Details.values();
        return detail[Util.getRandom(0, detail.length - 1)];
    }

    public String getDescription() {
        return description;
    }
}