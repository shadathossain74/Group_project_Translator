
    import java.util.HashMap;
import java.util.Scanner;
    public class TranslatorSystem {
        private static final HashMap<String, String> morseCodeMap = new HashMap<>();

        static {
            // Populate the Morse code dictionary
            morseCodeMap.put("A", ".-");
            morseCodeMap.put("B", "-...");
            morseCodeMap.put("C", "-.-.");
            morseCodeMap.put("D", "-..");
            morseCodeMap.put("E", ".");
            morseCodeMap.put("F", "..-.");
            morseCodeMap.put("G", "--.");
            morseCodeMap.put("H", "....");
            morseCodeMap.put("I", "..");
            morseCodeMap.put("J", ".---");
            morseCodeMap.put("K", "-.-");
            morseCodeMap.put("L", ".-..");
            morseCodeMap.put("M", "--");
            morseCodeMap.put("N", "-.");
            morseCodeMap.put("O", "---");
            morseCodeMap.put("P", ".--.");
            morseCodeMap.put("Q", "--.-");
            morseCodeMap.put("R", ".-.");
            morseCodeMap.put("S", "...");
            morseCodeMap.put("T", "-");
            morseCodeMap.put("U", "..-");
            morseCodeMap.put("V", "...-");
            morseCodeMap.put("W", ".--");
            morseCodeMap.put("X", "-..-");
            morseCodeMap.put("Y", "-.--");
            morseCodeMap.put("Z", "--..");
            morseCodeMap.put("0", "-----");
            morseCodeMap.put("1", ".----");
            morseCodeMap.put("2", "..---");
            morseCodeMap.put("3", "...--");
            morseCodeMap.put("4", "....-");
            morseCodeMap.put("5", ".....");
            morseCodeMap.put("6", "-....");
            morseCodeMap.put("7", "--...");
            morseCodeMap.put("8", "---..");
            morseCodeMap.put("9", "----.");
            morseCodeMap.put(" ", "/");
        }

        public static String textToMorseCode(String text) {
            text = text.toUpperCase();
            StringBuilder morseCode = new StringBuilder();

            for (char c : text.toCharArray()) {
                String morseChar = morseCodeMap.get(String.valueOf(c));
                if (morseChar != null) {
                    morseCode.append(morseChar).append(" ");
                }
            }

            return morseCode.toString().trim();
        }

        public static String morseCodeToText(String morseCode) {
            StringBuilder text = new StringBuilder();
            String[] words = morseCode.split("/");

            for (String word : words) {
                String[] letters = word.trim().split(" ");
                for (String letter : letters) {
                    String textChar = getKeyByValue(morseCodeMap, letter);
                    if (textChar != null) {
                        text.append(textChar);
                    }
                }
                text.append(" "); // Add space between words
            }

            return text.toString().trim();
        }

        public static String getKeyByValue(HashMap<String, String> map, String value) {
            for (String key : map.keySet()) {
                if (map.get(key).equals(value)) {
                    return key;
                }
            }
            return null; // Not found
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Morse Code Translator!\n");

            while (true) {
                System.out.println("Select an option:");
                System.out.println("1. Text to Morse Code");
                System.out.println("2. Morse Code to Text");
                System.out.println("3. Exit");

                int choice = -1;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    // Handle non-integer input
                }

                switch (choice) {
                    case 1:
                        System.out.print("\nEnter the text you want to convert to Morse code: ");
                        String inputText = scanner.nextLine();
                        String morseCode = textToMorseCode(inputText);
                        System.out.println("\nMorse Code: " + morseCode);
                        break;
                    case 2:
                        System.out.print("\nEnter the Morse code you want to convert to text: ");
                        String inputMorseCode = scanner.nextLine();
                        String text = morseCodeToText(inputMorseCode);
                        System.out.println("\nTranslated Text: " + text);
                        break;
                    case 3:
                        System.out.println("\nThank you for using the Morse Code Translator!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid choice. Please select a valid option.\n");
                }
            }
        }
    }

