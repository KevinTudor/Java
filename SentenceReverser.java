import java.util.Scanner;

//Test string: Hello Kevin is Joe there?

class SentenceReverser {

	public static void main(String[] args){

		Scanner sentenceScanner = new Scanner(System.in);  				  // Create a Scanner object
		System.out.println("Enter Sentence");

		String originalSentence = sentenceScanner.nextLine();             // Read user input
		sentenceScanner.close(); 										  // close scanner to prevent memory leak
		System.out.println("Original Sentence is: " + originalSentence + "\n");  // Output user input

		String[] sentenceList = originalSentence.split(" ");
		
		String reverseSentence = "";
		char finalPunctuation = ' ';
		char[] punctuationList = {'.', '?', '!'};
		Boolean hasPuncuation = false;

		for (char punctuation : punctuationList){
			if (originalSentence.charAt(originalSentence.length()-1) == punctuation){
				finalPunctuation = originalSentence.charAt(originalSentence.length()-1);
				hasPuncuation = true;
			}
		}

		for (int i = sentenceList.length - 1; i >= 0; i-- ){
			if (i == sentenceList.length - 1){
				reverseSentence += sentenceList[i].substring(0, 1).toUpperCase();
				if (hasPuncuation){
					reverseSentence += sentenceList[i].substring(1, sentenceList[i].length()-1);
				}
				else{
					reverseSentence += sentenceList[i].substring(1, sentenceList[i].length());
				}
			}
			else{
				reverseSentence += " ";
				reverseSentence += sentenceList[i];
			} 			  				
		}

		if(hasPuncuation = true){
			System.out.println(reverseSentence + finalPunctuation);
		}
		else{
			System.out.println(reverseSentence);
		}

	}
}