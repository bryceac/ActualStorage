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

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog; // import for Dialog boxes
import android.content.*; // import for Dialog interface
import android.widget.*;
import android.view.*;
import android.net.*; // import to open browser
import java.text.*; // import Java class to format output
public class ActualStorageActivity extends Activity
{

	Spinner selection, math; /* declare variable, in order to control spinner (ComboBox) */
	ArrayAdapter adapter, madapter; /* declare an array adapter object, in order for spinner to work */
	EditText size; /* declare variable to control textfield */
	EditText result; /* declare variable to control textfield */
	Button calculate; /* declare variable to control button */
	Storage capacity = new Storage(); /* import custom class for formulas */
	String unit; /* declare variable to hold unit of measure */

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // load content from XML
        
    math = (Spinner)findViewById(R.id.mspinner); // load math spinner
    madapter = ArrayAdapter.createFromResource(this, R.array.math_array, android.R.layout.simple_spinner_dropdown_item); /* load adapter for math */
	selection = (Spinner)findViewById(R.id.spinner); // load spinner
	adapter = ArrayAdapter.createFromResource(this, R.array.choices_array, android.R.layout.simple_spinner_dropdown_item); /* load adapter for spinner */
	size = (EditText)findViewById(R.id.size); // load textfield
	result = (EditText)findViewById(R.id.result); // load textfield
	calculate = (Button)findViewById(R.id.submit); // load textfield

	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // load spinner drop down
	madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // load spinner drop down

	selection.setAdapter(adapter); // assign adapter to spinner
	math.setAdapter(madapter); // assign adapter to new spinner

	result.setEnabled(false); // make result field read-only

	}

	public void calcAction(View v) 
	{			
		/* the following code is used to prevent application from crashing due to empty field for initial storage capacity */
		try
		{
			String type = math.getSelectedItem().toString(); // get type of math
			String initial = size.getText().toString(); /* the following gets user input, in order to do calculations */
			String end = "Nothing"; /* This is the default text in case the unexpected happens */
			unit = selection.getSelectedItem().toString(); /* this gets the unit of measure that the user specifies */
		double convert = Double.parseDouble(initial); /* this converts the size input to numerical data, in order for calculations to be done */
			capacity.setStorage(convert); /* send input to external class */
			DecimalFormat twop = new DecimalFormat("#.##"); /* created new object, in order to format output to display two decimal places at most */

			/* the following conditional statement reads the unit of measure specify by the user, puts the data into the proper formula, and returns the results, based on kind of calculation */

			if (type.equals("Box"))
			{
				if (unit.equals("KB")) // runs if user specifies KB
				{
					end = twop.format(capacity.getiKB());
				}

				else if (unit.equals("MB")) /* runs if user specifies MB */
				{
					end = twop.format(capacity.getiMB());
				}

				else if (unit.equals("GB")) /* runs if user specifies GB */
				{
					end = twop.format(capacity.getiGB());
				}

				else if (unit.equals("TB")) /* runs if user specifies TB */
				{
					end = twop.format(capacity.getiTB());
				}

				else if (unit.equals("PB")) /* runs if user specifies PB */
				{
					end = twop.format(capacity.getiPB());
				}

				else if (unit.equals("EB")) /* runs if user specifies EB */
				{
					end = twop.format(capacity.getiEB());
				}

				else if (unit.equals("ZB")) /* runs if user specifies ZB */
				{
					end = twop.format(capacity.getiZB());
				}

				else if (unit.equals("YB")) /* runs if user specifies YB */
				{
					end = twop.format(capacity.getiYB());
				}

				else; // send default text, if unexpected happens.

				result.setText(end); // display results
			}
			else
			{
				if (unit.equals("KB")) // runs if user specifies KB
				{
					end = twop.format(capacity.getKB());
				}

				else if (unit.equals("MB")) /* runs if user specifies MB */
				{
					end = twop.format(capacity.getMB());
				}

				else if (unit.equals("GB")) /* runs if user specifies GB */
				{
					end = twop.format(capacity.getGB());
				}

				else if (unit.equals("TB")) /* runs if user specifies TB */
				{
					end = twop.format(capacity.getTB());
				}

				else if (unit.equals("PB")) /* runs if user specifies PB */
				{
					end = twop.format(capacity.getPB());
				}

				else if (unit.equals("EB")) /* runs if user specifies EB */
				{
					end = twop.format(capacity.getEB());
				}

				else if (unit.equals("ZB")) /* runs if user specifies ZB */
				{
					end = twop.format(capacity.getZB());
				}

				else if (unit.equals("YB")) /* runs if user specifies YB */
				{
					end = twop.format(capacity.getYB());
				}

				else; // send default text, if unexpected happens.

				result.setText(end); // display results
			}
		}

		catch (NumberFormatException e)
		{
			AlertDialog.Builder m = new AlertDialog.Builder(this);
			m.setTitle(R.string.error); // set dialog title
			m.setMessage(R.string.error_message).setCancelable(true).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialog, int id)
				{
					dialog.cancel();
				}
			});
			m.create();
			m.show();
		}	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.app_menu, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// handle item selection
		 switch (item.getItemId())
		{
			case R.id.license:
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dl.dropbox.com/u/332246/LICENSE.txt"));
				startActivity(i);
				return true;
			case R.id.contact:
				Intent c = new Intent(Intent.ACTION_SEND);
				c.setType("plain/text");
				c.putExtra(android.content.Intent.EXTRA_EMAIL, "android@brycecampbell.me");
				startActivity(Intent.createChooser(c, "Contact Developer..."));
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}