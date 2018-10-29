# Grammar Checker Project
A simple Grammar Checker, written in Java, that intakes a sentence and checks it against 10+ grammar rules to see if it complies with all of them.

### Grammar Rules Checked
  1. Must enter a compound sentence (>15 words)
  2. First letter in the sentence must be capitalized
  3. Last character in the sentence must end with punctuation (?/!/.)
  4. Cannot be a run-on sentence (<35words)
  5. Cannot use 'really' or 'very' as they are weak verbs
  6. Cannot use single digit numbers (0-9) as they must be spelled out.
  7. All quotation marks must come in pairs (Checks that there is an even number of them)
  8. Cannot repeat the same word back to back
  9. Proper use of 'an' versus 'a' (The word following 'an' must start with a vowel. The word following 'a' must start with a consonant).
  10. Somewhere in the sentence there must be a noun and then a verb somewhere later in the sentence.
  11. Input cannot be empty or contain just a space

### About the Project

This repository is optimized for use in an EclipseWorkspace. Specifically it was made using the following version of eclipse:
  * Eclipse Standard/SDK
  * Version: Kepler Service Release 2
  * Build id: 20140224-0627

The GrammarFiles folder contains three free textfiles we found on the web. Unfortunately, I couldn't find the link, sorry. However, they have all been modified with additional words as the original 90K+ nouns and 30K+ verbs weren't sufficient for some of our test sentences.

  * **Note:** *If you find the program is erroneously telling you that you are missing a noun or verb please check whether or not the word in question is in either the nouns.txt or verbs.txt files (they are in alphabetical order). If it isn't, insert your word in, save the textfile and re-run the program to see if the error persists.*

### BackGround Info

My group and I completed this school project long before discovering GitHub (Roughly Sept-Nov 2015?) and i'm just now getting around to uploading some of these old projects that I thought were kind of neat or funny.

You can view my group members who collaborated with me to make this project below:
  * [Nico](https://github.com/nicosantarin)
  * [Emre](https://github.com/ITemreb)
