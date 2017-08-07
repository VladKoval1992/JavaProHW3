class MyClass {

    @Save
    public int integer;
    @Save
    public double fractional;
    @Save
    public char symbol;
    @Save
    public String text;

    public MyClass() {
        this.integer = 1;
        this.fractional = 1.5;
        this.symbol = 's';
        this.text = "JavaPro";
    }

    public MyClass(int integer, double fractional, char symbol, String text) {
        this.integer = integer;
        this.fractional = fractional;
        this.symbol = symbol;
        this.text = text;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public double getFractional() {
        return fractional;
    }

    public void setFractional(double fractional) {
        this.fractional = fractional;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {String newLine = "\n";
        return "Name: " + this.getClass().getName() + newLine +"\tinteger = " + integer + newLine +"\tfractional = " + fractional + newLine +
                "\tsymbol = " + symbol + newLine +"\ttext = " + text;
    }
}