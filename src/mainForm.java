import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;

    private Menu menu = new Menu();

    public mainForm() {

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarPlato();
            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quemarDatos();
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPlatoModificar();
            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarPlato();
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPlatoEliminar();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPlato();
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodos();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPlatoOrdenamiento();
            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void ingresarPlato() {

        if (!textIngresoNombre.getText().isEmpty()) {

            if (!textIngresoPrecio.getText().isEmpty()) {

                if (!textIngresoCalorias.getText().isEmpty()) {

                    if (!textIngresoPreparacion.getText().isEmpty()) {

                        if (menu.ingresarPlato(textIngresoNombre.getText(), Double.parseDouble(textIngresoPrecio.getText()), Integer.parseInt(textIngresoCalorias.getText()), Integer.parseInt(textIngresoPreparacion.getText())) != null) {
                            textAIngresoPlatos.setText(menu.imprimirMenu());
                        } else {
                            JOptionPane.showMessageDialog(null, "Error. El plato ya ha sido agregado");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error. El campo tiempo de preparacion esta vacio");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Error. El campo calorias esta vacio");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error. El campo precio esta vacio");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error. El campo nombre esta vacio");
        }
    }

    public void buscarPlatoModificar(){
        if (!textoModifNombre.getText().isEmpty()) {

            if(Ordenamiento.busquedaSecuencialNombre(textoModifNombre.getText(), menu.getPlatos()) != -1){
                textoModifPrecio.setEditable(true);
                textoModifCalorias.setEditable(true);
                textoModifPreparacion.setEditable(true);
                modificarModifButton.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error. No se ha encontrado el plato.");
                textoModifPrecio.setEditable(false);
                textoModifCalorias.setEditable(false);
                textoModifPreparacion.setEditable(false);

                textoModifPrecio.setText("");
                textoModifCalorias.setText("");
                textoModifPreparacion.setText("");

                modificarModifButton.setEnabled(false);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Error. El campo nombre esta vacio");
        }

    }

    public void modificarPlato(){
        if (!textoModifNombre.getText().isEmpty()) {
            if (!textoModifPrecio.getText().isEmpty()) {
                if (!textoModifCalorias.getText().isEmpty()) {
                    if (!textoModifPreparacion.getText().isEmpty()) {
                        int posPlato = Ordenamiento.busquedaSecuencialNombre(textoModifNombre.getText(), menu.getPlatos());

                        Plato plato = menu.modificarPlato(posPlato, Double.parseDouble(textoModifPrecio.getText()), Integer.parseInt(textoModifCalorias.getText()), Integer.parseInt(textoModifPreparacion.getText()));
                        textAModif.setText(plato.toString());

                        textoModifPrecio.setEditable(false);
                        textoModifCalorias.setEditable(false);
                        textoModifPreparacion.setEditable(false);

                        modificarModifButton.setEnabled(false);

                        textoModifPrecio.setText("");
                        textoModifCalorias.setText("");
                        textoModifPreparacion.setText("");
                        textoModifNombre.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error. El campo tiempo de preparacion esta vacio");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error. El campo calorias esta vacio");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error. El campo precio esta vacio");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error. El campo nombre esta vacio");
        }
    }

    public void buscarPlatoEliminar(){
        if (!textNombreEliminar.getText().isEmpty()) {
            int posPlato = Ordenamiento.busquedaSecuencialNombre(textNombreEliminar.getText(), menu.getPlatos());
            if(posPlato != -1){
                textAEliminar.setText(menu.getPlatos().get(posPlato).toString());
                eliminarButton.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error. No se ha encontrado el plato");
                eliminarButton.setEnabled(false);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error. El campo nombre esta vacio");
        }
    }

    public void quemarDatos(){
        menu.quemarDatos();
        textAIngresoPlatos.setText(menu.imprimirMenu());
    }

    public void eliminarPlato(){
        if (!textNombreEliminar.getText().isEmpty()) {
            int posPlato = Ordenamiento.busquedaSecuencialNombre(textNombreEliminar.getText(), menu.getPlatos());
            menu.eliminarPlato(posPlato);
            textAEliminar.setText("El plato se ha eliminado correctamente");
            eliminarButton.setEnabled(false);
            textNombreEliminar.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Error. El campo nombre esta vacio");
        }
    }

    public void mostrarTodos(){
        if (menu.getPlatos().size() > 0){
            if(comboBoxOrder.getSelectedItem().equals("ordenarPorNombre")){
                Ordenamiento.ordenarPorNombre(menu.getPlatos());
                textAMostrar.setText(menu.imprimirMenu());
            }else if(comboBoxOrder.getSelectedItem().equals("ordenarPorPrecio")){
                Ordenamiento.ordenarPorPrecio(menu.getPlatos());
                textAMostrar.setText(menu.imprimirMenu());
            }else if((comboBoxOrder.getSelectedItem().equals("ordenarPorCalorias"))){
                Ordenamiento.ordenarPorCalorias(menu.getPlatos());
                textAMostrar.setText(menu.imprimirMenu());
            }else if((comboBoxOrder.getSelectedItem().equals("ordenarPorTiempoPreparacion"))){
                Ordenamiento.ordenarPorTiempoPreparacion(menu.getPlatos());
                textAMostrar.setText(menu.imprimirMenu());
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay platos en el menu");
        }
    }

    public void buscarPlatoOrdenamiento(){

        if (menu.getPlatos().size() > 0){
            if(comboBoxOrder.getSelectedItem().equals("ordenarPorNombre")){
                Ordenamiento.ordenarPorNombre(menu.getPlatos());
                Plato p = Ordenamiento.busquedaBinariaPorNombre(textBuscarPlatoOrden.getText(), menu.getPlatos());
                if (p != null){
                    textAMostrar.setText(p.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado");
                }
            }else if(comboBoxOrder.getSelectedItem().equals("ordenarPorPrecio")){
                Ordenamiento.ordenarPorPrecio(menu.getPlatos());
                Plato p = Ordenamiento.busquedaBinariaPorPrecio(Double.parseDouble(textBuscarPlatoOrden.getText()), menu.getPlatos());
                if (p != null){
                    textAMostrar.setText(p.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado");
                }
            }else if((comboBoxOrder.getSelectedItem().equals("ordenarPorCalorias"))){
                Ordenamiento.ordenarPorCalorias(menu.getPlatos());
                Plato p = Ordenamiento.busquedaBinariaPorCalorias(Double.parseDouble(textBuscarPlatoOrden.getText()), menu.getPlatos());
                if (p != null){
                    textAMostrar.setText(p.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado");
                }
            }else if((comboBoxOrder.getSelectedItem().equals("ordenarPorTiempoPreparacion"))){
                Ordenamiento.ordenarPorTiempoPreparacion(menu.getPlatos());
                Plato p = Ordenamiento.busquedaBinariaPorTiempoPreparacion(Integer.parseInt(textBuscarPlatoOrden.getText()), menu.getPlatos());
                if (p != null){
                    textAMostrar.setText(p.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay platos en el menu");
        }

    }
}
