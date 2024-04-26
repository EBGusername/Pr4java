package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firms = { "Omega", "Longines", "Breguet", };
        // создаем одномерный массив для фирм
        String[][] brandMap = { {firms[0], "часы"}, {firms[1], "часы настенные" }, {firms[2], "часы с кукушкой" }};
        // создаем двухмерный массив дял позиций и добовляем сюда наш первый массив

        ArrayList<Customer> customers = new ArrayList<>();
        // создаем лист где у нас будут хронятся данные

        // Создаем не менее 3 заказов
        for (int i = 0; i < 3; i++) {
            System.out.println("-_- -_- -_- Создание заказа -_- -_- -_-");
            System.out.print("Введите ФИО покупателя: ");
            String fullName = scanner.nextLine();
            System.out.print("Введите email покупателя: ");
            String email = scanner.nextLine();
            System.out.print("Введите номер телефона покупателя: ");
            int phoneNumber = Integer.parseInt(scanner.nextLine());

            // создаем условия в которм мы увидим какие позийии у нас есть
            System.out.println("Список доступных позиций в магазине:");
            for (int j = 0; j < brandMap.length; j++) {
                System.out.println((j + 1) + ": " + brandMap[j][0] + "-" + brandMap[j][+1]);
            }

            System.out.print("Выберите товара: ");
            int position = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Введите количество: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            customers.add(new Customer(fullName, email, phoneNumber, new String[] { firms[position], brandMap[position][0], brandMap[position][1] }, quantity));
            // создаем ногово пользователя сохроная информацио об старом
        }

        System.out.println("\n-_- -_- Заказы -_- -_-");
        for (Customer customer : customers) {
            System.out.println(customer.toString());}
        // выводим информацию об покупателях
    }

    static class Customer {
        String fullName;
        String email;
        int phoneNumber;
        String[] position;
        int quantity;
        public Customer(String fullName, String email, int phoneNumber, String[] position, int quantity) {
            this.fullName = fullName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.position = position;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            // Формируем текстовое представление покупателя
            return "Покупатель: " + fullName +
                    "\nEmail: " + email +
                    "\nТелефон: " + phoneNumber +
                    "\nПозиция: " + position[0] + " - " + position[1] + ", " + position[2] +
                    "\nКоличество: " + quantity + "\n";
        }
    }
}
