package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
    
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        Double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(basicQuota, i);
            double updateQuota = basicQuota + interest;

            double paymentFee = onlinePaymentService.paymentFee(updateQuota);
            double fullQuota = updateQuota + paymentFee;

            contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }
    }
}
