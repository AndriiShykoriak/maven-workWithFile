package ua.com.wordparser.executor;

import java.io.FileWriter;
import java.io.IOException;

import static ua.com.wordparser.fileoperations.ReadAllWordsFromFile.*;
import static ua.com.wordparser.fileoperations.ReadDocxFile.readDocxFile;

public class Executor {
    private final String pathFile = "src/main/resources/data.docx";
    private final String pathFileWordsLargerNumber = "src/main/resources/WordsLargerNumber.docx";

    public void start() throws IOException {
        readDocxFile(pathFile);
        System.out.println("The total number of words in the file:\t[" + getWordCount(pathFile) + "]");
        System.out.println("delete all words, which size are less 3 and save to file WordsLargerNumber.docx");
        FileWriter fileWriter = new FileWriter(pathFileWordsLargerNumber);
        for (String str : getWordSizeLargerThanNumber(pathFile, 3)) {
            fileWriter.write(str + System.lineSeparator());
        }
        fileWriter.close();
        System.out.println("The most popular words are : " + getMostPopularWords(pathFile, 5));
    }
}
