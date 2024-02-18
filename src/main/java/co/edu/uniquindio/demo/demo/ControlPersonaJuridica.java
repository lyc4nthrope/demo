package co.edu.uniquindio.demo.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.*;
public class ControlPersonaJuridica implements Initializable {
    ArrayList<PersonaJuridica> listaClientesJuridicos =CrudJuridico.leerClienteJuridico();
    @FXML
    private TableColumn<PersonaJuridica, String> jurApellido;

    @FXML
    private TableColumn<PersonaJuridica, String> jurDireccion;

    @FXML
    private TableColumn<PersonaJuridica, String> jurID;

    @FXML
    private TableColumn<PersonaJuridica, String> jurNit;

    @FXML
    private TableColumn<PersonaJuridica, String> jurNombre;

    @FXML
    private TableColumn<PersonaJuridica, String> jurTelefono;

    @FXML
    private TableView<PersonaJuridica> tablaJuridicos;

   ObservableList<PersonaJuridica> listaClientesJuridicosObservable = FXCollections.observableList(listaClientesJuridicos);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jurNombre.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("nombre"));
        jurApellido.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("apellidos"));
        jurID.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("identificacion"));
        jurDireccion.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("direccion"));
        jurTelefono.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("telefono"));
        jurNit.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("nit"));
        listaClientesJuridicos =CrudJuridico.leerClienteJuridico();
        tablaJuridicos.setItems(listaClientesJuridicosObservable);
    }

    public void agregarPersonaJuridica(ActionEvent event){
        String nombre = textNombre.getText();
        String apellido = textApellido.getText();
        String identificacion = textID.getText();
        String direccion = textDireccion.getText();
        String telefono = textTelefono.getText();
        String nit = textNit.getText();
        textNombre.setText("");textApellido.setText("");textID.setText("");
        textDireccion.setText("");textTelefono.setText("");textNit.setText("");
        PersonaJuridica clienteJuridico = new PersonaJuridica(nombre,apellido,identificacion,direccion,telefono,nit);
        CrudJuridico.crearClientesJuridico(clienteJuridico);

      actualizar();
    }


    @FXML
    private TextField textApellido;

    @FXML
    private TextField textDireccion;

    @FXML
    private TextField textID;

    @FXML
    private TextField textNit;

    @FXML
    private TextField textNombre;

    @FXML
    private TextField textTelefono;

    @FXML
    void switchScena1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScenaClienteJuridico.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void eliminarClienteJuridico(){
        String id = JOptionPane.showInputDialog("Ingrese la identificacion de la persona a eliminar");
        CrudJuridico.eliminarClienteJuri(id);

        actualizar();
    }

    public void actualizar(){
        listaClientesJuridicos =CrudJuridico.leerClienteJuridico();
        listaClientesJuridicosObservable = FXCollections.observableList(listaClientesJuridicos);
        tablaJuridicos.setItems(listaClientesJuridicosObservable);
    }

}

