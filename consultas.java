package Clases;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.toedter.calendar.JDateChooser;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class consultas {

    // Declaramos la conexion a mysql
    public static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "Pokepikachu2003";
    private static final String URL = "jdbc:mysql://localhost:3306/Biblioteca?autoReconnect=true&useSSL=false";

    public Connection conectar() {
        con = null;
        try {
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            if (con != null) {
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
        return con;
    }

    public void RellenaLaTablaConDatosMySQL(String tabla, JTable visor) {
        String sql = "Select * from " + tabla;
        Statement st;
        Connection conexion = conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Libro");
        model.addColumn("Título");
        model.addColumn("Editorial");
        model.addColumn("Año");

        visor.setModel(model);
        String[] dato = new String[4];
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                model.addRow(dato);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    private void mostrarMensajeError(String mensaje) {
        JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void leerLectores(String tabla, JTable visor) {
        String sql = "Select * from " + tabla;
        Statement st;
        Connection conexion = conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Lector");
        model.addColumn("Nombre");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
        model.addColumn("Ciudad");
        model.addColumn("Correo");
        visor.setModel(model);
        String[] dato = new String[6];
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);
                dato[5] = rs.getString(6);
                model.addRow(dato);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void leerSalidas(String tabla, JTable visor) {
        String sql = "Select * from " + tabla;
        Statement st;
        Connection conexion = conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Salida");
        model.addColumn("Fecha préstamo");
        model.addColumn("Fecha regreso");
        model.addColumn("Observación");
        model.addColumn("ID_Libro");
        model.addColumn("ID_Usuario");
        visor.setModel(model);
        String[] dato = new String[6];
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);
                dato[5] = rs.getString(6);
                model.addRow(dato);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void InsertarSalida(JDateChooser fechaSalida, JDateChooser fechaRegreso, JTextField observacion, JTextField idLibro, JTextField idUsuario) {
        java.util.Date javadateSalida = fechaSalida.getDate();
        java.util.Date javadateRegreso = fechaRegreso.getDate();

        long dateToLongFechaSalida = javadateSalida.getTime();
        long dateToLongFechaRegreso = javadateRegreso.getTime();

        java.sql.Date sqldateFechaSalida = new java.sql.Date(dateToLongFechaSalida);
        java.sql.Date sqldateFechaRegreso = new java.sql.Date(dateToLongFechaRegreso);

        if (!javadateSalida.after(javadateRegreso)) {
            try {

                Connection conecta = conectar();
                CallableStatement proc = conecta.prepareCall("CALL SP_INSERTARSALIDA(?,?,?,?,?)");
                proc.setDate(1, sqldateFechaSalida);
                proc.setDate(2, sqldateFechaRegreso);
                proc.setString(3, observacion.getText());
                proc.setInt(4, Integer.parseInt(idLibro.getText()));
                proc.setInt(5, Integer.parseInt(idUsuario.getText()));
                proc.execute();
                JOptionPane.showMessageDialog(null, "Salida registrada exitosamente.");
            } catch (MySQLIntegrityConstraintViolationException e) {
                // Manejo de la excepción específica para la restricción de clave externa
                mostrarMensajeError("El ID de usuario introducido no corresponde con ningún usuario registrado.");
            } catch (SQLException e) {
                // Manejo de otras excepciones de SQL
                mostrarMensajeError("Error al registrar la salida: " + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "La fecha de salida no puede ser más tardía a la fecha de devolución");
        }

    }

    public void InsertarLibro(JTextField titulo, JTextField editorial, JTextField anio) {
        try {
            Connection conecta = conectar();
            CallableStatement proc = conecta.prepareCall(" CALL SP_INSERTALIBRO(?,?,?)");
            proc.setString(1, titulo.getText());
            proc.setString(2, editorial.getText());
            proc.setString(3, anio.getText());
            proc.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void InsertarUsuario(JTextField nombre, JTextField direccion, JTextField telefono, JTextField ciudad, JTextField correo) {
        try {
            Connection conecta = conectar();
            CallableStatement proc = conecta.prepareCall(" CALL SP_INSERTAUSUARIO(?,?,?,?,?)");
            proc.setString(1, nombre.getText());
            proc.setString(2, direccion.getText());
            proc.setString(3, telefono.getText());
            proc.setString(4, ciudad.getText());
            proc.setString(5, correo.getText());
            proc.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void EliminaRegistro(String id, String tabla, String id_name) {
        String sql = "delete from " + tabla + " where " + id_name + " = " + id;
        Statement st;
        Connection conexion = conectar();
        try {
            st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void ActualizarLibro(JTextField titulo, JTextField editorial, JTextField anio, String id) {
        String sqlSelect = "SELECT titulo, editorial, anio FROM libro WHERE id_libro = " + id;
        String sqlUpdate = "UPDATE libro SET titulo = '" + titulo.getText() + "', editorial = '" + editorial.getText() + "', anio = '" + anio.getText() + "' WHERE id_libro = " + id;
        Statement st;
        Connection conexion = conectar();

        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {
                String currentTitulo = rs.getString("titulo");
                String currentEditorial = rs.getString("editorial");
                String currentAnio = rs.getString("anio");

                if (currentTitulo.equals(titulo.getText()) && currentEditorial.equals(editorial.getText()) && currentAnio.equals(anio.getText())) {
                    JOptionPane.showMessageDialog(null, "Debe cambiar al menos uno de los campos para actualizar el libro.");
                } else {
                    st.executeUpdate(sqlUpdate);
                    JOptionPane.showMessageDialog(null, "Libro Actualizado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Libro no encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    public void ActualizarUsuario(JTextField nombre, JTextField direccion, JTextField telefono, JTextField ciudad, JTextField correo, String id) {
        String sqlSelect = "SELECT nombre, direccion, telefono, ciudad, correo FROM usuario WHERE id_usuario = " + id;
        String sqlUpdate = "UPDATE usuario SET nombre = '" + nombre.getText() + "', direccion = '" + direccion.getText() + "', telefono = '" + telefono.getText() + "', ciudad = '" + ciudad.getText() + "', correo = '" + correo.getText() + "' WHERE id_usuario = " + id;
        Statement st;
        Connection conexion = conectar();

        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {
                String currentNombre = rs.getString("nombre");
                String currentDireccion = rs.getString("direccion");
                String currentTelefono = rs.getString("telefono");
                String currentCiudad = rs.getString("ciudad");
                String currentCorreo = rs.getString("correo");

                if (currentNombre.equals(nombre.getText())
                        && currentDireccion.equals(direccion.getText())
                        && currentTelefono.equals(telefono.getText())
                        && currentCiudad.equals(ciudad.getText())
                        && currentCorreo.equals(correo.getText())) {
                    JOptionPane.showMessageDialog(null, "Debe cambiar al menos uno de los campos para actualizar el usuario.");
                } else {
                    st.executeUpdate(sqlUpdate);
                    JOptionPane.showMessageDialog(null, "Usuario Actualizado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    public boolean tienePrestamos(String idUsuario) {
        boolean tienePrestamos = false;
        String query = "SELECT COUNT(*) FROM salida WHERE fk_usuario = ?";

        try (Connection conn = this.conectar(); PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(query)) {
            pstmt.setString(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                tienePrestamos = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tienePrestamos;
    }

}
