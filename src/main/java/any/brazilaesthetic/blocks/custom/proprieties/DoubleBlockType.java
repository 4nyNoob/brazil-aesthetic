package any.brazilaesthetic.blocks.custom.proprieties;

import net.minecraft.util.StringIdentifiable;

public enum DoubleBlockType implements StringIdentifiable {
    SINGLE("single"),
    LEFT("left"),
    RIGHT("right");

    private final String name;

    private DoubleBlockType(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }

    public DoubleBlockType getOpposite() {
        return switch (this) {
            case SINGLE -> SINGLE;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
        };
    }
}
