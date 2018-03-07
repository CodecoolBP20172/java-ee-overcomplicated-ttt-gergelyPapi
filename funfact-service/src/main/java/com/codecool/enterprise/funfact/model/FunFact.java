package com.codecool.enterprise.funfact.model;


public class FunFact {

    public FunFact() {
    }

    private String quote;
    private String author;
    private String cat;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    @Override
    public String toString () {
        return quote;
    }

}
