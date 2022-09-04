package enums;

public enum Measure {
    G("грамм"), MG("милиграмм"), KG("килограмм"), ML("милилитр"), L("литр");

    final String name;
    Measure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
