package org.gaposha;

import org.gaposha.exception.WrongZipFileException;

import java.io.IOException;



public class Archiver {
    public static void main(String[] args) throws IOException {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберете команду для выполнения:");
        ConsoleHelper.writeMessage(String.format("%d - упаковать файлы в архив.", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("%d - добавить файл в архив.", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("%d - удалить файл из архива.", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("%d - распаковать архив.", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("%d - просмотреть содержимое архива.", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("%d - выход", Operation.EXIT.ordinal()));
        return Operation.values()[ConsoleHelper.readInt()];
    }
}
