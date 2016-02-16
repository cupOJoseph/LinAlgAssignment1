package Jschiarizzi;

import edu.gwu.lintool.LinTest;

public class TestA1 {

    public static void main (String[] argv)
    {
	// Make an instance of your ComplexNumber class. REPLACE
	// AliceComplex below with your version.
	JschComplex c = new JschComplex (3, 5);
    c.angle();
	// This tests your implementation of complex numbers.
	LinTest.testComplex (c);

	// REPLACE the line below with your tool, and un-comment.
	JschLinTool lin = new JschLinTool();

	// Un-comment tests one by one until all are passed.
	LinTest.testVectorOperations (lin);
	LinTest.testMatrixOperations (lin);
	LinTest.testComplexVectors (lin);

    }

}
