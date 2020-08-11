package ua.com.wordparser;

import ua.com.wordparser.executor.Executor;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        new Executor().start();
    }
}
