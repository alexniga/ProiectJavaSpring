package com.example.proiectjavacoolapp.service;

import com.example.proiectjavacoolapp.model.*;
import com.example.proiectjavacoolapp.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CoolCompanyTest {

    @InjectMocks
    private CoolCompanyService coolCompanyService;

    @Mock
    private  ContactDataRepository contactDataRepository;
    @Mock
    private  CookedFoodRepository cookedFoodRepository;
    @Mock
    private  CoolCompanyRepository coolCompanyRepository;
    @Mock
    private  DrinkRepository drinkRepository;
    @Mock
    private  EmployeeRepository employeeRepository;
    @Mock
    private  MenuRepository menuRepository;
    @Mock
    private  RestaurantRepository restaurantRepository;

    @Test
    @DisplayName("Save contact data test")
    void saveNewContactDataFlow() {
        ContactData contactData = new ContactData("0222222","Strada X", "www.w.w");

        when(contactDataRepository.save(contactData)).thenReturn(contactData);

        ContactData result = coolCompanyService.saveNewContactData(contactData);

        assertEquals(result.getAdress(), contactData.getAdress());
        assertEquals(result.getPhoneNumber(), contactData.getPhoneNumber());
        assertEquals(result.getWebsite(), contactData.getWebsite());

    }

    @Test
    @DisplayName("Save new menu test")
    void saveNewEmployeeFlow() {
        Drink drink1 = new Drink("Suc1", 10, 70);
        Drink drink2 = new Drink("Suc2", 10, 70);
        List<Drink> drinkList = new ArrayList<Drink>();
        drinkList.add(drink1);
        drinkList.add(drink2);
        List<Integer> drinkIds = new ArrayList<>();
        drinkIds.add(1);

        CookedFood food1 = new CookedFood("mancare 1", 10, "apa");
        CookedFood food2 = new CookedFood("Mancare 2", 10, "oua");
        List<CookedFood> cookedFoodList = new ArrayList<CookedFood>();
        cookedFoodList.add(food1);
        cookedFoodList.add(food2);
        List<Integer> cookedIds = new ArrayList<>();
        cookedIds.add(1);

        Menu menu = new Menu(cookedFoodList, drinkList);

        when(drinkRepository.findAllById(drinkIds)).thenReturn(drinkList);
        when(cookedFoodRepository.findAllById(cookedIds)).thenReturn(cookedFoodList);
        when(menuRepository.save(menu)).thenReturn(menu);

        Menu result = coolCompanyService.saveNewMenu(menu, drinkIds, cookedIds);

        assertEquals(result.getCookedFoodList(), cookedFoodList);
        assertEquals(result.getDrinkList(), drinkList);


    }

    @Test
    @DisplayName("Test buy a drink")
    void buyDrinkFlow() {
        Drink drink = new Drink("Suc", 10, 70);
        Drink drink1 = new Drink("Suc", 10, 69);
        int drinkId = 1;
        when(drinkRepository.findById(drinkId)).thenReturn(Optional.of(drink1));
        when(drinkRepository.save(drink1)).thenReturn(drink1);

        Drink result = coolCompanyService.buyDrink(drinkId);

        assertEquals(result.getQuantity(), drink1.getQuantity());

    }


}
