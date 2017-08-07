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

    public int getaInt() {
        return integer;
    }

    public void setaInt(int aInt) {
        this.integer = aInt;
    }

    public double getaDouble() {
        return fractional;
    }

    public void setaDouble(double aDouble) {
        this.fractional = aDouble;
    }

    public char getaChar() {
        return symbol;
    }

    public void setaChar(char aChar) {
        this.symbol = aChar;
    }

    public String getaString() {
        return text;
    }

    public void setaString(String aString) {
        this.text = aString;
    }


    @Override
    public String toString() {String newLine = "\n";
        return "Name: " + this.getClass().getName() + newLine +"\tinteger = " + integer + newLine +"\tfractional = " + fractional + newLine +
                "\tsymbol = " + symbol + newLine +"\ttext = " + text;
    }
}