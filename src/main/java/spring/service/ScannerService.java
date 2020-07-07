package spring.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@Service
public class ScannerService {
   private final String encoding = System.getProperty("console.encoding", "utf-8");

    public Scanner getScannerWithPath(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return new Scanner(path);
    }

    public Scanner getScannerIn() throws IOException {
        return new Scanner(System.in, encoding);
    }

}
