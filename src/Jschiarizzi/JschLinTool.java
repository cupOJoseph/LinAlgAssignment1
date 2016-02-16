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

        double total = 0;

        if(v == null){
            return -1;
        }


        for(int i = 0; i < v.length; i++){
            total += v[i] * v[i];
        }

        return Math.sqrt(total);
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

        if(u.length != v.length || u == null || v == null){
            return false;
        }

        double negTol;
        //easier to check a little above and a little below zero with this variable
        if(errorTolerance < 0){
            errorTolerance *= -1;//make it positive
        }
        negTol = 0 - errorTolerance;

        double total = 0;
        for(int i = 0; i < u.length; i++){
            total = (u[i]*u[i]) - (v[i]*v[i]);
            if(total > errorTolerance || total < negTol){
                return false;
            }
        }

        return true;
    }

    public  double cosine (double[] u, double[] v){

        return 0;
    }

    // Matrix operations:
    public  double[][] add (double[][] A, double[][] B){

        if(A == null || B == null || A[0].length != B[0].length || A.length != B.length){
            return null;
        }

        double[][] C = new double[A.length][A[0].length];

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }


        return C;
    }

    public  double[][] scalarProduct (double alpha, double[][] A){

        if(A == null){
            return null;
        }

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                A[i][j] = alpha * A[i][j];
            }
        }

        return A;
    }

    public  double[][] mult (double[][] A, double[][] B){

        if(A == null || B == null || A[0].length != B.length){
            return null;
        }

        double[][] C = new double[A.length][B[0].length];
        //System.out.println("C is " + A.length + " by " + B[0].length);


        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B[i].length; j++){

                for (int k = 0; k < A[0].length; k++ ){
                    C[i][j] += A[i][k] * B[k][j];
                }

            }//end j
        }//end i

        return C;
    }

    public  double[] matrixVectorMult (double[][] A, double[] v){

        if(A == null || v == null || A[0].length != v.length){
            return null;
        }

        double[] C = new double [A.length];

        for (int i = 0; i< A.length; i++){
            for (int j = 0; j < A[i].length; j++){
                C[i] += v[j] * A[i][j];
            }
        }

        return C;
    }

    public  double[] vectorMatrixMult (double[] v, double[][] A){

        if(v == null || A == null){
            return null;
        }else if(v.length != A.length){
            return null;
        }

        double[] C = new double[A[0].length];

        for(int i = 0; i < A[0].length; i++){
            for (int j = 0; j < A.length; j++){
                //do like previous method except kinda backwards.
                C[i] += A[j][i] * v[j];
            }
        }

        return C;
    }

    public  double[][] vectorLeftMult (double[] u, double[] v){

        return new double[0][];
    }

    public  double[][] transpose (double[][] A){

        if(A == null){
            return null;
        }

        double[][] C = new double[A[0].length][A.length];

        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[i].length; j++)
                C[j][i] = A[i][j];
        return C;
    }

    public  double frobeniusNorm (double[][] A){

        if(A == null){
            return -1;
        }

        double norm = 0;

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                norm += A[i][j] * A[i][j];
            }
        }

        norm = Math.sqrt(norm);

        return norm;
    }

    public  boolean approxEquals (double[][] A, double[][] B, double errorTolerance){

        if(A == null || B == null){
            return false;
        }

        if(A.length != B.length || A[0].length != B[0].length){
            return false;
        }

        if(errorTolerance < 0){
            errorTolerance *= -1;
        }
        double negErrTol = 0 - errorTolerance;


        double total = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                total = (A[i][j]*A[i][j]) - (B[i][j]*B[i][j]);

                if(total > errorTolerance || total < negErrTol){
                    return false;
                }
            }
        }

        return true;
    }

    public  double[] getColumnAsVector (double[][] A, int col){

        if(A == null){
            return null;
        }

        double[] C = new double[A[0].length];

        for(int i = 0; i < A[0].length; i++){
            C[i] = A[i][col];
        }

        return C;
    }

    public  double[] getRowAsVector (double[][] A, int row){

        if(A == null){
            return null;
        }

        double[] C = new double[A[0].length];

        for(int i = 0; i < A[0].length; i++){
            C[i] = A[row][i];
        }

        return C;
    }
}
