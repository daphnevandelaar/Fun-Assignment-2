package BBL.InvoiceBusiness;

import DAL.InvoiceDAL.InvoiceService;
import Factory.InvoiceFactory;
import Models.Invoice;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvoiceBusinessImplementation implements InvoiceBusiness {
    InvoiceService invoiceService = new InvoiceService();

    @Override
    public void createInvoice(Invoice invoice) {
        invoiceService.create(invoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return new ArrayList<Invoice>(invoiceService.readAll());
    }

    public List<REST.representation.Invoice> getAllRestInvoices(){
        List<REST.representation.Invoice> restInvoices = new ArrayList<>();

        for (Invoice mInv:
             invoiceService.readAll()) {
            restInvoices.add(toRestObject(mInv));
        }

        return restInvoices;
    }

    @Override
    public REST.representation.Invoice toRestObject(Invoice mInvoice) {
        REST.representation.Invoice rInvoice = new REST.representation.Invoice();

        rInvoice.setInvoiceid(mInvoice.getInvoiceid());
        rInvoice.setCustomer(mInvoice.getCustomer());
        rInvoice.setTasks(mInvoice.getTasks());
        rInvoice.setTotalprice(mInvoice.getTotalprice());
        return rInvoice;
    }

    @Override
    public Invoice toBusinessObject(REST.representation.Invoice rInvoice) {
        Invoice mInvoice = InvoiceFactory.createInvoice();

        mInvoice.setInvoiceid(rInvoice.getInvoiceid());
        mInvoice.setCustomer(rInvoice.getCustomer());
        mInvoice.setTasks(rInvoice.getTasks());
        mInvoice.setTotalprice(rInvoice.getTotalprice());

        return null;
    }
}
