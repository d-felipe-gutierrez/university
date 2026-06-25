package util;

public abstract class MenuItem implements MenuCall {
    private String key, text;

    public MenuItem(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }
}
