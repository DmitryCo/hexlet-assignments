package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final String originalString;

    public ReversedSequence(String originalString) {
        this.originalString = originalString;
    }

    @Override
    public int length() {
        return originalString.length();
    }

    @Override
    public char charAt(int index) {
        return originalString.charAt(originalString.length() - index - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new ReversedSequence(originalString.substring(originalString.length() - end,
		originalString.length() - start));
    }

    @Override
    public String toString() {
        return new StringBuilder(originalString).reverse().toString();
    }
}
// END
