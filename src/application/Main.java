package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Products;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Instanciando uma lista do tipo Products
		List<Products> list = new ArrayList<>();

		while (true) {
			System.out.println();
			System.out.println("Options: ");
			System.out.println("1 - Add product");
			System.out.println("2 - List all products");
			System.out.println("3 - Search product by ID");
			System.out.println("4 - Remove product by ID");
			System.out.println("5 - Exit");

			System.out.println();
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addProduct(list, sc);
				break;
			case 2:
				listProducts(list);
				break;
			case 3:
				searchID(list, sc);
				break;
			case 4:
				removeID(list, sc);
				break;
			case 5:
				System.out.println("Exiting program!");
				sc.close();
				return;
			default:
				System.out.println("Invalid choice, try again!");
				break;
			}
		}

	}

	public static void addProduct(List<Products> list, Scanner sc) {

		while (true) {
			int id;
			System.out.print("Enter product id: ");
			id = sc.nextInt();
			sc.nextLine();
			if (hasId(list, id)) {
				System.out.println("ID already taken! Try again");
				continue;
			}
			System.out.print("Enter product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Enter product price: ");
			double price = sc.nextDouble();

			Products prod = new Products(id, nameProduct, price);

			list.add(prod);
			break;
		}
	}

	public static void listProducts(List<Products> list) {
		System.out.println("Products list: ");
		for (Products prod : list) {
			System.out.println(prod);
		}
	}

	public static void searchID(List<Products> list, Scanner sc) {
		System.out.print("Enter the id to search: ");
		int id = sc.nextInt();
		sc.nextLine();
		Products prod = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (prod != null) {
			System.out.println(prod);
		} else {
			System.out.println("This product dont exist!");
		}
	}

	public static void removeID(List<Products> list, Scanner sc) {
		System.out.print("Enter the id to be removed: ");
		int id = sc.nextInt();
		sc.nextLine();

		Products prod = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (prod != null) {
			System.out.println("Item removed whit successfully!");
			list.remove(prod);
		} else {
			System.out.println("Id not found! Try again!");
		}
	}

	public static Boolean hasId(List<Products> list, int id) {
		Products prod = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return prod != null;
	}

}
