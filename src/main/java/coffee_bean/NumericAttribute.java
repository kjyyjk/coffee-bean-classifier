package coffee_bean;

public enum NumericAttribute {
    AROMA("Aroma(향)", 0.0, 10.0, "약함", "강함"),
    FLAVOR("Flavor(풍미)", 0.0, 10.0, "단조로움", "화려함"),
    AFTERTASTE("Aftertaste(뒷맛)", 0.0, 10.0, "깔끔함", "진함"),
    ACIDITY("Acidity(산도)", 0.0, 10.0, "시지 않음", "심"),
    BODY("Body(바디감)", 0.0, 10.0, "가벼움", "무거움"),
    BALANCE("Balance(균형)", 0.0, 10.0, "편중됨", "균형있음"),
    SWEETNESS("Sweetness(달기)", 0.0, 10.0, "달지않음", "달음");

    private final String name;
    private final double minValue;
    private final double maxValue;
    private final String minDescription;
    private final String maxDescription;

    NumericAttribute(String name, double minValue, double maxValue, String minDescription, String maxDescription) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.minDescription = minDescription;
        this.maxDescription = maxDescription;
    }

    public String getName() {
        return name;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public String getMinDescription() {
        return minDescription;
    }

    public String getMaxDescription() {
        return maxDescription;
    }
}
