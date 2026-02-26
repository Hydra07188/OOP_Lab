package com.library.lab04;

public class LibraryMovie implements DigitalContent , Taxable{
    private String title;

    @Override
    public void streamOnline() {

    }

    @Override
    public void downlond() {

    }

    @Override
    public double calcuateTax() {
        return 0;
    }
}
