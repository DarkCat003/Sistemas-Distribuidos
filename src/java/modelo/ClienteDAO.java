package modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ClienteDAO implements CRUD{
PreparedStatement ps;
ResultSet rs;
Connection con;
Conexion conex=new Conexion();
int res;
String msg;
Cliente c=new Cliente();
@Override
public List listar() {
List<Cliente> datos=new ArrayList<>();
String sql="select * from clientes";
try {
con = conex.getConnection();
ps=(PreparedStatement) con.prepareStatement(sql);
rs=ps.executeQuery();
while (rs.next()) {
Cliente c= new Cliente();
c.setId(rs.getInt("id"));
c.setNombre(rs.getString("nombre"));
c.setDireccion(rs.getString("direccion"));
c.setEstado(rs.getInt("estado"));
datos.add(c);
}
} catch (Exception e) {
}
return datos;
}

public Cliente listarID(int id) {
String sql="select * from clientes where id="+id;
try {
con = conex.getConnection();
ps=(PreparedStatement) con.prepareStatement(sql);
rs=ps.executeQuery();
while (rs.next()) {
c.setId(rs.getInt("id"));
c.setNombre(rs.getString("nombre"));
c.setDireccion(rs.getString("direccion"));
c.setEstado(rs.getInt("estado"));
}
}
catch (Exception e) {
e.printStackTrace();
}
return c;
}
@Override
public String add(String nombre, String direccion, int estado) {
String sql="insert into clientes(nombre,direccion,estado) values(?,?,?)";
try {
con=conex.getConnection();
ps=con.prepareStatement(sql);
ps.setString(1,nombre);
ps.setString(2,direccion);
ps.setInt(3,estado);
res=ps.executeUpdate();
if (res==1){
msg="Usuario Agregado";
}else {
msg="Usuario no fue Agregado";
}
} catch (Exception e) {
//e.println("Error"+e.getMessage());
e.printStackTrace();
}
return msg;
}
@Override
public String edit(int id, String nombre, String direccion, int estado) {
String sql="update clientes set nombre=?,direccion=?,estado=? where id="+id;
try {
con=conex.getConnection();
ps=con.prepareStatement(sql);
ps.setString(1,nombre);
ps.setString(2,direccion);
ps.setInt(3,estado);
res=ps.executeUpdate();
if (res==1){
msg="Usuario Actualizado";
}else {
msg="Usuario no Actualizado";
}
} catch (Exception e) {
e.printStackTrace();
}
return msg;
}
public Cliente delete(int id) {
String sql="delete from clientes where id="+id;
try {
con=conex.getConnection();
ps=con.prepareStatement(sql);
res=ps.executeUpdate();
} catch (Exception e) {
}
return c;
}

    @Override
    public Cliente delet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}