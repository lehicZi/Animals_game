package constant;

public class Rarete {
    public static final int VERT = 0;
    public static final int JAUNE = 1;
    public static final int ORANGE = 2;
    public static final int ROUGE = 3;

    private Rarete() {
    }

    public static String nameRarete(int rarete){
        return switch (rarete) {
            case VERT -> "vert";
            case JAUNE -> "jaune";
            case ORANGE -> "orange";
            case ROUGE -> "rouge";
            default -> throw new IllegalStateException();
        };
    }
}
