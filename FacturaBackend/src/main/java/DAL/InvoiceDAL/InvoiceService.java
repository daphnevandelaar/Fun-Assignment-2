package DAL.InvoiceDAL;

import Models.Invoice;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

public class InvoiceService implements InvoiceDAO{
    private static InvoiceDAOImplementation invoiceDAO;

    public InvoiceService(){ invoiceDAO = new InvoiceDAOImplementation(); }

    @Override
    public void create(Invoice entity) {
        invoiceDAO.openCurrentSessionwithTransaction();
        invoiceDAO.create(entity);
        invoiceDAO.closeCurrentSessionwithTransaction();
    }

    @Override
    public Invoice read(Integer index) {
        return invoiceDAO.read(index);
    }

    @Override
    public Set<Invoice> readAll() {
        invoiceDAO.openCurrentSession();
        Set<Invoice> invoices = invoiceDAO.readAll();
        invoiceDAO.closeCurrentSession();

        return invoices;
    }

    @Override
    public void update(Invoice entity) {

    }

    @Override
    public void delete(Invoice entity) {

    }
}
