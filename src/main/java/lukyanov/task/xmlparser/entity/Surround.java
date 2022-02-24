package lukyanov.task.xmlparser.entity;

public enum Surround {
    FIFTH_GEN("5.1"),
    SEVENTH_GEN("7.1"),
    NINTH_GEN("9.1");

    public final String generation;

    Surround(String generation) {
        this.generation = generation;
    }

    public String getGeneration() {
        return generation;
    }
}
