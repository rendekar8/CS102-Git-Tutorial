// This class is used for encrypting or decrypting strings using character mapping
public class Cipher   
{
    // Strings for keeping the alphabets, one for the original letters and the other for the encrypted ones
    // encryption involves mapping from original to cipher, for each letter we locate the character in the
    // original string and replace it with the cipher alphabet letter at the same position
    public static final String ORIGINAL_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CIPHER_ALPHABET = "dfxyhrklvwuasgimnojpqetbcz";

    public String encrypt(String inputString) {
        
        // output string will be collected in this variable, one char at a time
        String outputString = "";
        
        // for all chars in the input string
        for (int i = 0; i < inputString.length(); i++)   
        {
            // append the encrypted version of the char to the output string
            outputString += replaceChar(inputString.charAt(i), true);
        }

        return outputString;
    }

    public String decrypt(String inputString) {
        
        // output string will be collected in this variable, one char at a time
        String outputString = "";
        
        // for all chars in the input string
        for (int i = 0; i < inputString.length(); i++) 
        {
            // append the encrypted version of the char to the output string
            outputString += replaceChar(inputString.charAt(i), false);
        }

        return outputString;
    }

    // replaces the given input char based on the given isEncrypt variable
    // if isEncrypt == true -> original to encrypted
    // if isEncrypt == false -> encrypted to original
    // works only when the input char is included in our alphabet variables
    // should not replace symbols or upper case letters, return input char in those cases
    private char replaceChar(char inputChar, boolean isEncrypt) {
        
        if(isEncrypt) {
            for (int i = 0; i < ORIGINAL_ALPHABET.length(); i++)   
            {
                if(ORIGINAL_ALPHABET.charAt(i) == inputChar) {
                    return CIPHER_ALPHABET.charAt(i);
                }
            }
        }
        else {
            for (int i = 0; i < CIPHER_ALPHABET.length(); i++)   
            {
                if(CIPHER_ALPHABET.charAt(i) == inputChar) {
                    return ORIGINAL_ALPHABET.charAt(i);
                }
            }
        }
        
        // if we did not find it in the alphabet, then return the original char
        return inputChar;
    }
}   