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
  * A generic 4 element tuple that is represented by
  * double precision floating point x,y,z and w coordinates.
  * @version specification 1.1, implementation $Revision: 1.11 $, $Date: 1999/10/05 07:03:50 $
  * @author Kenji hiranabe
  */
public abstract class Tuple4d implements Serializable {
/*
 * $Log: Tuple4d.java,v $
 * Revision 1.11  1999/10/05  07:03:50  hiranabe
 * copyright change
 *
 * Revision 1.11  1999/10/05  07:03:50  hiranabe
 * copyright change
 *
 * Revision 1.10  1999/03/04  09:16:33  hiranabe
 * small bug fix and copyright change
 *
 * Revision 1.9  1999/02/27  03:39:58  hiranabe
 * sub bug w = t1.w - t2.w;
 *
 * Revision 1.8  1998/10/14  00:49:10  hiranabe
 * API1.1 Beta02
 *
 * Revision 1.7  1998/07/27  04:28:13  hiranabe
 * API1.1Alpha01 ->API1.1Alpha03
 *
 * Revision 1.6  1998/04/17  10:30:46  hiranabe
 * null check for equals
 *
 * Revision 1.5  1998/04/09  08:18:15  hiranabe
 * minor comment change
 *
 * Revision 1.4  1998/04/09  07:05:18  hiranabe
 * API 1.1
 *
 * Revision 1.3  1998/01/06  00:20:14  hiranabe
 * typo of scale method
 *
 * Revision 1.2  1998/01/05  06:29:31  hiranabe
 * copyright 98
 *
 * Revision 1.1  1997/11/26  03:00:44  hiranabe
 * Initial revision
 *
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
      * The w coordinate.
      */
    public double w;

    /**
      * Constructs and initializes a Tuple4d from the specified xyzw coordinates.
      * @param x the x coordinate
      * @param y the y coordinate
      * @param z the z coordinate
      * @param w the w coordinate
      */
    public Tuple4d(double x, double y, double z, double w) {
	set(x, y, z, w);
    }

    /**
      * Constructs and initializes a Tuple4d from the specified array.
      * @param t the array of length 4 containing xyzw in order
      */
    public Tuple4d(double t[]) {
	set(t);
    }

    /**
      * Constructs and initializes a Tuple4d from the specified Tuple4d.
      * @param t1 the Tuple4d containing the initialization x y z w data
      */
    public Tuple4d(Tuple4d t1) {
	set(t1);
    }

    /**
      * Constructs and initializes a Tuple4d from the specified Tuple4f.
      * @param t1 the Tuple4f containing the initialization x y z w data
      */
    public Tuple4d(Tuple4f t1) {
	set(t1);
    }

    /**
      * Constructs and initializes a Tuple4d to (0,0,0,0).
      */
    public Tuple4d() {
	x = 0.0;
	y = 0.0;
	z = 0.0;
	w = 0.0;
    }

    /**
      * Sets the value of this tuple to the specified xyzw coordinates.
      * @param x the x coordinate
      * @param y the y coordinate
      * @param z the z coordinate
      * @param w the w coordinate
      */
    public final void set(double x, double y, double z, double w) {
	this.x = x;
	this.y = y;
	this.z = z;
	this.w = w;
    }

    /**
      * Sets the value of this tuple from the 4 values specified in the array.
      * @param t the array of length 4 containing xyzw in order
      */
    public final void set(double t[]) {
	// ArrayIndexOutOfBounds is thrown if t.length < 4
	x = t[0];
	y = t[1];
	z = t[2];
	w = t[3];
    }

    /**
      * Sets the value of this tuple to the value of tuple t1.
      * @param t1 the tuple to be copied
      */
    public final void set(Tuple4d t1) {
	x = t1.x;
	y = t1.y;
	z = t1.z;
	w = t1.w;
    }

    /**
      * Sets the value of this tuple to the value of tuple t1.
      * @param t1 the tuple to be copied
      */
    public final void set(Tuple4f t1) {
	x = t1.x;
	y = t1.y;
	z = t1.z;
	w = t1.w;
    }

    /**
      * Copies the value of the elements of this tuple into the array t[]. 
      * @param t the array that will contain the values of the vector
      */
    public final void get(double t[]) {
	// ArrayIndexOutOfBounds is thrown if t.length < 4
	t[0] = x;
	t[1] = y;
	t[2] = z;
	t[3] = w;
    }

    /**
      * Gets the value of this tuple and copies the values into the Tuple4d.
      * @param t Tuple4d object into which that values of this object are copied
      */
    public final void get(Tuple4d t) {
	t.x = x;
	t.y = y;
	t.z = z;
	t.w = w;
    }

    /**
      * Sets the value of this tuple to the vector sum of tuples t1 and t2.
      * @param t1 the first tuple
      * @param t2 the second tuple
      */
    public final void add(Tuple4d t1, Tuple4d t2) {
	x = t1.x + t2.x;
	y = t1.y + t2.y;
	z = t1.z + t2.z;
	w = t1.w + t2.w;
    }

    /**
      * Sets the value of this tuple to the vector sum of itself and tuple t1.
      * @param t1  the other tuple
      */
    public final void add(Tuple4d t1) {
	x += t1.x;
	y += t1.y;
	z += t1.z;
	w += t1.w;
    }


    /**
      * Sets the value of this tuple to the vector difference of tuple t1 and t2 (this = t1 - t2).
      * @param t1 the first tuple
      * @param t2 the second tuple
      */
    public final void sub(Tuple4d t1, Tuple4d t2) {
	x = t1.x - t2.x;
	y = t1.y - t2.y;
	z = t1.z - t2.z;
	w = t1.w - t2.w;
    }

    /**
      * Sets the value of this tuple to the vector difference of itself and tuple t1 (this = this - t1).
      * @param t1 the other tuple
      */
    public final void sub(Tuple4d t1) {
	x -= t1.x;
	y -= t1.y;
	z -= t1.z;
	w -= t1.w;
    }

    /**
      * Sets the value of this tuple to the negation of tuple t1. 
      * @param t1 the source vector
      */
    public final void negate(Tuple4d t1) {
	x = -t1.x;
	y = -t1.y;
	z = -t1.z;
	w = -t1.w;
    }

    /**
      * Negates the value of this vector in place.
      */
    public final void negate() {
	x = -x;
	y = -y;
	z = -z;
	w = -w;
    }
      

    /**
      * Sets the value of this tuple to the scalar multiplication of tuple t1.
      * @param s the scalar value
      * @param t1 the source tuple
      */
    public final void scale(double s, Tuple4d t1) {
	x = s*t1.x;
	y = s*t1.y;
	z = s*t1.z;
	w = s*t1.w;
    }

    /**
      * Sets the value of this tuple to the scalar multiplication of itself.
      * @param s the scalar value
      */
    public final void scale(double s) {
	x *= s;
	y *= s;
	z *= s;
	w *= s;
    }

    /**
      * Sets the value of this tuple to the scalar multiplication of tuple t1 and then
      * adds tuple t2 (this = s*t1 + t2).
      * @param s the scalar value
      * @param t1 the tuple to be multipled
      * @param t2 the tuple to be added
      */
    public final void scaleAdd(double s, Tuple4d t1, Tuple4d t2) {
	x = s*t1.x + t2.x;
	y = s*t1.y + t2.y;
	z = s*t1.z + t2.z;
	w = s*t1.w + t2.w;
    }

    /**
      * Sets the value of this tuple to the scalar multiplication of itself and then
      * adds tuple t1 (this = s*this + t1).
      * @param s the scalar value
      * @param t1 the tuple to be added
      */
    public final void scaleAdd(double s, Tuple4d t1) {
	x = s*x + t1.x;
	y = s*y + t1.y;
	z = s*z + t1.z;
	w = s*z + t1.w;
    }

    /**
      * Returns a hash number based on the data values in this object. 
      * Two different Tuple4d objects with identical data  values
      * (ie, returns true for equals(Tuple4d) ) will return the same hash number.
      * Two vectors with different data members may return the same hash value,
      * although this is not likely.
      */
      public int hashCode() {
	  long xbits = Double.doubleToLongBits(x);
	  long ybits = Double.doubleToLongBits(y);
	  long zbits = Double.doubleToLongBits(z);
	  long wbits = Double.doubleToLongBits(w);
	  return (int)(xbits ^ (xbits >> 32) ^
		  ybits ^ (ybits >> 32) ^
		  zbits ^ (zbits >> 32) ^
		  wbits ^ (wbits >> 32));
      }

    /**
      * Returns true if all of the data members of Tuple4d t1 are equal to the corresponding
      * data members in this
      * @param t1 the vector with which the comparison is made.
      */
    public boolean equals(Tuple4d t1) {
	return t1 != null && x == t1.x && y == t1.y && z == t1.z && w == t1.w;
    }

    /**
      * Returns true if the L-infinite distance between this tuple and tuple t1 is
      * less than or equal to the epsilon parameter, otherwise returns false. The L-infinite
      * distance is equal to MAX[abs(x1-x2), abs(y1-y2), abs(z1-z2), abs(w1-w2)].
      * @param t1 the tuple to be compared to this tuple
      * @param epsilon the threshold value
      */
    public boolean epsilonEquals(Tuple4d t1, double epsilon) {
	return (Math.abs(t1.x - this.x) <= epsilon) &&
	    (Math.abs(t1.y - this.y) <= epsilon) &&
	    (Math.abs(t1.z - this.z) <= epsilon) &&
	    (Math.abs(t1.w - this.w) <= epsilon);
    }

    /**
      * Returns a string that contains the values of this Tuple4d. The form is (x,y,z,w).
      * @return the String representation
      */
    public String toString() {
	    return "(" + x + ", " + y + ", " + z +", " + w + ")";
    }

    /**
      * Clamps the tuple parameter to the range [low, high] and places the values
      * into this tuple.
      * @param min the lowest value in the tuple after clamping
      * @param max the highest value in the tuple after clamping
      * @param t the source tuple, which will not be modified
      */
    public final void clamp(double min, double max, Tuple4d t) {
	set(t);
	clamp(min, max);
    }
      
    /**
      * Clamps the minimum value of the tuple parameter to the min parameter
      * and places the values into this tuple.
      * @param min the lowest value in the tuple after clamping
      * @parm t the source tuple, which will not be modified
      */
    public final void clampMin(double min, Tuple4d t) {
	set(t);
	clampMin(min);
    }

    /**
      * Clamps the maximum value of the tuple parameter to the max parameter and
      * places the values into this tuple.
      * @param max the highest value in the tuple after clamping
      * @param t the source tuple, which will not be modified
      */
    public final void clampMax(double max, Tuple4d t) {
	set(t);
	clampMax(max);
    }
      

    /**
      * Sets each component of the tuple parameter to its absolute value and
      * places the modified values into this tuple.
      * @param t the source tuple, which will not be modified
      */
    public final void absolute(Tuple4d t) {
	set(t);
	absolute();
    }

    /**
      * Clamps this tuple to the range [low, high].
      * @param min the lowest value in this tuple after clamping
      * @param max the highest value in this tuple after clamping
      */
    public final void clamp(double min, double max) {
	clampMin(min);
	clampMax(max);
    }

    /**
      * Clamps the minimum value of this tuple to the min parameter.
      * @param min the lowest value in this tuple after clamping
      */
    public final void clampMin(double min) {
	if (x < min)
	    x = min;
	if (y < min)
	    y = min;
	if (z < min)
	    z = min;
	if (w < min)
	    w = min;
    }

    /**
      * Clamps the maximum value of this tuple to the max parameter.
      * @param max the highest value in the tuple after clamping
      */
    public final void clampMax(double max) {
	if (x > max)
	    x = max;
	if (y > max)
	    y = max;
	if (z > max)
	    z = max;
	if (w > max)
	    w = max;
    }

    /**
      * Sets each component of this tuple to its absolute value.
      */
    public final void absolute() {
	if (x < 0.0)
	    x = -x;
	if (y < 0.0)
	    y = -y;
	if (z < 0.0)
	    z = -z;
	if (w < 0.0)
	    w = -w;
    }

    /**
      * Linearly interpolates between tuples t1 and t2 and places the
      * result into this tuple: this = (1-alpha)*t1 + alpha*t2.
      * @param t1 the first tuple
      * @param t2 the second tuple
      * @param alpha the alpha interpolation parameter
      */
    public final void interpolate(Tuple4d t1, Tuple4d t2, double alpha) {
	set(t1);
	interpolate(t2, alpha);
    }


    /**
      * Linearly interpolates between this tuple and tuple t1 and places the
      * result into this tuple: this = (1-alpha)*this + alpha*t1.
      * @param t1 the first tuple
      * @param alpha the alpha interpolation parameter
      *
      */
    public final void interpolate(Tuple4d t1, double alpha) {
	double beta = 1 - alpha;
	x = beta*x + alpha*t1.x;
	y = beta*y + alpha*t1.y;
	z = beta*z + alpha*t1.z;
	w = beta*w + alpha*t1.w;
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

    public double getW()
    {
        return w;
    }

    public void setW(double w)
    {
        this.w = w;
    }
}
