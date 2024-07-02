
#include <deque>
#include <string>
#include <string_view>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;
    static const char CHAR_MARK = '*';

public:
    string clearStars(string& input) const {
        vector<deque<int>> indexesPerLetter(ALPHABET_SIZE);
        for (int i = 0; i < input.size(); ++i) {
            if (input[i] == CHAR_MARK) {
                markLexicographicallySmallestLetterForRemovalInInput(indexesPerLetter, input);
            }
            else {
                indexesPerLetter[input[i] - 'a'].push_back(i);
            }
        }
        return createLexicographicallyMinimumStringAfterRemovingStars(input);
    }

private:
    void markLexicographicallySmallestLetterForRemovalInInput(vector<deque<int>>& indexesPerLetter, string& input) const {
        for (int letter = 0; letter < ALPHABET_SIZE; ++letter) {
            if (!indexesPerLetter[letter].empty()) {
                int index = indexesPerLetter[letter].back();
                indexesPerLetter[letter].pop_back();
                input[index] = CHAR_MARK;
                return;
            }
        }
    }

    string createLexicographicallyMinimumStringAfterRemovingStars(string_view input) const {
        string lexicographicallyMinimumString;
        for (const auto& current : input) {
            if (current != CHAR_MARK) {
                lexicographicallyMinimumString.push_back(current);
            }
        }
        return lexicographicallyMinimumString;
    }
};
