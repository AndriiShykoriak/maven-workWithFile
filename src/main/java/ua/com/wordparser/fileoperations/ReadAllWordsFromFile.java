package ua.com.wordparser.fileoperations;

import lombok.SneakyThrows;
import org.apache.poi.POITextExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class ReadAllWordsFromFile {
    public final static long
    getWordCount(final String file) throws IOException {
        POITextExtractor textExtractor;
        XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
        textExtractor = new XWPFWordExtractor(doc);
        return Arrays.stream(textExtractor.getText().split("\\s+"))
                .filter(s -> s.matches("^.*[\\p{L}\\p{N}].*$"))
                .count();
    }

    @SneakyThrows
    public final static List<String>
    getWordSizeLargerThanNumber(final String file, final int shortLength) {
        POITextExtractor textExtractor;
        XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
        textExtractor = new XWPFWordExtractor(doc);
        return Arrays.stream(textExtractor.getText().split("\\s+"))
                .filter(s -> s.length() > shortLength)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public final static List<String>
    getMostPopularWords(final String file, final int quantity) {
        POITextExtractor textExtractor;
        XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
        textExtractor = new XWPFWordExtractor(doc);

        List<String> text = Arrays.asList((textExtractor
                .getText()
                .split("\\s+")));
        Map<String, Integer> map = new HashMap<>();
        text.forEach(s -> {
            if (map.containsKey(s)) {
                int value = map.get(s);
                map.put(s, value + 1);
            } else {
                map.put(s, 1);
            }
        });
        List<Word> list = new ArrayList<>();
        map.forEach((s, integer) -> list.add(new Word(s, integer)));
        list.sort(Comparator.comparing(Word::getCount).reversed());
        return list.stream()
                .map(Word::getWord)
                .limit(quantity)
                .collect(Collectors.toList());
    }
}
