package exercise;

import java.util.Map;


// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> attributes){
        super(tagName, attributes);
    }
    @Override
    public String toString(){
        return String.format("<%s%s>",
                tagName,
                formatAttributes().isEmpty() ? "" : " " + formatAttributes());
    }
}
// END
