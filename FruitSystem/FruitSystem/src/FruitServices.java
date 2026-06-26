package com.acc.services;

import java.util.List;

import com.acc.exc.RecordNotFoundException;
import com.fruit.Fruit;
public interface FruitServices {
    public void add(); 
    public List <Fruit> findAll();
    public void delete();
    public void update(); 
    public Fruit serach() throws RecordNotFoundException;
    public void exit1();
}
