package Jschiarizzi;

import edu.gwu.lintool.*;
/**
 * Created by Joseph Schiarizzi on 2/13/16.
 */
public class JschComplex extends ComplexNumber{

   //required data fields are already implemented in parent object
    //re ; the real part
    // im ; imaginary
    // angle ; not sure what this represents exactly


    public JschComplex() {
    }

    public JschComplex(double real, double imaginary){
        this.re = real;
        this.im = imaginary;
        this.angle = Math.atan2(this.re,this.im);
    }

    @Override
    public double magnitude() {
        //double mag = Math.sqrt((this.re * this.re) + (this.im * this.im));
        //System.out.println("Mag: " + mag);
        //return mag;
        return Math.sqrt((this.re * this.re) + (this.im * this.im));
    }

    @Override
    public double angle() {
       this.angle = Math.atan2(this.im,this.re);

        //System.out.println("Angle: " + angle);

        if(angle < 0){
            angle = (2*Math.PI) - (-1*angle);
        }
        return this.angle;
    }

    @Override
    public ComplexNumber add(ComplexNumber b) {
        JschComplex c = (JschComplex) b;
        return new JschComplex (this.re + c.re, this.im + c.im);
    }

    @Override
    public ComplexNumber sub(ComplexNumber b) {
        JschComplex c = (JschComplex) b;
        return new JschComplex(this.re - c.re, this.im - c.im);
    }

    @Override
    public ComplexNumber mult(ComplexNumber b) {
        JschComplex c = (JschComplex) b;
        double real = c.re;
        double imag = c.im;

        //System.out.println("Multiplying ( " + this.re + " + i" + this.im + " ) by (" + c.re + " + i" + c.im + " )");

        c.re = (this.re * real) - (this.im * imag);
        c.im = (this.re * imag) + (this.im * real);

        //System.out.println("I got " + c.re + " + " + c.im + "i.");

        return new JschComplex(c.re, c.im);
    }

    @Override
    public ComplexNumber mult(double a) {

        //System.out.println("multiplying by " + a);

        return new JschComplex(this.re * a, this.im * a);
    }

    @Override
    public ComplexNumber pow(int n) {

            JschComplex c = new JschComplex(this.re, this.im); //new object to save this object and still return a new one.
            JschComplex orig = new JschComplex(c.re, c.im);

            //System.out.println("n = " + n);
            //System.out.println("Taking power of " + this.re + " + " + this.im + "i.");


            //start check special case
            if(n == 0) {
                return new JschComplex(1,1);
            }
            else if(n > 0) {
                for(int i = 1; i < n; i++) {
                    c = (JschComplex) mult(orig);
                }

                return new JschComplex(c.re, c.im);

            }else if(n < 0){

                for(int i = 1; i < n; i++) {
                    c = (JschComplex) mult(orig);
                }

                c.re = 1/c.re;
                c.im = 1/c.im;
            }
        return new JschComplex(c.re, c.im);
    }


    @Override
    public ComplexNumber conjugate() {

        return new JschComplex(this.re,(-1*this.im));
    }

}
