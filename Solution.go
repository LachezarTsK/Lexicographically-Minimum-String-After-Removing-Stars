
package main

import (
    "fmt"
    "strings"
)

const ALPHABET_SIZE = 26
const CHAR_MARK = '*'

func clearStars(s string) string {
    indexesPerLetter := make([][]int, ALPHABET_SIZE)
    for letter := 0; letter < ALPHABET_SIZE; letter++ {
        indexesPerLetter[letter] = []int{}
    }

    input := []byte(s)
    for i := range input {
        if input[i] == CHAR_MARK {
            markLexicographicallySmallestLetterForRemovalInInput(indexesPerLetter, input)
        } else {
            indexesPerLetter[input[i]-'a'] = append(indexesPerLetter[input[i]-'a'], i)
        }
    }

    return createLexicographicallyMinimumStringAfterRemovingStars(input)
}

func markLexicographicallySmallestLetterForRemovalInInput(indexesPerLetter [][]int, input []byte) {
    for letter := 0; letter < ALPHABET_SIZE; letter++ {
        if len(indexesPerLetter[letter]) > 0 {
            index := indexesPerLetter[letter][len(indexesPerLetter[letter])-1]
            indexesPerLetter[letter] = indexesPerLetter[letter][:len(indexesPerLetter[letter])-1]
            input[index] = CHAR_MARK
            return
        }
    }
}

func createLexicographicallyMinimumStringAfterRemovingStars(input []byte) string {
    lexicographicallyMinimumString := strings.Builder{}
    for i := range input {
        if input[i] != CHAR_MARK {
            lexicographicallyMinimumString.WriteByte(input[i])
        }
    }
    return lexicographicallyMinimumString.String()
}
