
/**
 * @param {string} s
 * @return {string}
 */
var clearStars = function (s) {
    this.ALPHABET_SIZE = 26;
    this.CHAR_MARK = '*';
    const indexesPerLetter = Array.from(new Array(this.ALPHABET_SIZE), () => new Array());

    const input = s.split('');
    for (let i = 0; i < input.length; ++i) {
        if (input[i] === this.CHAR_MARK) {
            markLexicographicallySmallestLetterForRemovalInInput(indexesPerLetter, input);
        } else {
            indexesPerLetter[input[i].codePointAt(0) - 'a'.codePointAt(0)].push(i);
        }
    }

    return createLexicographicallyMinimumStringAfterRemovingStars(input);
};

/**
 * @param {number[][]} indexesPerLetter
 * @param {string[]} input 
 * @return {void}
 */
function markLexicographicallySmallestLetterForRemovalInInput(indexesPerLetter, input) {
    for (let letter = 0; letter < this.ALPHABET_SIZE; ++letter) {
        if (indexesPerLetter[letter].length > 0) {
            const index = indexesPerLetter[letter].pop();
            input[index] = this.CHAR_MARK;
            return;
        }
    }
}

/**
 * @param {string[]} input 
 * @return {string}
 */
function createLexicographicallyMinimumStringAfterRemovingStars(input) {
    const lexicographicallyMinimumString = new Array();
    for (let i = 0; i < input.length; ++i) {
        if (input[i] !== this.CHAR_MARK) {
            lexicographicallyMinimumString.push(input[i]);
        }
    }
    return lexicographicallyMinimumString.join('');
}
