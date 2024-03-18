package org.gaposha.command;

import org.gaposha.ConsoleHelper;
import org.gaposha.FileProperties;
import org.gaposha.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> properties = zipFileManager.getFilesList();
        for (int i = 0; i < properties.size(); i++) {
            ConsoleHelper.writeMessage(properties.get(i).toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
