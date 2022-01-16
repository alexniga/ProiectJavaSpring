# Proiect Java Spring : "Cool Company"

![This is an image](https://github.com/alexniga/ProiectJavaSpring/blob/main/CoolCompanyJavaProject2.png)

# Description

- The project is about a company that manages a number of restaurants.
- The company is saved in a table that contains usual data about it(name, contact data, cui) and a list of restaurants.
  A relation of one to many between the company and the restaurnats and a one to one relation with the ContactData.
- The restaurants have a name, a list of employees, a menu and contact data. An employee can work only at a restaurant(
  we have a one to many relation between restaurant and employees) and it has only one menu(one to one relation).
- The employees have only generic data and contact data with a one to one relationship.
- The menu has cooked food and drinks. Multiple menus can have multimple cooked food and drinks, so we have a
  relationship of many to many between food and menu and menu with drinks.
- The food contains generic informations like name, price and ingredient.
- The drinks contains a name, a price and a quantity. If the quantity drops under n * 10, where n is the number of
  restaurants, we will notify the restaurnats.

# What the app can do?
- Adds any of the entities in the database
- Retrives the restaurants of a company by the company name
- Retrives all employees of the company with a salary lower then a salary bound, by the company name 