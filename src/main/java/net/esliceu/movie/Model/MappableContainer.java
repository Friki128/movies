package net.esliceu.movie.Model;

public interface MappableContainer {
    Mappable getMappable(String name);
    String print(String exclude);
}
