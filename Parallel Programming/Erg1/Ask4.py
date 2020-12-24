import calendar

yearly_income = int(input("What's you yearly income? "))
current_year = int(input("What year do you want me to calculate your daily income in? "))

calendar.isleap(current_year)

if (calendar.isleap(current_year)) :
    daily_income = yearly_income/366
else:
    daily_income = yearly_income/365

print("Your daily income is ", daily_income,"€")