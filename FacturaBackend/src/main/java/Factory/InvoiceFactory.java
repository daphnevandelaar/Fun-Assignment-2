package Factory;

import Models.Invoice;

public class InvoiceFactory {
    public static Invoice createInvoice(){
        return new Invoice();
    }
}
