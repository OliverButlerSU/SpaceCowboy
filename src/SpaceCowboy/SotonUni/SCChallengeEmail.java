package SpaceCowboy.SotonUni;

//Used in all functions
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

//Used in 'homePage()'
import java.net.URLConnection;

//Used in 'nameAnagram()'
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SCChallengeEmail {

    public String simpleECSEmailLookup() throws IOException{
        System.out.println("Please input a valid Southampton email address in format userName@domainName, or just userName:");

        //Read from console
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String emailAddress = inputReader.readLine().trim();
        
        //Open URL and read HTML
        URL url = new URL("https://www.ecs.soton.ac.uk/people/" + emailAddress.split("@")[0]);
        BufferedReader websiteReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String currentLine;
        String fullName = "";

        //Read each line, if the line contains the name, assign the name and stop reading from website
        while ((currentLine = websiteReader.readLine()) != null) {
            if (currentLine.contains("property=\"name\"")) {
                fullName = currentLine.split("[<//>]")[83];
                break;
            }
        }
        websiteReader.close();

        //If no username was found, else output username
        if (fullName.equals("")) {
            System.out.println("Invalid email address");
        } else {
            System.out.println("The name of the user with address \"" + emailAddress + "\" is: \"" + fullName + "\"");
        }

        return fullName;
    }



    public String homePage() throws IOException {
        System.out.println("Please input a name to find the homepage of:");

        //Read from console and replace ' ' with '+' to work with URL
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String personName = inputReader.readLine().trim().replace(' ', '+');

        //Create google search URL, set 'user agent header' (this is remove ERROR 403), connect to the website, and start reading the HTML
        URLConnection connection = new URL("https://www.google.com/search?q=" + personName).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();
        BufferedReader websiteReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String homePageURL = "";
        String currentLine;
        Boolean stop = false;

        //Read each line, if a line contains a link (using href), split the line by '=' and '&'
        while ((currentLine = websiteReader.readLine()) != null && !stop) {
            if(currentLine.contains("href")){
                String[] yo = currentLine.split("[=&]");
                for(int i = 0; i < yo.length; i++){
                    //Loop over each line, the first line containing a link will stop
                    try{
                        new URL(yo[i]).toURI();
                        homePageURL = yo[i];
                        stop = true;
                        break;
                    //Stops errors related to converting non-URL strings to URLs
                    } catch (Exception e) { }
                }
            }
        }
        websiteReader.close();

        //Outputs message
        System.out.println("The homepage of \""+ personName.replace('+',' ')+"\" is: "+homePageURL);
        return homePageURL;
    }

    public void nameAnagram(String name) throws IOException {
        //Replace ' ' with '+' to work with website format
        name = name.replace(' ', '+');

        //Open and read HTML from the website
        URL url = new URL("https://new.wordsmith.org/anagram/anagram.cgi?anagram="+name+"&t=500&a=n");
        BufferedReader websiteReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String currentLine;
        String usefulLines = "";

        //Read website, if the current line contains the anagram text, append to usefulLines
        while ((currentLine = websiteReader.readLine()) != null) {
            if (currentLine.contains("document.body.style.cursor=\'wait\';")) {
                while (!(currentLine = websiteReader.readLine()).contains("document.body.style.cursor=\'default\';")) {
                    usefulLines += currentLine;
                }
                break;
            }
        }

        //Create a List which contains all anagrams, removing the first element '</b>'
        List<String> anagramWords  = new ArrayList<>(Arrays.asList(usefulLines.split("<br>")));
        anagramWords.remove(0);

        //If list is empty, no anagrams were found
        if(anagramWords.size()==0){
            System.out.println("There was no anagrams found");
            return;
        }

        //For every element in the anagram list, output the word
        for (String anagramWord : anagramWords) {
            System.out.println(anagramWord);
        }

    }

    //Doesn't work yet
    public void engToFrTranslation() throws IOException{
        System.out.println("Please input what you would like to be translated to English:");

        // Read from console and replace ' ' with '%20' to work with URL
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String english = inputReader.readLine().trim().replace(" ", "%20");

        //Create google translate URL, set 'user agent header' (this is remove ERROR 403), connect to the website, and start reading the HTML
        URLConnection connection = new URL("https://translate.google.com/?sl=en&tl=fr&text="+ english+"&op=translate").openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();
        BufferedReader websiteReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String currentLine;
        String french = "";

        //Read each line, if the line contains the french translation, find it and output the answer
        while ((currentLine = websiteReader.readLine()) != null) {
            if(currentLine.contains("lang=\"fr\"")){
                //Do something
            }
        }
        websiteReader.close();
    }
}

