package org.gaposha.command;

import org.gaposha.ConsoleHelper;
import org.gaposha.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

   public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь до архива: ");
        Path inputPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(inputPath);
    }
}
