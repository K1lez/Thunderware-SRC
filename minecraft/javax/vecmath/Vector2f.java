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
  * A 2 element vector that is represented by single precision
  * floating point x,y coordinates.
  * @version specification 1.1, implementation $Revision: 1.9 $, $Date: 1999/10/05 07:03:50 $
  * @author Kenji hiranabe
  */
public class Vector2f extends Tuple2f implements Serializable {
/*
 * $Log: Vector2f.java,v $
 * Revision 1.9  1999/10/05  07:03:50  hiranabe
 * copyright change
 *
 * Revision 1.9  1999/10/05  07:03:50  hiranabe
 * copyright change
 *
 * Revision 1.8  1999/03/04  09:16:33  hiranabe
 * small bug fix and copyright change
 *
 * Revision 1.7  1998/10/14  00:49:10  hiranabe
 * API1.1 Beta02
 *
 * Revision 1.6  1998/07/27  04:28:13  hiranabe
 * API1.1Alpha01 ->API1.1Alpha03
 *
 * Revision 1.5  1998/04/10  04:52:14  hiranabe
 * API1.0 -> API1.1 (added constructors, methods)
 *
 * Revision 1.4  1998/04/09  08:18:15  hiranabe
 * minor comment change
 *
 * Revision 1.3  1998/04/09  07:05:18  hiranabe
 * API 1.1
 *
 * Revision 1.2  1998/01/05  06:29:31  hiranabe
 * copyright 98
 *
 * Revision 1.1  1997/11/26  03:00:44  hiranabe
 * Initial revision
 *
 */


    /**
      * Constructs and initializes a Vector2f from the specified xy coordinates.
      * @param x the x coordinate
      * @param y the y coordinate
      */
    public Vector2f(float x, float y) {
	super(x, y);
    }

    /**
      * Constructs and initializes a Vector2f from the specified array.
      * @param v the array of length 2 containing xy in order
      */
    public Vector2f(float v[]) {
	super(v);
    }

    /**
      * Constructs and initializes a Vector2f from the specified Vector2f.
      * @param v1 the Vector2f containing the initialization x y data
      */
    public Vector2f(Vector2f v1) {
	super(v1);
    }

    /**
      * Constructs and initializes a Vector2f from the specified Vector2d.
      * @param v1 the Vector2f containing the initialization x y data
      */
    public Vector2f(Vector2d v1) {
	super(v1);
    }

    /**
      * Constructs and initializes a Vector2f from the specified Tuple2f.
      * @param t1 the Tuple2f containing the initialization x y data
      */
    public Vector2f(Tuple2f t1) {
	super(t1);
    }

    /**
      * Constructs and initializes a Vector2f from the specified Tuple2d.
      * @param t1 the Tuple2d containing the initialization x y data
      */
    public Vector2f(Tuple2d t1) {
	super(t1);
    }

    /**
      * Constructs and initializes a Vector2f to (0,0).
      */
    public Vector2f() {
	super();
    }

    /**
      * Computes the dot product of the this vector and vector v1.
      * @param  v1 the other vector
      */
    public final float dot(Vector2f v1) {
	return x*v1.x + y*v1.y;
    }

    /**
      * Returns the length of this vector.
      * @return the length of this vector
      */
    public final float length() {
	return (float)Math.sqrt(x*x + y*y);
    }

    /**
      * Returns the squared length of this vector.
      * @return the squared length of this vector
      */
    public final float lengthSquared() {
	return x*x + y*y;
    }

    /**
      * Normalizes this vector in place.
      */
    public final void normalize() {
	double d = length();

	// zero-div may occur.
	x /= d;
	y /= d;
    }

    /**
      * Sets the value of this vector to the normalization of vector v1.
      * @param v1 the un-normalized vector
      */
    public final void normalize(Vector2f v1) {
	set(v1);
	normalize();
    }

    /**
      * Returns the angle in radians between this vector and
      * the vector parameter; the return value is constrained to the
      * range [0,PI].
      * @param v1  the other vector
      * @return the angle in radians in the range [0,PI]
      */
    public final float angle(Vector2f v1) {
	// stabler than acos
	return (float)Math.abs(Math.atan2(x*v1.y - y*v1.x , dot(v1)));
    }
}
