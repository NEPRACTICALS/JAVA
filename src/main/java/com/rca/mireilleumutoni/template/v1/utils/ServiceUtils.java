package com.rca.mireilleumutoni.template.v1.utils;


import com.rca.mireilleumutoni.template.v1.enums.EVisibility;
import com.rca.mireilleumutoni.template.v1.models.User;

public class ServiceUtils {
    // method to check if a user is valid or deleted
    public static boolean isUserDeleted(User user) {
        return user.getVisibility().equals(EVisibility.VOIDED);
    }
}
