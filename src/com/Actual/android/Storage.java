/*
*Copyright (c) 2011 Bryce Campbell

*Permission is hereby granted, free of charge, to any person obtaining a *copy of this software and associated documentation files (the "Software"), *to deal in the Software without restriction, including without limitation *the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

*The above copyright notice and this permission notice shall be included in
*all copies or substantial portions of the Software.

*THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL *THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING *FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER *DEALINGS IN THE SOFTWARE.
*/

package com.Actual.android;

/**
*  The Storage class contains methods
*  that calculate the actual storage cacpacity
*  of secondary storage devices, without taking
*  Filesystems into account.
*/

public class Storage
{
	double ListedStorage;

	/**
	*  The setStorage method accepts an argument stored in the 		*  ListedStorage field.
	*/ 
	public void setStorage(double store)
	{
		ListedStorage = store;
	}

	/**
	*  The getStorage method returns the value of the value stored in
	*  the ListedStorage field.
	*/
	public double getStorage()
	{
		return ListedStorage;
	}

	/**
	*  The getKB method calculates the actual storage
	*  in the Kilobytes unit by dividing the product of the
	*  ListedStorage field and 1,000 by 1024.
	*/
	public double getKB()
	{
		return (ListedStorage * 1000)/1024;
	}

	/**
	*  The getMB method calculates the actual storage
	*  in the Megabytes unit by dividing the product of the
	*  ListedStorage field and 1,000^2 by 1024^2.
	*/
	public double getMB()
	{
		return (ListedStorage * Math.pow(1000, 2))/Math.pow(1024, 2);
	}

	/**
	*  The getGB method calculates the actual storage
	*  in the Gigabytes unit by dividing the product of the
	*  ListedStorage field and 1,000^3 by 1024^3.
	*/
	public double getGB()
	{
		return (ListedStorage * Math.pow(1000, 3))/Math.pow(1024, 3);
	}

	/**
	*  The getTB method calculates the actual storage
	*  in the Terabytes unit by dividing the product of the
	*  ListedStorage field and 1,000^4 by 1024^4.
	*/
	public double getTB()
	{
		return (ListedStorage * Math.pow(1000, 4))/Math.pow(1024, 4);
	}

	/**
	*  The getPB method calculates the actual storage
	*  in the Petabytes unit by dividing the product of the
	*  ListedStorage field and 1,000^5 by 1024^5.
	*/
	public double getPB()
	{
		return (ListedStorage * Math.pow(1000, 5))/Math.pow(1024, 5);
	}

	/**
	*  The getEB method calculates the actual storage
	*  in the Exabytes unit by dividing the product of the
	*  ListedStorage field and 1,000^6 by 1024^6.
	*/
	public double getEB()
	{
		return (ListedStorage * Math.pow(1000, 6))/Math.pow(1024, 6);
	}

	/**
	*  The getZB method calculates the actual storage
	*  in the Zetabytes unit by dividing the product of the
	*  ListedStorage field and 1,000^7 by 1024^7.
	*/
	public double getZB()
	{
		return (ListedStorage * Math.pow(1000, 7))/Math.pow(1024, 7);
	}

	/**
	*  The getYB method calculates the actual storage
	*  in the Yottabytes unit by dividing the product of the
	*  ListedStorage field and 1,000^8 by 1024^8.
	*/
	public double getYB()
	{
		return (ListedStorage * Math.pow(1000, 8))/Math.pow(1024, 8);
	}
}