package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> children) {
        super(tagName, attributes);
        this.body = body;
        this.children = children;
    }

    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("<").append(tagName);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sBuilder.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sBuilder.append(">");

        sBuilder.append(body);

        for (Tag child : children) {
            sBuilder.append(child.toString());
        }

        sBuilder.append("</").append(tagName).append(">");
        return sBuilder.toString();
    }
}
// END
