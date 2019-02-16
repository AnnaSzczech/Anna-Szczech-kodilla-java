package com.kodilla.stream.invoice.simple;

import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class SimpleInvoice {
    private final List<SimpleItem> items = new ArrayList<>();

    public boolean removetem(SimpleItem item){
        return items.remove(item);
    }

    public void addItem(SimpleItem item){
        items.add(item);
    }

    public double getValueToPay(){
        return items.stream()
                .collect(Collectors.summingDouble(SimpleItem::getValue));
    }
}
