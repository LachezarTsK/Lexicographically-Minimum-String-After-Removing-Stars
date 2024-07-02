
class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
        const val CHAR_MARK = '*'
    }

    fun clearStars(s: String): String {
        val indexesPerLetter = ArrayList<ArrayDeque<Int>>(ALPHABET_SIZE)
        for (letter in 0..<ALPHABET_SIZE) {
            indexesPerLetter.add(ArrayDeque<Int>())
        }

        val input = s.toCharArray()
        for (i in input.indices) {
            if (input[i] == CHAR_MARK) {
                markLexicographicallySmallestLetterForRemovalInInput(indexesPerLetter, input);
            } else {
                indexesPerLetter[input[i] - 'a'].addLast(i);
            }
        }

        return createLexicographicallyMinimumStringAfterRemovingStars(input);
    }

    private fun markLexicographicallySmallestLetterForRemovalInInput(indexesPerLetter: ArrayList<ArrayDeque<Int>>, input: CharArray) {
        for (letter in 0..<ALPHABET_SIZE) {
            if (!indexesPerLetter[letter].isEmpty()) {
                val index = indexesPerLetter[letter].removeLast()
                input[index] = CHAR_MARK;
                return;
            }
        }
    }

    private fun createLexicographicallyMinimumStringAfterRemovingStars(input: CharArray): String {
        val lexicographicallyMinimumString = StringBuilder()
        for (i in input.indices) {
            if (input[i] != CHAR_MARK) {
                lexicographicallyMinimumString.append(input[i])
            }
        }
        return lexicographicallyMinimumString.toString()
    }
}
