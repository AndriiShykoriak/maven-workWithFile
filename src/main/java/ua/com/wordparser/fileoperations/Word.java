package ua.com.wordparser.fileoperations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Word {
    private String word;
    private int count;
}
