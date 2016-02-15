package Jschiarizzi;

import edu.gwu.lintool.LinToolEmpty;

/**
 * Created by Joseph Schiarizzi on 2/14/16.
 */
public class JschLinTool extends LinToolEmpty {

    public JschLinTool(){}

    // Vector operations:
    public  double[] add (double[] u, double[] v){

        if(u == null || v == null){
            return null;
        }
        else if(u.length != v.length){
            return null;
        }

        double[] answer = new double[u.length];

        for(int i = 0; i < u.length; i++){
            answer[i] = u[i] + v[i];
        }

        return answer;
    }

    public  double norm (double[] v){
    //TODO fix this shit
        double total = 0;

        if(v == null){
            return -1;
        }

        int size = v.length;
        for(int i = 0; i < size; i++){
            total += Math.pow(v[i],size);
        }

        return Math.pow(total,(1/size));
    }

    public  double dotProduct (double[] u, double[] v){
            if(u == null || v == null || u.length != v.length) {
                return -1;
            }
        double total = 0;
        for(int i = 0; i< u.length; i++){
            total += u[i] * v[i];
        }

        return total;
    }

    public  double[] scalarProduct (double alpha, double[] v){
        if(v == null){
            return null;
        }
        for(int i = 0; i < v.length; i++){
            v[i] = v[i] * alpha;
        }
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

        return A;
    }

    public  double[][] scalarProduct (double alpha, double[][] A){

        return A;
    }

    public  double[][] mult (double[][] A, double[][] B){

        return A;
    }

    public  double[] matrixVectorMult (double[][] A, double[] v){

        return v;
    }

    public  double[] vectorMatrixMult (double[] v, double[][] A){

        return v;
    }

    public  double[][] vectorLeftMult (double[] u, double[] v){

        return new double[0][];
    }

    public  double[][] transpose (double[][] A){

        return A;
    }

    public  double frobeniusNorm (double[][] A){

        return 0;
    }

    public  boolean approxEquals (double[][] A, double[][] B, double errorTolerance){

        return false;
    }

    public  double[] getColumnAsVector (double[][] A, int col){

        return new double[0];
    }

    public  double[] getRowAsVector (double[][] A, int row){

        return new double[0];
    }
}
