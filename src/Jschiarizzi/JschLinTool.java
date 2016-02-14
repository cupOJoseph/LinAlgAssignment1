package Jschiarizzi;

import edu.gwu.lintool.LinToolEmpty;

/**
 * Created by Joseph Schiarizzi on 2/14/16.
 */
public class JschLinTool extends LinToolEmpty {

    public JschLinTool(){}

    // Vector operations:
    public  double[] add (double[] u, double[] v){

        return u;
    }

    public  double norm (double[] v){

        return 0;
    }

    public  double dotProduct (double[] u, double[] v){

        return 0;
    }

    public  double[] scalarProduct (double alpha, double[] v){

        return v;
    }

    public  boolean approxEquals (double[] u, double[] v, double errorTolerance){

        return false;
    }

    public  double cosine (double[] u, double[] v){

        return 0;
    }

    // Matrix operations:
    public  double[][] add (double[][] A, double[][] B){

    }

    public  double[][] scalarProduct (double alpha, double[][] A){

    }

    public  double[][] mult (double[][] A, double[][] B){

    }

    public  double[] matrixVectorMult (double[][] A, double[] v){

    }

    public  double[] vectorMatrixMult (double[] v, double[][] A){

    }

    public  double[][] vectorLeftMult (double[] u, double[] v){

    }

    public  double[][] transpose (double[][] A){

    }

    public  double frobeniusNorm (double[][] A){

    }

    public  boolean approxEquals (double[][] A, double[][] B, double errorTolerance){

    }

    public  double[] getColumnAsVector (double[][] A, int col){

    }
    
    public  double[] getRowAsVector (double[][] A, int row){

    }
}
