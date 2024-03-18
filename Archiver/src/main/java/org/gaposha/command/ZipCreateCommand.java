package org.gaposha.command;

import org.gaposha.ConsoleHelper;
import org.gaposha.ZipFileManager;
import org.gaposha.exception.PathIsNotFoundException;

import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации.");
            zipFileManager.createZip(Paths.get(ConsoleHelper.readString()));
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException pathIsNotFoundException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
