package com.example.proiectjavacoolapp.controller;

import com.example.proiectjavacoolapp.model.*;
import com.example.proiectjavacoolapp.service.CoolCompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CoolCompanyController {

    private final CoolCompanyService coolCompanyService;

    public CoolCompanyController(CoolCompanyService coolCompanyService){
        this.coolCompanyService = coolCompanyService;
    }

    @PostMapping("/contactdata/new")
    public ResponseEntity<ContactData> saveNewContactData(@Valid @RequestBody ContactData contactData){
            return ResponseEntity.ok()
                    .body(coolCompanyService.saveNewContactData(contactData));
    }

    @PostMapping("/cookedfood/new")
    public ResponseEntity<CookedFood> saveNewCookedFood(@Valid @RequestBody CookedFood cookedFood){
        return ResponseEntity.ok().body(coolCompanyService.saveNewCookedFood(cookedFood));
    }

    @PostMapping("/drink/new")
    public ResponseEntity<Drink> saveNewDrink(@Valid @RequestBody Drink drink){
        return ResponseEntity.ok().body(coolCompanyService.saveNewDrink(drink));
    }

    @PostMapping("/coolcompany/new")
    public ResponseEntity<CoolCompany> saveNewCoolCompany(@Valid @RequestBody CoolCompany coolCompany, @RequestParam int contactDataId){
        return ResponseEntity.ok()
                .body(coolCompanyService.saveNewCoolCompany(coolCompany, contactDataId));
    }

    @PostMapping("/menu/new")
    public ResponseEntity<Menu> saveNewMenu(@Valid @RequestBody Menu menu, @RequestParam List<Integer> drinkIds, @RequestParam List<Integer> cookedFoodIds){
        return ResponseEntity.ok().body(coolCompanyService.saveNewMenu(menu, drinkIds, cookedFoodIds));
    }

    @PostMapping("/employee/new")
    public ResponseEntity<Employee> saveNewEmployee(@Valid @RequestBody Employee employee, @RequestParam int contactDataId, @RequestParam int restaurantId){
        return ResponseEntity.ok().body(coolCompanyService.saveNewEmployee(employee, contactDataId, restaurantId));
    }

    @PostMapping("/restaurant/new")
    public ResponseEntity<Restaurant> saveNewRestaurant(@Valid @RequestBody Restaurant restaurant, @RequestParam int companyId, @RequestParam int contactDataId, @RequestParam int menuId){
        return ResponseEntity.ok()
                .body(coolCompanyService.saveNewRestaurant(restaurant, companyId, contactDataId, menuId));
    }

    @GetMapping("/name/restaurants")
    public ResponseEntity<List<Restaurant>> retriveCompanyNameRestaurants(@RequestParam String companyName) {
        return ResponseEntity.ok()
                .body(coolCompanyService.retriveCompanyNameRestaurants(companyName));
    }

    @GetMapping("/name/employees/salalry/under")
    public ResponseEntity<List<Employee>> retriveCompanyAllEmployeesSalaryUnder(@RequestParam String companyName, @RequestParam int salary) {
        return ResponseEntity.ok()
                .body(coolCompanyService.retriveCompanyAllEmployeesSalaryUnder(companyName, salary));
    }

    @PostMapping("/drinks/sold/{drinkId}")
    public ResponseEntity<String> buyDrink(@PathVariable int drinkId){
        Drink drink = coolCompanyService.buyDrink(drinkId);
        return ResponseEntity.ok().body("Ai cumparat " + 1 + " produs si mai ai in stoc " + drink.getQuantity());
    }

    @PostMapping("/drink/newStock")
    public ResponseEntity<Drink> updateQuantity(@RequestParam int drinkId, @RequestParam int quantity){
        Drink drink = coolCompanyService.updateQuantity(drinkId, quantity);
        return ResponseEntity.ok().body(drink);
    }
}
