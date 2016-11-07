package Models;

import Controllers.cContacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class mContacto {
    private conexionDB mysql = new conexionDB();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel listar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id", "Nombre", "Apellido", "Alías", "Teléfono 1", "Teléfono 2", "Email 1", "Email 2", "Grupo"};

        String[] registro = new String[9];

        totalRegistros = 0;
        //Se hacen las celdas de las tablas no editables
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        sSQL = "SELECT * FROM contacto WHERE nombre LIKE '%"+ buscar +"%' "
                + "OR apellido LIKE '%"+ buscar +"%' "
                + "OR alias LIKE '%"+ buscar +"%' "
                + "OR telefono1 LIKE '%"+ buscar +"%' "
                + "OR telefono2 LIKE '%"+ buscar +"%' "
                + "ORDER BY id_contacto DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id_contacto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("alias");
                registro[4] = rs.getString("telefono1");
                registro[5] = rs.getString("telefono2");
                registro[6] = rs.getString("email1");
                registro[7] = rs.getString("email2");
                registro[8] = rs.getString("grupo");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel listarGrupo(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id", "Nombre", "Apellido", "Alías", "Teléfono 1", "Teléfono 2", "Email 1", "Email 2", "Grupo"};

        String[] registro = new String[9];

        totalRegistros = 0;
        //Se hacen las celdas de las tablas no editables
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        sSQL = "SELECT * FROM contacto WHERE grupo LIKE '%"+ buscar +"%' "
                + "ORDER BY id_contacto DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id_contacto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("alias");
                registro[4] = rs.getString("telefono1");
                registro[5] = rs.getString("telefono2");
                registro[6] = rs.getString("email1");
                registro[7] = rs.getString("email2");
                registro[8] = rs.getString("grupo");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
        
    public boolean crear(cContacto dts) {
        sSQL = "INSERT INTO contacto (nombre, apellido, alias, telefono1, telefono2, email1, email2, grupo) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getAlias());
            pst.setString(4, dts.getTelefono1());
            pst.setString(5, dts.getTelefono2());
            pst.setString(6, dts.getEmail1());
            pst.setString(7, dts.getEmail2());
            pst.setString(8, dts.getGrupo());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(cContacto dts) {
        sSQL = "UPDATE contacto SET nombre=?, apellido=?, alias=?, telefono1=?, telefono2=?, email1=?, email2=?, grupo=? "
                + "WHERE id_contacto=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getAlias());
            pst.setString(4, dts.getTelefono1());
            pst.setString(5, dts.getTelefono2());
            pst.setString(6, dts.getEmail1());
            pst.setString(7, dts.getEmail2());
            pst.setString(8, dts.getGrupo());
            pst.setInt(9, dts.getId_contacto());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(cContacto dts) {
        sSQL = "DELETE FROM contacto WHERE id_contacto=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_contacto());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}