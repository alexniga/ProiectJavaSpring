package com.example.proiectjavacoolapp.service;

import com.example.proiectjavacoolapp.model.*;
import com.example.proiectjavacoolapp.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoolCompanyService {

    private final ContactDataRepository contactDataRepository;
    private final CookedFoodRepository cookedFoodRepository;
    private final CoolCompanyRepository coolCompanyRepository;
    private final DrinkRepository drinkRepository;
    private final EmployeeRepository employeeRepository;
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;


    public CoolCompanyService(ContactDataRepository contactDataRepository, CookedFoodRepository cookedFoodRepository, CoolCompanyRepository coolCompanyRepository, DrinkRepository drinkRepository, EmployeeRepository employeeRepository, MenuRepository menuRepository, RestaurantRepository restaurantRepository){
        this.contactDataRepository = contactDataRepository;
        this.cookedFoodRepository = cookedFoodRepository;
        this.coolCompanyRepository = coolCompanyRepository;
        this.drinkRepository = drinkRepository;
        this.employeeRepository = employeeRepository;
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public ContactData saveNewContactData(ContactData contactData) {
        return contactDataRepository.save(contactData);
    }

    public CookedFood saveNewCookedFood(CookedFood cookedFood) {
        return cookedFoodRepository.save(cookedFood);
    }

    public Drink saveNewDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    public CoolCompany saveNewCoolCompany(CoolCompany coolCompany, int contactDataId) {
        ContactData contactData = contactDataRepository.findById(contactDataId)
                        .orElseThrow(() -> new RuntimeException("Data respectiva de contact nu exista pentru companie"));
        coolCompany.setContactData(contactData);
        
        return coolCompanyRepository.save(coolCompany);
    }

    public Menu saveNewMenu(Menu menu, List<Integer> drinkIds, List<Integer> cookedFoodIds) {
        List<Drink> drinks = drinkRepository.findAllById(drinkIds);
        List<CookedFood> cookedFoods = cookedFoodRepository.findAllById(cookedFoodIds);
        menu.setDrinkList(drinks);
        menu.setCookedFoodList(cookedFoods);

        return menuRepository.save(menu);
    }

    public Restaurant saveNewRestaurant(Restaurant restaurant, int companyId, int contactDataId, int menuId){
        CoolCompany coolCompany = coolCompanyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Nu exista nici o companie cu id-ul respectiv"));
        ContactData contactData = contactDataRepository.findById(contactDataId)
                .orElseThrow(() -> new RuntimeException("Data respectiva de contact nu exista pentru restaurant"));
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Nu exista nici un meniu cu id-ul respectiv"));

        restaurant.setCompany(coolCompany);
        restaurant.setContactData(contactData);
        restaurant.setMenu(menu);

        return restaurantRepository.save(restaurant);
    }

    public Employee saveNewEmployee(Employee employee, int contactDataId, int restaurantId) {
        ContactData contactData = contactDataRepository.findById(contactDataId)
                .orElseThrow(() -> new RuntimeException("Data de conntact pentru angajat nu exista"));
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()-> new RuntimeException("Id-ul restaurantului nu exista!"));

        employee.setContactData(contactData);
        employee.setRestaurant(restaurant);

        return employeeRepository.save(employee);
    }
}
