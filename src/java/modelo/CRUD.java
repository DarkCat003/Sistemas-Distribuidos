package modelo;

import java.util.List;

public interface CRUD {
    public List listar();
    public Cliente listarID(int id);
    public String add(String nombre, String direccion, int estado);
    public String edit(int id, String nombre, String direccion, int estado);
    public Cliente delet(int id);
}