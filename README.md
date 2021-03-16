# customer-delivery-service


If Customers in our Store order they want to know when the expected delivery date is. The expected delivery date depends on certain conditions:

Which Carrier is selected. Each Carrier has different delivery days DHL for example needs 2 days, Hermes needs 3 days.
		- Factory design pattern


The cut-off hour in the warehouse, after this time, a parcel is not shipped on this day anymore.



The working times in the warehouse. Our warehouse only works from Monday to Friday.
	- Separate method
		- Input: Date
		- Output: days(Integer)


Public Holidays, in Germany we have a lot of common public holidays but Berlin has some special holidays.
	- Decorator design pattern
	- With Factory Pattern


So the challenge is, please provide us with a function, where we can fill in the current time and a provider and get returned the expected delivery date.

The configuration for different carriers is free to choose.
For the given test data, we assume cut-off-time: 12 and delivery days: 2


{"actual datetime", "expected delivery date"}
{"2020-02-14T09:21:38+00:00", "2020-02-18"},
{"2020-03-30T09:21:38+00:00", "2020-04-01"},
{"2020-03-30T10:21:38+00:00", "2020-04-01"},
{"2020-03-30T11:21:38+00:00", "2020-04-02"},
{"2020-04-01T11:21:38+00:00", "2020-04-04"},
{"2020-04-03T09:21:38+00:00", "2020-04-07"},
{"2020-04-03T11:21:38+00:00", "2020-04-08"},
{"2020-01-01T11:21:38+00:00", "2020-01-04"}, // new year
{"2020-04-10T11:21:38+00:00", "2020-04-16"}, // good friday
{"2020-04-13T11:21:38+00:00", "2020-04-16"}, // easter monday
{"2020-05-01T11:21:38+00:00", "2020-05-06"}, // labour day

You are free to extend the test data with more cases for you to test. You can work in any language or framework you would like. A nice to have, provide a http endpoint for this. 

Please let us know if you have any questions and we look forward to your results!
