import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {

        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words");
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/war-and-peace.txt");
        
        //print all the words that are in the novel but not in the dictionary !
        for (String word : novelWords) {
            if (!dictionaryWords.contains(word)){
                System.out.print(word + " ");
            }
        }

        //print the number of unique words in the novel !
        System.out.println("\nThere are "+novelWords.size()+" unique words in The Novel !");

        //print the number of words with >3 letters !
        Iterator<String> iter = novelWords.iterator();
        while (iter.hasNext()) {
            if (iter.next().length() > 3) {
                iter.remove();
            }
        }
        System.out.println("There are. "+novelWords.size()+" ? unique words w/ >3 letters in The Novel !");
    
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        //we use a hashset instead of a treeset since the storage order doesn't matter
        Set<String> words = new HashSet<>();

        System.out.println(System.getProperty("user.dir"));
        
        Scanner in = new Scanner(new File(filename), "UTF-8");
        
        //Use any character that's not a letter as delimeters
        in.useDelimiter("[^a-zA-Z]+");

        //add words to the set (duplicates are ignored automatically! :3)
        while(in.hasNext()){
            words.add(in.next().toLowerCase());
        }

        return words;
    }
}
