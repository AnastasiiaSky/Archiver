package org.gaposha;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);
            try(InputStream fileInputStream = Files.newInputStream(source)) {
                byte[] data = new byte[8 * 1024];
                int length;
                while ((length = fileInputStream.read(data)) > 0) {
                    zipOutputStream.write(data, 0, length);
                }
            }
            zipOutputStream.closeEntry();
        }
    }
}