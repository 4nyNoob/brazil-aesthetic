package any.brazilaesthetic.blocks.custom.proprieties;

import net.minecraft.util.StringIdentifiable;

public enum TableColor implements StringIdentifiable {
    UNCOLORED("uncolored"),
    WHITE("white"),
    LIGHT_GRAY("light_gray"),
    GRAY("gray"),
    BLACK("black"),
    BROWN("brown"),
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    LIME("lime"),
    GREEN("green"),
    CYAN("cyan"),
    LIGHT_BLUE("light_blue"),
    BLUE("blue"),
    PURPLE("purple"),
    MAGENTA("magenta"),
    PINK("pink");


    private final String name;

    private TableColor(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }

}
