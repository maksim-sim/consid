import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (фамилия имя отчество дата_рождения номер_телефона пол):");
        String input = scanner.nextLine();

        String[] data = input.split(" ");

        if (data.length != 6) {
            System.err.println("Неверное количество данных. Введите данные в формате: фамилия имя отчество дата_рождения номер_телефона пол");
            return;
        }

        try {
            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            String fileName = surname + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.write(surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender + "\n");

            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверный формат номера телефона");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Некорректный формат данных");
            e.printStackTrace();
        }
    }
}