/*
   Copyright (C) 1997,1998,1999
   Kenji Hiranabe, Eiwa System Management, Inc.

   This program is free software.
   Implemented by Kenji Hiranabe(hiranabe@esm.co.jp),
   conforming to the Java(TM) 3D API specification by Sun Microsystems.

   Permission to use, copy, modify, distribute and sell this software
   and its documentation for any purpose is hereby granted without fee,
   provided that the above copyright notice appear in all copies and
   that both that copyright notice and this permission notice appear
   in supporting documentation. Kenji Hiranabe and Eiwa System Management,Inc.
   makes no representations about the suitability of this software for any
   purpose.  It is provided "AS IS" with NO WARRANTY.
*/

package javax.vecmath;

import java.io.Serializable;

/**
  * A 4 element axis angle represented by double precision floating point
  * x,y,z,angle components. An axis angle is a rotation of angle (radians) about
  * the vector (x,y,z).
  * @version specification 1.1, implementation $Revision: 1.11 $, $Date: 1999/10/05 07:03:50 $
  * @author Kenji hiranabe
  */
public class AxisAngle4d implements Serializable {

/*
 * $Log: AxisAngle4d.java,v $
 * Revision 1.11  1999/10/05  07:03:50  hiranabe
 * copyright change
 *
 * Revision 1.11  1999/10/05  07:03:50  hiranabe
 * copyright change
 *
 * Revision 1.10  1999/10/05  04:52:58  hiranabe
 * Java3D 1.2 support.
 * addition of AxisAngle4d(Vector3d,double) constructor and
 * set(Vvector3d,double)
 *
 * Revision 1.9  1999/03/04  09:16:33  hiranabe
 * small bug fix and copyright change
 *
 * Revision 1.8  1999/02/28  05:14:57  hiranabe
 * default constructor comment (0,0,1,0)
 *
 * Revision 1.7  1998/10/14  00:49:10  hiranabe
 * API1.1 Beta02
 *
 * Revision 1.6  1998/07/27  04:28:13  hiranabe
 * API1.1Alpha01 ->API1.1Alpha03
 *
 * Revision 1.5  1998/04/17  10:30:46  hiranabe
 * null check for equals
 *
 * Revision 1.4  1998/04/09  08:18:15  hiranabe
 * minor comment change
 *
 * Revision 1.3  1998/04/09  07:04:31  hiranabe
 * *** empty log message ***
 *
 * Revision 1.2  1998/01/05  06:29:31  hiranabe
 * copyright 98
 *
 * Revision 1.1  1997/11/26  03:00:44  hiranabe
 * Initial revision
 *
 */

/*
 * I assumed that the length of the axis vector is not significant.
 */

    /**
      * The x coordinate.
      */
    public double x;

    /**
      * The y coordinate.
      */
    public double y;

    /**
      * The z coordinate.
      */
    public double z;

    /**
      * The angle.
      */
    public double angle;

    /**
      * Constructs and initializes an AxisAngle4d from the specified x, y, z,
      * and angle.
      * @param x the x coordinate
      * @param y the y coordinate
      * @param z the z coordinate
      * @param angle the angle.
      */
    public AxisAngle4d(double x, double y, double z, double angle) {
	set(x, y, z, angle);
    }

    /**
      * Constructs and initializes an AxisAngle4d from the components contained
      * in the array.
      * @param a the array of length 4 containing x,y,z,angle in order
      */
    public AxisAngle4d(double a[]) {
	set(a);
    }

    /**
      * Constructs and initializes a AxisAngle4d from the specified AxisAngle4d.
      * @param a1 the AxisAngle4d containing the initialization x y z angle data
      */
    public AxisAngle4d(AxisAngle4d a1) {
	set(a1);
    }

    /**
      * Constructs and initializes a AxisAngle4d from the specified AxisAngle4f.
      * @param a1 the AxisAngle4f containing the initialization x y z angle data
      */
    public AxisAngle4d(AxisAngle4f a1) {
	set(a1);
    }

    /**
      * Constructs and initializes a AxisAngle4d to (0,0,1,0).
      */
    public AxisAngle4d() {
	x = 0.0;
	y = 0.0;
	z = 1.0;
	angle = 0.0;
    }

    /**
     * Constructs and initializes an AxisAngle4d from the specified axis
     * and angle.
     *
     * @param axis the axis
     * @param angle the angle
     * @since Java 3D 1.2
     */
    public AxisAngle4d(Vector3d axis, double angle) {
        x = axis.x;
        y = axis.y;
        z = axis.z;
        this.angle = angle;
    }

    /**
     * Sets the value of this AxisAngle4d to the specified axis and
     * angle.
     * @param axis the axis
     * @param angle the angle
     * @since Java 3D 1.2
     */
    public final void set(Vector3d axis, double angle) {
        x = axis.x;
        y = axis.y;
        z = axis.z;
        this.angle = angle;
    }


    /**
      * Sets the value of this axis angle to the specified x,y,z,angle.
      * @param x the x coordinate
      * @param y the y coordinate
      * @param z the z coordinate
      * @param angle the angle
      */
    public final void set(double x, double y, double z, double angle) {
	this.x = x;
	this.y = y;
	this.z = z;
	this.angle = angle;
    }

    /**
      * Sets the value of this axis angle from the 4 values specified in the array.
      * @param a the array of length 4 containing x,y,z,angle in order
      */
    public final void set(double a[]) {
	// ArrayIndexOutOfBounds is thrown if t.length < 4
	x = a[0];
	y = a[1];
	z = a[2];
	angle = a[3];
    }

    /**
      * Sets the value of this axis angle to the value of axis angle t1.
      * @param t1 the axis angle to be copied
      */
    public final void set(AxisAngle4d a1) {
	x = a1.x;
	y = a1.y;
	z = a1.z;
	angle = a1.angle;
    }

    /**
      * Sets the value of this axis angle to the value of axis angle t1.
      * @param t1 the axis angle to be copied
      */
    public final void set(AxisAngle4f a1) {
	x = (float)(a1.x);
	y = (float)(a1.y);
	z = (float)(a1.z);
	angle = (float)(a1.angle);
    }

    /**
      * Gets the value of this axis angle into the array a of
      * length four in x,y,z,angle order.
      * @param a the array of length four
      */
    public final void get(double a[]) {
	// ArrayIndexOutOfBounds is thrown if a.length < 4
	a[0] = x;
	a[1] = y;
	a[2] = z;
	a[3] = angle;
    }

    /**
      * Sets the value of this axis-angle to the rotational component of the
      * passed matrix.
      * @param m1 the matrix4f
      */
    public final void set(Matrix4f m1) {
	setFromMat(
	    m1.m00, m1.m01, m1.m02,
	    m1.m10, m1.m11, m1.m12,
	    m1.m20, m1.m21, m1.m22
	    );
    }

    /**
      * Sets the value of this axis-angle to the rotational component of the
      * passed matrix.
      * @param m1 the matrix4d
      */
    public final void set(Matrix4d m1) {
	setFromMat(
	    m1.m00, m1.m01, m1.m02,
	    m1.m10, m1.m11, m1.m12,
	    m1.m20, m1.m21, m1.m22
	    );
    }


    /**
      * Sets the value of this axis-angle to the rotational component of the
      * passed matrix.
      * @param m1 the matrix3f
      */
    public final void set(Matrix3f m1) {
	setFromMat(
	    m1.m00, m1.m01, m1.m02,
	    m1.m10, m1.m11, m1.m12,
	    m1.m20, m1.m21, m1.m22
	    );
    }

    /**
      * Sets the value of this axis-angle to the rotational component of the
      * passed matrix.
      * @param m1 the matrix3d
      */
    public final void set(Matrix3d m1) {
	setFromMat(
	    m1.m00, m1.m01, m1.m02,
	    m1.m10, m1.m11, m1.m12,
	    m1.m20, m1.m21, m1.m22
	    );
    }

    /**
      * Sets the value of this axis-angle to the rotational equivalent of the
      * passed quaternion.
      * @param q1 the Quat4f
      */
    public final void set(Quat4f q1) {
	setFromQuat(q1.x, q1.y, q1.z, q1.w);
    }

    /**
      * Sets the value of this axis-angle to the rotational equivalent of the
      * passed quaternion.
      * @param q1 the Quat4d
      */
    public final void set(Quat4d q1) {
	setFromQuat(q1.x, q1.y, q1.z, q1.w);
    }


    // helper method
    private void setFromMat(double m00, double m01, double m02,
		       double m10, double m11, double m12,
		       double m20, double m21, double m22) {

	// assuming M is normalized.

	double cos = (m00 + m11 + m22 - 1.0)*0.5;
	x = m21 - m12;
	y = m02 - m20;
	z = m10 - m01;
	double sin = 0.5*Math.sqrt(x*x + y*y + z*z);
	angle = Math.atan2(sin, cos);

	// no need to normalize
	// x /= n;
	// y /= n;
	// z /= n;

    }

    // helper method
    private void setFromQuat(double x, double y, double z, double w) {
	// This logic can calculate angle without normalization.
	// The direction of (x,y,z) and the sign of rotation cancel
	// each other to calculate a right answer.

	double sin_a2 = Math.sqrt(x*x + y*y + z*z);  // |sin a/2|, w = cos a/2
	this.angle = 2.0*Math.atan2(sin_a2, w); // 0 <= angle <= PI , because 0 < sin_a2
	this.x = x;
	this.y = y;
	this.z = z;

//	double sin = 2.0*Math.abs(w)*Math.sqrt(x*x + y*y + z*z);
//	double cos = 2*w*w - 1;
//
//	angle = Math.atan2(sin, cos);
//	if (Math.sin(angle/2.0) < 0) {
//	    this.x = -x;
//	    this.y = -y;
//	    this.z = -z;
//	} else {
//	    this.x = x;
//	    this.y = y;
//	    this.z = z;
//	}
    }

    /**
      * Returns a string that contains the values of this AxisAngle4d. The form is (x,y,z,angle).
      * @return the String representation
      */
    public String toString() {
	    return "(" + x + ", " + y + ", " + z +", " + angle + ")";
    }

    /**
      * Returns true if all of the data members of AxisAngle4d t1 are equal to the corresponding
      * data members in this
      * @param a1 the vector with which the comparison is made.
      */
    public boolean equals(AxisAngle4d a1) {
	return a1 != null && x == a1.x && y == a1.y && z == a1.z && angle == a1.angle;
    }

    /**
      * Returns true if the Object o1 is of type AxisAngle4d and all of the data
      * members of t1 are equal to the corresponding data members in this
      * AxisAngle4d.
      * @param o1 the object with which the comparison is made.
      */
    public boolean equals(Object o1) {
	return o1 != null && (o1 instanceof AxisAngle4d) && equals((AxisAngle4d)o1);
    }

    /**
      * Returns true if the L-infinite distance between this axis-angle and axis-angle t1 is
      * less than or equal to the epsilon parameter, otherwise returns false. The L-infinite
      * distance is equal to MAX[abs(x1-x2), abs(y1-y2), abs(z1-z2), abs(angle1-angle2)].
      * @param a1 the axis-angle to be compared to this axis-angle
      * @param epsilon the threshold value
      */
    public boolean epsilonEquals(AxisAngle4d a1, double epsilon) {
	return (Math.abs(a1.x - this.x) <= epsilon) &&
	    (Math.abs(a1.y - this.y) <= epsilon) &&
	    (Math.abs(a1.z - this.z) <= epsilon) &&
	    (Math.abs(a1.angle - this.angle) <= epsilon);
    }


    /**
      * Returns a hash number based on the data values in this object. 
      * Two different AxisAngle4d objects with identical data  values
      * (ie, returns true for equals(AxisAngle4d) ) will return the same hash number.
      * Two vectors with different data members may return the same hash value,
      * although this is not likely.
      */
      public int hashCode() {
	  long xbits = Double.doubleToLongBits(x);
	  long ybits = Double.doubleToLongBits(y);
	  long zbits = Double.doubleToLongBits(z);
	  long abits = Double.doubleToLongBits(angle);
	  return (int)(xbits ^ (xbits >> 32) ^
		  ybits ^ (ybits >> 32) ^
		  zbits ^ (zbits >> 32) ^
		  abits ^ (abits >> 32));
      }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getZ()
    {
        return z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }
    public double getAngle()
    {
        return angle;
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
    }
}
