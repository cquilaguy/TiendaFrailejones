/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendafrailejones.utils;

/**
 *
 * @author alan
 */
public class DataUser {

    private static String idUser;

    public DataUser() {
    }

    public void setIdUser(String idUser) {
        DataUser.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public static DataUser getDataUser() {
        return new DataUser();
    }

}
