package com.javarush.task.task31.task3105;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[]{"D:\\Java\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3101\\dir\\1.txt",
//                "D:\\Java\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3105\\myArchive.zip"};
        Path file = Paths.get(args[0]);
        Path zipFile = Paths.get(args[1]);
        Path tempZipFile = Files.createTempFile(null, null);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZipFile));
             ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            //Копируем в tempFile наш файл
            String newFileName = "new" + File.separator + args[0].substring(args[0].lastIndexOf(File.separator) + 1);
            ZipEntry entry = new ZipEntry(newFileName);
            zipOutputStream.putNextEntry(entry);
            Files.copy(file, zipOutputStream);
            zipInputStream.closeEntry();
            // теперь в tempFile копируем содержимое архива
            while ((entry = zipInputStream.getNextEntry()) != null) {
                if (entry.getName().equals(newFileName)) {
                    continue;
                }
                zipOutputStream.putNextEntry(new ZipEntry(entry.getName()));
                byte[] buffer = new byte[4 * 1024];
                int len;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
                zipInputStream.closeEntry();
                zipOutputStream.closeEntry();
            }
        }
        // Перемещаем временный файл на место оригинального
        Files.move(tempZipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
