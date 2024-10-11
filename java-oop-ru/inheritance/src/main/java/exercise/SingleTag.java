package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("<").append(tagName);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sBuilder.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sBuilder.append(">");
        return sBuilder.toString();
    }
}
// END
