package com.example.internalassesmentchemquzier;

import java.util.List;

public class Element{
    private String element;
    private String symbol;
    private int atomicNumber;
    private double relativeAtomicMass;
    private String chemicalName;
    private List<Question> questions;

    public Element(String element, String symbol, int atomicNumber, double relativeAtomicMass, String chemicalName, List<Question> questions) {
        this.element = element;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.relativeAtomicMass = relativeAtomicMass;
        this.chemicalName = chemicalName;
        this.questions = questions;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public double getRelativeAtomicMass() {
        return relativeAtomicMass;
    }

    public void setRelativeAtomicMass(double relativeAtomicMass) {
        this.relativeAtomicMass = relativeAtomicMass;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Element{" +
                "element='" + element + '\'' +
                ", symbol='" + symbol + '\'' +
                ", atomicNumber=" + atomicNumber +
                ", relativeAtomicMass=" + relativeAtomicMass +
                ", chemicalName='" + chemicalName + '\'' +
                ", questions=" + questions +
                '}';
    }
}


