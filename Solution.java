
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private static final int ALPHABET_SIZE = 26;
    private static final char CHAR_MARK = '*';

    public String clearStars(String s) {
        Deque<Integer>[] indexesPerLetter = new ArrayDeque[ALPHABET_SIZE];
        for (int letter = 0; letter < ALPHABET_SIZE; ++letter) {
            indexesPerLetter[letter] = new ArrayDeque<>();
        }

        char[] input = s.toCharArray();
        for (int i = 0; i < input.length; ++i) {
            if (input[i] == CHAR_MARK) {
                markLexicographicallySmallestLetterForRemovalInInput(indexesPerLetter, input);
            } else {
                indexesPerLetter[input[i] - 'a'].addLast(i);
            }
        }

        return createLexicographicallyMinimumStringAfterRemovingStars(input);
    }

    private void markLexicographicallySmallestLetterForRemovalInInput(Deque<Integer>[] indexesPerLetter, char[] input) {
        for (int letter = 0; letter < ALPHABET_SIZE; ++letter) {
            if (!indexesPerLetter[letter].isEmpty()) {
                int index = indexesPerLetter[letter].pollLast();
                input[index] = CHAR_MARK;
                return;
            }
        }
    }

    private String createLexicographicallyMinimumStringAfterRemovingStars(char[] input) {
        StringBuilder lexicographicallyMinimumString = new StringBuilder();
        for (int i = 0; i < input.length; ++i) {
            if (input[i] != CHAR_MARK) {
                lexicographicallyMinimumString.append(input[i]);
            }
        }
        return lexicographicallyMinimumString.toString();
    }
}
