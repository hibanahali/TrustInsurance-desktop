/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


/**
 *
 * @author acer hiba
 */
public class DateCon {

    public static java.sql.Date cDate(String d) {
        java.util.Date d1 ;
        d1 = new java.util.Date(d);
        java.sql.Date d2 = new java.sql.Date(d1.getTime());
        return d2;
    }
}
