package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Invoice;

import java.util.List;

public interface InvoiceDao {
    Invoice addInvoice(Invoice invoice);
    Invoice getInvoice(int id);
    List<Invoice> getAllInvoices();
    void updateInvoice(Invoice invoice);
    void deleteInvoice(int id);
    List<Invoice> getInvoiceByCustomer(int customerId);
}
