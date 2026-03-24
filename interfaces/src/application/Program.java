package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Contract value: $");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.println();
        System.out.print("Enter installments: ");
        Integer months = sc.nextInt();

        ContractService cs = new ContractService(new PaypalService());

        cs.processContract(contract, months);

        System.out.println();
        System.out.println("Installments:");
        for(Installment i : contract.getInstallments()) {
            System.out.println(i.getDueDate().format(fmt) + String.format(" - %.2f", i.getAmount()));
        }

        System.out.printf("Total: %.2f%n", contract.total());

        sc.close();
    }
}
