package net.esliceu.movie.Utils;

import net.esliceu.movie.Model.Mappable;
import net.esliceu.movie.Model.MappableContainer;

import java.util.ArrayList;
import java.util.List;

public class JQueryUtil {
    public static List<JQueryElement> map(List<Mappable> values){
        List<JQueryElement> result = new ArrayList<>();
        for(Mappable value : values){
            result.add(new JQueryElement(value.getId(), value.getName()));
        }
        return result;
    }
    public static List<JQueryElement> mapContainer(List<MappableContainer> values, String name){
        List<Mappable> result = new ArrayList<>();
        for(MappableContainer value : values){
            result.add(value.getMappable(name));
        }
        return map(result);
    }
}
