package fr.diginamic.banque.service;

import java.util.Set;

public class ListService {
    public static boolean isNullAfterRemove(Set list){
        return list.size() <= 1;
    }
}
