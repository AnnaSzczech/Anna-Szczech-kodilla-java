package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        //given
        Product product1 = new Product("Product_1");
        Product product2 = new Product("Product_2");

        Item item1 = new Item(new BigDecimal(2.50), 4);
        Item item2 = new Item(new BigDecimal(1.50), 2);
        Item item3 = new Item(new BigDecimal(10.00), 1);

        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product2.getItems().add(item3);

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);

        Invoice invoice = new Invoice("Invoice_1");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        System.out.println(invoice.getItems());
        System.out.println(product1.getItems());
        System.out.println(product2.getItems());

        //when
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //then
        Assert.assertNotEquals(0, invoiceId);
        //cleanUp
        invoiceDao.deleteById(invoiceId);
    }
}
