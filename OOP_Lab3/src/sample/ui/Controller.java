package sample.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Transformation;
import sample.furniture.engine.Engine;
import sample.furniture.engine.HeavyEngine;
import sample.furniture.engine.LightEngine;
import sample.furniture.furniture.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    ListView<Furniture> listView;
    ObservableList<Furniture> listTransport;

    @FXML
    ComboBox<Furniture> cb_transport;
    ObservableList<Furniture> transport;

    @FXML
    Button btn_add;

    @FXML
    RadioButton radio_engine1;
    Engine engine1 = LightEngine.getEngine();

    @FXML
    RadioButton radio_engine2;
    Engine engine2 = HeavyEngine.getEngine();

    @FXML
    TextField tf_model;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        read();
        ToggleGroup group = new ToggleGroup();
        radio_engine1.setToggleGroup(group);
        radio_engine2.setToggleGroup(group);

        transport = FXCollections.observableArrayList(
                new Table(), new Chair(), new Wardrobe(),
                new Bed(), new Door(), new Bench());
        cb_transport.setItems(transport);
        btn_add.setOnMousePressed(event -> {
            String model = tf_model.getText();
            if (cb_transport.getValue() != null && model != null) {
                Engine engine = engine1;
                if (radio_engine2.isSelected())
                    engine = engine2;
                Furniture newTransport = cb_transport.getValue().create(model, engine);
                listTransport.add(newTransport);
                try {
                    write();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        listView.setItems(listTransport);
        listView.setCellFactory(param -> new XCell());
    }

    public void read() throws IOException, ClassNotFoundException {
        try {
            listTransport = FXCollections.observableArrayList();
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList list = (ArrayList) objectInputStream.readObject();
            for (int i = 0; i < list.size(); i++) {
                listTransport.add((Furniture) list.get(i));
            }
            objectInputStream.close();



//        FileInputStream fileInputStream = new FileInputStream("file.xml");
//        XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
//        ArrayList list = (ArrayList) xmlDecoder.readObject();
//        for (int i = 0; i < list.size(); i++) {
//            listTransport.add((Vehicle) list.get(i));
//        }
//        xmlDecoder.close();


//        ObjectMapper objectMapper = new ObjectMapper();
//        FileInputStream inputStream = new FileInputStream("file.json");
//        ObservableList<Vehicle> list = FXCollections.observableList(new ArrayList<Vehicle>(objectMapper.readValue(inputStream, ArrayList.class)));
//        listTransport.addAll(list);
    }catch (Exception e){
    }
    }

    private void write() throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            List<Furniture> list = new ArrayList<>(listTransport);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            int nom = 0;
            for (int i = 0; i < listTransport.size(); i++) {
                File out = new File("XML/" + nom + ".xml");
                out.createNewFile();
                PrintWriter pw = new PrintWriter(out);
                String xml = listTransport.get(i).getXML();
                pw.write(xml);
                pw.close();
                ClassLoader loader = ObjectMapper.class.getClassLoader();
                Class<?> c = Class.forName("com.fasterxml.jackson.databind.ObjectMapper", true, loader);
                Transformation trans = new Transformation();
                String res = trans.transform(xml);
                File in = new File("JSON/" + nom + ".json");
                PrintWriter pw2 = new PrintWriter(in);
                pw2.write(res);
                pw2.close();
            }
            PrintWriter writer1 = new PrintWriter("file.xml");
            String xml = "";
            for (int i = 0; i < list.size(); i++) {
                xml += list.get(i).getXML();
            }
            writer1.write(xml);
            writer1.close();
            FileWriter writer = new FileWriter("text.txt");
            for (Furniture vehicle : list) {
                writer.write(vehicle.getFurnitureType());
                writer.write(" ");
                writer.write(vehicle.getFurnitureModel());
                writer.write(" ");
                writer.write(vehicle.getClass().toString());
                writer.write(" ");
                writer.write(vehicle.getWarranty());
                writer.write("\n");
                writer.flush();
            }

        }catch(Exception e){

        }
    }






}
