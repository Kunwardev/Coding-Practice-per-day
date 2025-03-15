package March;

public class ValidWordAbbreviation {
    // Class implementation goes here

    public boolean validabbreviation(String word, String abbr){
        int i = 0, j = 0;
        int wordLength = word.length(), abbrLength = abbr.length();
        while(i < wordLength && j < abbrLength){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(abbr.charAt(j) < '0' || abbr.charAt(j) > '9')
                return false;
            int start = j;
            while(j < abbrLength && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                j++;
            }
            i+= Integer.valueOf(abbr.substring(start, j));
        }
        return i == wordLength && j == abbrLength;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation validator = new ValidWordAbbreviation();

        // Test case 1: Valid abbreviation
        String word1 = "internationalization";
        String abbr1 = "i12iz4n";
        System.out.println(validator.validabbreviation(word1, abbr1)); // Expected: true

        // Test case 2: Invalid abbreviation
        String word2 = "apple";
        String abbr2 = "a2e";
        System.out.println(validator.validabbreviation(word2, abbr2)); // Expected: false

        // Test case 3: Valid abbreviation with leading zeros
        String word3 = "substitution";
        String abbr3 = "s10n";
        System.out.println(validator.validabbreviation(word3, abbr3)); // Expected: true

        // Test case 4: Invalid abbreviation with non-numeric characters
        String word4 = "substitution";
        String abbr4 = "s010n";
        System.out.println(validator.validabbreviation(word4, abbr4)); // Expected: false

        // Test case 5: Valid abbreviation with single character
        String word5 = "a";
        String abbr5 = "1";
        System.out.println(validator.validabbreviation(word5, abbr5)); // Expected: true

        // Test case 6: Invalid abbreviation with incorrect length
        String word6 = "word";
        String abbr6 = "w2";
        System.out.println(validator.validabbreviation(word6, abbr6)); // Expected: false
    }
}