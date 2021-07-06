package com.company;

public class Main {

    public static void main(String[] args) {
        DbWorker dbWorker=new DbWorker();
        dbWorker.connect();
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Создание таблицы");
        dbWorker.createTable();
        dbWorker.insert("insert into product(id, name_of_product, price, expiration_date)\n" +
                "values(1, 'Огурцы 1кг', 50, '2021-07-10');");
        dbWorker.insert("insert into product(id, name_of_product, price, expiration_date)\n" +
                "values(2, 'Помидоры 1кг', 70, '2021-07-12');");
        dbWorker.insert("insert into product(id, name_of_product, price, expiration_date)\n" +
               "values(3, 'Мясо 1кг', 230, '2021-07-10');");
        dbWorker.insert("insert into product(id, name_of_product, price, expiration_date)\n" +
                "values(4, 'Курица', 250, '2021-08-21');");
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Вывод на экран");
        System.out.println("----------------------------------------------------------------\n");
        dbWorker.getTable();
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Переименование таблицы");
        System.out.println("----------------------------------------------------------------\n");
        dbWorker.renameTo("product","tovar");
        dbWorker.renameTo("tovar", "product");
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Удаление строки");
        System.out.println("----------------------------------------------------------------\n");
        dbWorker.deleteLine("product", "id", 4);
        dbWorker.getTable();
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Добавление строки");
        System.out.println("----------------------------------------------------------------\n");
        dbWorker.insertIntoProduct();
        dbWorker.getTable();
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Обновление индекса");
        System.out.println("----------------------------------------------------------------\n");
        dbWorker.updateIndex();
        dbWorker.getTable();
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Удаление таблицы");
        System.out.println("----------------------------------------------------------------\n");
        dbWorker.dropTable("product");

    }
}
