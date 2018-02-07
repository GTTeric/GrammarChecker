import java.util.*;
import java.io.*;
public class Grammar {
	public static String userInput, userInNoPunc;
	public static int arraylength1, arraylength2;
	public Grammar() {
		this.userInput = "";
		this.arraylength1 = 0;
		this.arraylength2 = 0;
	}
	public void FirstChar(String firstWord, int length) {
		//-----Check for first character capital-----
		if (firstWord.equals("")){
			System.out.println("You entered 0 words which isn't valid.");
		
		}
		else if (firstWord.equals(" ")){
			System.out.println("The first character is just a space.");
		}
		else {
			char firstChar = firstWord.charAt(0);
			if (!Character.isUpperCase(firstChar)){
				System.out.println("You did not capitalize the first word of your sentence.");
			}
		}
	}
	public void LastChar(String lastWord) {
		//-----Check for last character ending punctuation-----
		if (!lastWord.endsWith("?") && !lastWord.endsWith("!") && !lastWord.endsWith(".")){
			System.out.println("You did not use proper punctuation at the end your sentence.");
		}
	}
	public void RunOn(int length) {
		// -----Check for run-on sentence-----
		if (length >= 35) {
			System.out.println("Please consider revising your sentence. At " + length + " words, it is far too long.");
		}
	}
	public void WeakVerb(String reallyVery, int length) {
		//-----Check for weak verbs very and really-----
		if (reallyVery.equalsIgnoreCase("very")) {
			System.out.println("You shouldn’t use ‘very’ because it is a weak verb.");
		}
		else if (reallyVery.equalsIgnoreCase("really")){
			System.out.println("You shouldn’t use ‘really’ because it is a weak verb.");
		}
	}
	public void CheckNums(String wordNum) {
		//-----Check for numeric 1-10-----
		if (wordNum.equalsIgnoreCase("0") || wordNum.equalsIgnoreCase("1") || wordNum.equalsIgnoreCase("2") || wordNum.equalsIgnoreCase("3") || wordNum.equalsIgnoreCase("4") || wordNum.equalsIgnoreCase("5") || wordNum.equalsIgnoreCase("6") || wordNum.equalsIgnoreCase("7") || wordNum.equalsIgnoreCase("8") || wordNum.equalsIgnoreCase("9")){				
			System.out.println("You should spell out all single digit (0-9) numbers.");
		}
	}
	public void CheckQuote(String quote, int quoteCount) {
    	if (quote.equalsIgnoreCase("\"")){				
			quoteCount++;
		}
    	if (quoteCount % 2 != 0){//It's odd, which means there's a missing quote
			System.out.println("You've missed a quotation mark in your sentence.");
		} //else its even, which is fine.
    }
	public void RepeatWord(Object[] userInArray) {
		
		for (int i = 1; i < userInArray.length; i++){ //start from 1 cuz we can't check the first word
			if (( (String) userInArray[i]).equalsIgnoreCase((String) userInArray[i - 1])) {
				System.out.println("You used a word twice in a row somewhere. That can't be right, can it?");
			}
		}
	}
	public void AvsAN(String aAn, Object[] userInArray, int i){
		if (aAn.equalsIgnoreCase("a")) { //b,c,d,f,g,h,j,k,l,m,n,p,q,r,s,t,v,w,x,y,z (consonant)
			String aAfter = (String) (userInArray[i + 1]);
			String a2 = aAfter.substring(0, 1);
			if (a2.equalsIgnoreCase("a") || a2.equalsIgnoreCase("e") || a2.equalsIgnoreCase("i") || a2.equalsIgnoreCase("o") || a2.equalsIgnoreCase("u")){
				System.out.println("You used 'a' when you should've used 'an'.");
			}
		}
		else if (aAn.equalsIgnoreCase("an")){ //a,e,i,o,u (vowel)
			String anAfter = (String) (userInArray[i + 1]);
			String an2 = anAfter.substring(0,1);
			if (!(an2.equalsIgnoreCase("a") || an2.equalsIgnoreCase("e") || an2.equalsIgnoreCase("i") || an2.equalsIgnoreCase("o") || an2.equalsIgnoreCase("u"))){
				System.out.println("You used 'an' when you should've used 'a'.");
			}
		}
	}
	public void CheckCompound(Object[] userInArray) {
		
		if (userInArray.length >= 15){
			int notAOBcount = 0;
			for (int i = 0; i < userInArray.length; i++){
				String aob = (String) userInArray[i];
				if (!(aob.equalsIgnoreCase("and") || aob.equalsIgnoreCase("or") || aob.equalsIgnoreCase("but"))){
					notAOBcount++;
				}
			}
			if (notAOBcount == userInArray.length){
				System.out.println("At " + userInArray.length + " words, your sentence should include 'and', 'or', or 'but'.");
			}
		}
	}
	public void NounVerb(Object[] userInArray, String dirName) throws IOException {
		//check for nouns and verbs
		int nounPlace = 0, verbPlace = 0;
		boolean nounFound = false, verbFound = false;
		nounLoop:
		for (int i = 0; i < userInArray.length; i++){
			String currentNoun = (String) userInArray[i];
			
			File nounFile = new File(dirName + "nouns.txt");//Assigns noun file
			BufferedReader in = new BufferedReader(new FileReader(nounFile));
			String line;
			while ((line = in.readLine()) != null){
				if (line.equalsIgnoreCase(currentNoun)){
			        nounFound = true;
			        nounPlace = (i);
			        break nounLoop; //break out of for loop
			    }
			}
			in.close();
		}
		verbLoop:
		for (int i = 0; i < userInArray.length; i++){
			String currentVerb = (String) userInArray[i];
			File verbFile = new File(dirName + "verbs.txt");//Assigns verb file
			BufferedReader in = new BufferedReader(new FileReader(verbFile));
			String line;
			while ((line = in.readLine()) != null){
			    if (line.equalsIgnoreCase(currentVerb)){
			        verbFound = true;
			        verbPlace = (i);
			        break verbLoop; //break out of for loop
			    }
			}
			in.close();
		}
		if ((nounFound) && (verbFound)){ //if both were found:
			if (nounPlace > verbPlace){//check if noun didn't come first
				System.out.println("You used a verb before a noun. Try the reverse.");
			}
		}
		else if (nounFound == false){//otherwise one is missing
		    System.out.println("You're missing a noun. You need one of those.");
		    if (verbFound == false){
			    System.out.println("You're also missing a verb. You need one of those too.");
			}
		}
		else if (verbFound == false){//otherwise one is missing
		    System.out.println("You're missing a verb. You need one of those.");
		}
	}
	static Grammar rules = new Grammar();
	public static void main(String[] args) throws IOException {
		//-----Get User Input-----
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a compound sentence that is joined by 'and/or/but'. Less than 15 words is not considered a compound sentence.");
		System.out.println("ALL nouns and ALL verbs are valid but must be used with a verb following a noun.");
		System.out.println("Capitalize the first character and end your sentence with valid punctuation.");
		System.out.println("Don't use the same word twice in a row and keep your sentence below 35 words.");
		System.out.println("Spell out single digit numbers (0-9) and don't use weak verbs like 'very' or 'really'.");
		System.out.println("Proper use of 'a' & 'an' is essential. Be sure that your quotation marks come in pairs.");
		System.out.println("Type 'quit' to exit.");
		userInput = sc.nextLine();
		userInNoPunc = userInput.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
		//-----Code to continually put user input into arrays-----
		while (!userInput.equalsIgnoreCase("quit")){
			String[] userInArray = userInNoPunc.split(" "); //each word WITHOUT PUNCTUATION is an element
			String[] userInArray2 = userInput.split(""); //each character is an element	
			String[] userInArray3 = userInput.split(" "); //each word is an element	
			arraylength1 = userInArray.length;
			arraylength2 = userInArray2.length;

			//-----Print Array-----
			/*for (int i = 0; i < userInArray.length; i++){
				System.out.print(userInArray[i] + "\n");
			}*/
			//-----Read from text file and make sure any noun is followed by any verb-----
			//Below gives the present working directory where the properties were initialized
			//Reference: https://stackoverflow.com/questions/3153337/get-current-working-directory-in-java/3153440
			final String dir = System.getProperty("user.dir"); 
			String dirName = dir + "/GrammarFiles/"; 
			File dirObj = new File(dirName);
			if (!dirObj.exists()){//Creates directory if there isn't one
				dirObj.mkdir();
			}
			rules.NounVerb(userInArray, dirName);
			//-----Check for compound sentence joined by and/or/but-----
			rules.CheckCompound(userInArray);
			//-----Check for first character capital-----
			//-----Check for last character ending punctuation-----	
			if (!(userInArray.length == 0)){
				String firstWord = userInArray[0];	
				rules.FirstChar(firstWord, arraylength1);
				
				String lastWord = userInArray3[userInArray3.length - 1];
				rules.LastChar(lastWord);
			}
			else {
				System.out.println("You entered " + userInArray.length + " words, which isn't valid.");
			}
					
			//-----Check for weak verbs very and really-----
			for (int i = 0; i < userInArray.length; i++){ //start from 1 cuz we already assigned 0
				String reallyVery = userInArray[i];
				rules.WeakVerb(reallyVery,arraylength1);
			}
			//-----Check for run-on sentence-----
			rules.RunOn(arraylength1);		
			//-----Check for repeated word-----		
			rules.RepeatWord(userInArray3);
			//-----Check for two quotation marks-----
			int quoteCount = 0;
			for (int i = 0; i < userInArray2.length; i++){
				String quote = userInArray2[i];
			rules.CheckQuote(quote, quoteCount);
			}				
			//-----Check for numeric 1-10-----
			for (int i = 0; i < userInArray.length; i++){
				String wordNum = userInArray[i];
				rules.CheckNums(wordNum);
			}
			//-----Check for a vs an-----
			for (int i = 0; i < userInArray.length; i++){
				String aAn = userInArray[i];
				rules.AvsAN(aAn, userInArray, i);
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("Please enter another compound sentence. Type 'quit' to exit.");
			userInput = sc.nextLine();		
			userInNoPunc = userInput.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
		}
		sc.close();
	}
}