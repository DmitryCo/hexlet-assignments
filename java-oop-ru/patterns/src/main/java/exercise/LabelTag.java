package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String text;
    private TagInterface childTag;

    public LabelTag(String text, TagInterface childTag) {
        this.text = text;
        this.childTag = childTag;
    }

    @Override
    public String render() {
        return "<label>" + text + childTag.render() + "</label>";
    }

    public static void main(String[] args) {
        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", inputTag);
        System.out.println(labelTag.render());
    }
}
// END
