package net.esliceu.movie.Utils;

public class ViewTableList {
    String name;
    String type;
    Object value;
    Boolean changeable;
    String url;

    public ViewTableList(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.changeable = false;
        this.url = "";
    }

    public ViewTableList(String name, String type, Object value, Boolean changeable, String url) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.changeable = changeable;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getChangeable() {
        return changeable;
    }

    public void setChangeable(Boolean changeable) {
        this.changeable = changeable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
