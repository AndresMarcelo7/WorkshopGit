/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci;

/**
 *
 * @author 2145594
 */
import java.nio.file.*;

import org.apache.tika.Tika;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class FileSpy {
    private static final String FILE_TYPE = "text/csv";
    private static final String DIR_TO_WATCH = "C:\\Users\\DiegoPT\\Downloads\\temp";

    public static void main(String[] args) throws Exception {
        Path dir = Paths.get(DIR_TO_WATCH);
        Tika tika = new Tika();
        WatchService watchService = FileSystems.getDefault().newWatchService();
        dir.register(watchService, ENTRY_CREATE);

        WatchKey key;
        do {
            key = watchService.take();

            key.pollEvents().stream().filter(e -> {
                Path filename = (Path) e.context();
                String type = tika.detect(filename.toString());
                return FILE_TYPE.equals(type);
            }).forEach(e ->
                    System.out.printf("File found: %s%n", e.context())
            );
        } while (key.reset());
    }
}
