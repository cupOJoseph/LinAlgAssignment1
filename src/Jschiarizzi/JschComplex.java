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

        return Math.sqrt((this.re * this.re) + (this.im * this.im));
        //return 0;
    }

    @Override
    public double angle() {
        return Math.atan2(this.re,this.im);
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
    public ComplexNumber mult(ComplexNumber c) {


        return null;
    }

    @Override
    public ComplexNumber mult(double a) {

        return new JschComplex(this.re * a, this.im * a);
    }

    @Override
    public ComplexNumber pow(int n) {
            double real = re;
            double imag = im;

            //start check special case
            if(n == 0) {
                return new JschComplex(1,1);
            }
            else if(n > 0) {
                for (int i = 1; i < n; i++) {
                    real = real * re;
                    imag = imag * im;
                }

                return new JschComplex(real, imag);

            }else if(n < 0){
                System.out.println("nyi");
            }
        return new JschComplex(real, imag);
    }

    @Override
    public ComplexNumber conjugate() {
        return new JschComplex() ;

    }

}
