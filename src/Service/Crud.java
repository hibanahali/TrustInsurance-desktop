/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author acer hiba
 */
public interface Crud <T> {
    void insert(T t);
    void delete(T t);
    void Update(T t);
    List<T> getShow();
    T getelement(String t);
}
