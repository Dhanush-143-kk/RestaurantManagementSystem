package model;

public interface Payable {

    double calculateTotal();

    default void printPaymentMessage() {

        System.out.println(
                "Payment calculation completed."
        );
    }
}