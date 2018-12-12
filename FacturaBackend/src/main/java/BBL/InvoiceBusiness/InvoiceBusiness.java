package BBL.InvoiceBusiness;

import Models.Invoice;

import java.util.List;

public interface InvoiceBusiness {
    void createInvoice(Invoice invoice);
    void updateInvoice(Invoice invoice);
    List<Invoice> getAllInvoices();
    List<REST.representation.Invoice> getAllRestInvoices();
    REST.representation.Invoice toRestObject(Invoice mInvoice);
    Invoice toBusinessObject(REST.representation.Invoice rInvoice);
}
