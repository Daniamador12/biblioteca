package PrimerParcial;

import Clases.consultas;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProyectoBiblioteca extends javax.swing.JFrame {

    consultas con = new consultas();

    public ProyectoBiblioteca() {
        initComponents();
        this.setLocationRelativeTo(null);
        con.RellenaLaTablaConDatosMySQL("libro", tablaLibros);
        con.leerLectores("usuario", tablaLectores);
        con.leerSalidas("salida", tablaSalidas);
        /*Para evitar errores, desactivamos la opción de que puedan usar el input para seleccionar
        el texto y limitamos a que solo puedan usar el calendario desplegable*/
        dcFechaPrestamo.getJCalendar().setSelectableDateRange(null, null);
        dcFechaDevo.getJCalendar().setSelectableDateRange(null, null);

        tablaLibros.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    inputTituloLibro.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1).toString());
                    inputEditorialLibro.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 2).toString());
                    inputAnioLibro.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 3).toString());
                }
            }
        });
        panelPestanas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int indexSelected = panelPestanas.getSelectedIndex();
                switch (indexSelected) {
                    case 0:
                    case 1:
                        if (!btnEliminar.isVisible() && !btnActualizar.isVisible()) {
                            btnEliminar.setVisible(true);
                            btnActualizar.setVisible(true);
                        }
                        break;
                    case 2:
                        btnEliminar.setVisible(false);
                        btnActualizar.setVisible(false);
                        break;
                }
            }
        });

        tablaLectores.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    inputNombreLector.setText(tablaLectores.getValueAt(tablaLectores.getSelectedRow(), 1).toString());
                    inputDireccionLector.setText(tablaLectores.getValueAt(tablaLectores.getSelectedRow(), 2).toString());
                    inputTelefonoLector.setText(tablaLectores.getValueAt(tablaLectores.getSelectedRow(), 3).toString());
                    inputCiudadLector.setText(tablaLectores.getValueAt(tablaLectores.getSelectedRow(), 4).toString());
                    inputCorreoLector.setText(tablaLectores.getValueAt(tablaLectores.getSelectedRow(), 5).toString());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdministracion = new javax.swing.JPanel();
        panelPestanas = new javax.swing.JTabbedPane();
        panelLibros = new javax.swing.JPanel();
        mostrarLibros = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        datosLibros = new javax.swing.JPanel();
        lblTituloLibro = new java.awt.Label();
        lblEditorialLibro = new java.awt.Label();
        lblAnioLibro = new java.awt.Label();
        lblLibros = new java.awt.Label();
        inputTituloLibro = new javax.swing.JTextField();
        inputEditorialLibro = new javax.swing.JTextField();
        inputAnioLibro = new javax.swing.JTextField();
        panelLectores = new javax.swing.JPanel();
        mostrarLectores = new javax.swing.JScrollPane();
        tablaLectores = new javax.swing.JTable();
        datosLectores = new javax.swing.JPanel();
        lblLectores = new javax.swing.JLabel();
        lblNombreLector = new javax.swing.JLabel();
        lblTelefonoLector = new javax.swing.JLabel();
        lblDireccionLector = new javax.swing.JLabel();
        lblCiudadLector = new javax.swing.JLabel();
        lblCorreoLector = new javax.swing.JLabel();
        inputDireccionLector = new javax.swing.JTextField();
        inputNombreLector = new javax.swing.JTextField();
        inputCiudadLector = new javax.swing.JTextField();
        inputTelefonoLector = new javax.swing.JTextField();
        inputCorreoLector = new javax.swing.JTextField();
        panelPrestamos = new javax.swing.JPanel();
        datosLeyendo = new javax.swing.JPanel();
        lblPrestamos = new javax.swing.JLabel();
        lblLectorPrestamo = new javax.swing.JLabel();
        lblFechaPrestamo = new javax.swing.JLabel();
        lblLibroPrestamo = new javax.swing.JLabel();
        lblFechaDevoPrestamo = new javax.swing.JLabel();
        lblObservacionesPrestamo = new javax.swing.JLabel();
        inputLibroPrestamo = new javax.swing.JTextField();
        inputLectorPrestamo = new javax.swing.JTextField();
        inputObservacionesPrestamo = new javax.swing.JTextField();
        dcFechaPrestamo = new com.toedter.calendar.JDateChooser();
        dcFechaDevo = new com.toedter.calendar.JDateChooser();
        mostrarSalidas = new javax.swing.JScrollPane();
        tablaSalidas = new javax.swing.JTable();
        lblAdmin = new java.awt.Label();
        panelBotones = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBorrarCampos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAdministracion.setBackground(new java.awt.Color(153, 153, 255));

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        mostrarLibros.setViewportView(tablaLibros);

        datosLibros.setBackground(new java.awt.Color(255, 255, 102));

        lblTituloLibro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTituloLibro.setText("Titulo");

        lblEditorialLibro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEditorialLibro.setText("Editorial");

        lblAnioLibro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblAnioLibro.setText("Año");

        lblLibros.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLibros.setText("Datos para libro");

        inputTituloLibro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        inputEditorialLibro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        inputAnioLibro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout datosLibrosLayout = new javax.swing.GroupLayout(datosLibros);
        datosLibros.setLayout(datosLibrosLayout);
        datosLibrosLayout.setHorizontalGroup(
            datosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLibrosLayout.createSequentialGroup()
                        .addComponent(lblTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(inputTituloLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
                    .addGroup(datosLibrosLayout.createSequentialGroup()
                        .addComponent(lblLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 538, Short.MAX_VALUE))
                    .addGroup(datosLibrosLayout.createSequentialGroup()
                        .addComponent(lblEditorialLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputEditorialLibro))
                    .addGroup(datosLibrosLayout.createSequentialGroup()
                        .addComponent(lblAnioLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(inputAnioLibro)))
                .addContainerGap())
        );
        datosLibrosLayout.setVerticalGroup(
            datosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLibrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(datosLibrosLayout.createSequentialGroup()
                        .addGroup(datosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(datosLibrosLayout.createSequentialGroup()
                                .addComponent(lblLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(lblTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(lblEditorialLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputEditorialLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(datosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAnioLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputAnioLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLibrosLayout = new javax.swing.GroupLayout(panelLibros);
        panelLibros.setLayout(panelLibrosLayout);
        panelLibrosLayout.setHorizontalGroup(
            panelLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datosLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLibrosLayout.setVerticalGroup(
            panelLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(datosLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLibrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPestanas.addTab("Libros", panelLibros);

        tablaLectores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        mostrarLectores.setViewportView(tablaLectores);

        datosLectores.setBackground(new java.awt.Color(255, 255, 102));

        lblLectores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLectores.setText("Datos para usuario");

        lblNombreLector.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombreLector.setText("Nombre");

        lblTelefonoLector.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefonoLector.setText("Telefono");

        lblDireccionLector.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDireccionLector.setText("Dirección");

        lblCiudadLector.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCiudadLector.setText("Ciudad");

        lblCorreoLector.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCorreoLector.setText("Correo");

        inputDireccionLector.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        inputNombreLector.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        inputCiudadLector.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        inputTelefonoLector.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        inputCorreoLector.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        javax.swing.GroupLayout datosLectoresLayout = new javax.swing.GroupLayout(datosLectores);
        datosLectores.setLayout(datosLectoresLayout);
        datosLectoresLayout.setHorizontalGroup(
            datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLectoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLectoresLayout.createSequentialGroup()
                        .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefonoLector)
                            .addComponent(lblCiudadLector)
                            .addComponent(lblCorreoLector)
                            .addComponent(lblDireccionLector))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputDireccionLector)
                            .addComponent(inputCorreoLector)
                            .addComponent(inputCiudadLector)
                            .addComponent(inputTelefonoLector)))
                    .addGroup(datosLectoresLayout.createSequentialGroup()
                        .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLectores, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(datosLectoresLayout.createSequentialGroup()
                                .addComponent(lblNombreLector)
                                .addGap(18, 18, 18)
                                .addComponent(inputNombreLector, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        datosLectoresLayout.setVerticalGroup(
            datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLectoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLectores)
                .addGap(18, 18, 18)
                .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreLector)
                    .addComponent(inputNombreLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionLector)
                    .addComponent(inputDireccionLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonoLector)
                    .addComponent(inputTelefonoLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiudadLector)
                    .addComponent(inputCiudadLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreoLector)
                    .addComponent(inputCorreoLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLectoresLayout = new javax.swing.GroupLayout(panelLectores);
        panelLectores.setLayout(panelLectoresLayout);
        panelLectoresLayout.setHorizontalGroup(
            panelLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLectoresLayout.createSequentialGroup()
                .addComponent(mostrarLectores, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datosLectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLectoresLayout.setVerticalGroup(
            panelLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(datosLectores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mostrarLectores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        panelPestanas.addTab("Lectores", panelLectores);

        datosLeyendo.setBackground(new java.awt.Color(255, 255, 102));

        lblPrestamos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPrestamos.setText("Datos para préstamo");

        lblLectorPrestamo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLectorPrestamo.setText("ID Lector");

        lblFechaPrestamo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFechaPrestamo.setText("Fecha Préstamo");

        lblLibroPrestamo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLibroPrestamo.setText("ID Libro");

        lblFechaDevoPrestamo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFechaDevoPrestamo.setText("Fecha Devolución");

        lblObservacionesPrestamo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblObservacionesPrestamo.setText("Observaciones");

        inputLibroPrestamo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        inputLectorPrestamo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        dcFechaPrestamo.setFocusable(false);
        dcFechaPrestamo.setMaxSelectableDate(new java.util.Date(1717023716000L));
        dcFechaPrestamo.setMinSelectableDate(new java.util.Date(915148916000L));

        dcFechaDevo.setMaxSelectableDate(new java.util.Date(1717023662000L));
        dcFechaDevo.setMinSelectableDate(new java.util.Date(915148862000L));

        javax.swing.GroupLayout datosLeyendoLayout = new javax.swing.GroupLayout(datosLeyendo);
        datosLeyendo.setLayout(datosLeyendoLayout);
        datosLeyendoLayout.setHorizontalGroup(
            datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLeyendoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLeyendoLayout.createSequentialGroup()
                        .addComponent(lblPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(datosLeyendoLayout.createSequentialGroup()
                        .addGroup(datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaPrestamo)
                            .addComponent(lblFechaDevoPrestamo)
                            .addComponent(lblObservacionesPrestamo)
                            .addComponent(lblLibroPrestamo)
                            .addComponent(lblLectorPrestamo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputLibroPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(inputLectorPrestamo)
                            .addComponent(inputObservacionesPrestamo)
                            .addComponent(dcFechaPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcFechaDevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        datosLeyendoLayout.setVerticalGroup(
            datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLeyendoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrestamos)
                .addGap(18, 18, 18)
                .addGroup(datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLectorPrestamo)
                    .addComponent(inputLectorPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLibroPrestamo)
                    .addComponent(inputLibroPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaPrestamo)
                    .addComponent(dcFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaDevoPrestamo)
                    .addComponent(dcFechaDevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosLeyendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObservacionesPrestamo)
                    .addComponent(inputObservacionesPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        mostrarSalidas.setViewportView(tablaSalidas);

        javax.swing.GroupLayout panelPrestamosLayout = new javax.swing.GroupLayout(panelPrestamos);
        panelPrestamos.setLayout(panelPrestamosLayout);
        panelPrestamosLayout.setHorizontalGroup(
            panelPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrestamosLayout.createSequentialGroup()
                .addGap(702, 702, 702)
                .addComponent(datosLeyendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrestamosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mostrarSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(594, Short.MAX_VALUE)))
        );
        panelPrestamosLayout.setVerticalGroup(
            panelPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrestamosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datosLeyendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrestamosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mostrarSalidas, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelPestanas.addTab("Leyendo", panelPrestamos);

        lblAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setText("Panel de administración");

        panelBotones.setBackground(new java.awt.Color(102, 255, 102));

        btnActualizar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBorrarCampos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBorrarCampos.setText("Limpiar campos");
        btnBorrarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelAdministracionLayout = new javax.swing.GroupLayout(panelAdministracion);
        panelAdministracion.setLayout(panelAdministracionLayout);
        panelAdministracionLayout.setHorizontalGroup(
            panelAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPestanas)
                    .addGroup(panelAdministracionLayout.createSequentialGroup()
                        .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAdministracionLayout.setVerticalGroup(
            panelAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministracionLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        int indexSelect = panelPestanas.getSelectedIndex();
        switch (indexSelect) {
            case 0:
                con.InsertarLibro(inputTituloLibro, inputEditorialLibro, inputAnioLibro);
                con.RellenaLaTablaConDatosMySQL("libro", tablaLibros);
                break;
            case 1:
                con.InsertarUsuario(inputNombreLector, inputDireccionLector, inputTelefonoLector, inputCiudadLector, inputCorreoLector);
                con.leerLectores("usuario", tablaLectores);
                break;
            case 2:
                con.InsertarSalida(dcFechaPrestamo, dcFechaDevo, inputObservacionesPrestamo, inputLibroPrestamo, inputLectorPrestamo);
                con.leerSalidas("salida", tablaSalidas);
                break;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int indexSelect = panelPestanas.getSelectedIndex();
        switch (indexSelect) {
            case 0:
                int selectedRowBook = tablaLibros.getSelectedRow();
                if (selectedRowBook != -1) {
                    String id = tablaLibros.getValueAt(selectedRowBook, 0).toString();
                    con.ActualizarLibro(inputTituloLibro, inputEditorialLibro, inputAnioLibro, id);
                    con.RellenaLaTablaConDatosMySQL("libro", tablaLibros);
                    BorrarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Ha de seleccionar la fila a actualizar.");
                }
                break;

            case 1:
                int selectedRowUser = tablaLectores.getSelectedRow();
                if (selectedRowUser != -1) {
                    String idUsuario = tablaLectores.getValueAt(selectedRowUser, 0).toString();
                    con.ActualizarUsuario(inputNombreLector, inputDireccionLector, inputTelefonoLector, inputCiudadLector, inputCorreoLector, idUsuario);
                    con.leerLectores("usuario", tablaLectores);
                    BorrarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Ha de seleccionar la fila a actualizar.");
                }
                break;
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int indexSelect = panelPestanas.getSelectedIndex();
        switch (indexSelect) {
            case 0:
                int selectedRow = tablaLibros.getSelectedRow();
                if (selectedRow != -1) {
                    String id = tablaLibros.getValueAt(selectedRow, 0).toString();
                    con.EliminaRegistro("id_libro", "libro", id);
                    con.RellenaLaTablaConDatosMySQL("libro", tablaLibros);
                    BorrarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Ha de seleccionar la fila que desea borrar.");
                }
                break;
            case 1:
                int selectedRowUser = tablaLectores.getSelectedRow();
                if (selectedRowUser != -1) {
                    String idUsuario = tablaLectores.getValueAt(selectedRowUser, 0).toString();
                    if (con.tienePrestamos(idUsuario)) {
                        JOptionPane.showMessageDialog(null, "No se puede eliminar el usuario porque tiene préstamos asignados.");
                    } else {
                        con.EliminaRegistro("id_usuario", "usuario", idUsuario);
                        con.leerLectores("usuario", tablaLectores);
                        BorrarCampos();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ha de seleccionar la fila que desea borrar");
                }
                break;
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void BorrarCampos() {
        inputTituloLibro.setText("");
        inputEditorialLibro.setText("");
        inputAnioLibro.setText("");
        inputNombreLector.setText("");
        inputDireccionLector.setText("");
        inputTelefonoLector.setText("");
        inputCiudadLector.setText("");
        inputCorreoLector.setText("");
    }
    private void btnBorrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCamposActionPerformed
        BorrarCampos();
    }//GEN-LAST:event_btnBorrarCamposActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProyectoBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrarCampos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel datosLectores;
    private javax.swing.JPanel datosLeyendo;
    private javax.swing.JPanel datosLibros;
    private com.toedter.calendar.JDateChooser dcFechaDevo;
    private com.toedter.calendar.JDateChooser dcFechaPrestamo;
    private javax.swing.JTextField inputAnioLibro;
    private javax.swing.JTextField inputCiudadLector;
    private javax.swing.JTextField inputCorreoLector;
    private javax.swing.JTextField inputDireccionLector;
    private javax.swing.JTextField inputEditorialLibro;
    private javax.swing.JTextField inputLectorPrestamo;
    private javax.swing.JTextField inputLibroPrestamo;
    private javax.swing.JTextField inputNombreLector;
    private javax.swing.JTextField inputObservacionesPrestamo;
    private javax.swing.JTextField inputTelefonoLector;
    private javax.swing.JTextField inputTituloLibro;
    private java.awt.Label lblAdmin;
    private java.awt.Label lblAnioLibro;
    private javax.swing.JLabel lblCiudadLector;
    private javax.swing.JLabel lblCorreoLector;
    private javax.swing.JLabel lblDireccionLector;
    private java.awt.Label lblEditorialLibro;
    private javax.swing.JLabel lblFechaDevoPrestamo;
    private javax.swing.JLabel lblFechaPrestamo;
    private javax.swing.JLabel lblLectorPrestamo;
    private javax.swing.JLabel lblLectores;
    private javax.swing.JLabel lblLibroPrestamo;
    private java.awt.Label lblLibros;
    private javax.swing.JLabel lblNombreLector;
    private javax.swing.JLabel lblObservacionesPrestamo;
    private javax.swing.JLabel lblPrestamos;
    private javax.swing.JLabel lblTelefonoLector;
    private java.awt.Label lblTituloLibro;
    private javax.swing.JScrollPane mostrarLectores;
    private javax.swing.JScrollPane mostrarLibros;
    private javax.swing.JScrollPane mostrarSalidas;
    private javax.swing.JPanel panelAdministracion;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelLectores;
    private javax.swing.JPanel panelLibros;
    private javax.swing.JTabbedPane panelPestanas;
    private javax.swing.JPanel panelPrestamos;
    private javax.swing.JTable tablaLectores;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTable tablaSalidas;
    // End of variables declaration//GEN-END:variables
}
