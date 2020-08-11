package ua.com.wordparser;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;
import ua.com.wordparser.executor.Executor;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws XmlException, OpenXML4JException, IOException {
        new Executor().start();
    }
}
